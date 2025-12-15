package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.rotgruengelb.titanium.world.gen.feature.config.NaturalArchFeatureConfig;

import java.util.ArrayList;
import java.util.List;

public class NaturalArchFeature extends Feature<NaturalArchFeatureConfig> {
    public NaturalArchFeature(Codec<NaturalArchFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NaturalArchFeatureConfig> context) {
        WorldGenLevel world = context.level();
        BlockPos start = context.origin();
        RandomSource random = context.random();
        NaturalArchFeatureConfig config = context.config();

        if (!world.getBlockState(start).is(config.targetTag())) return false;

        int maxHoriz = config.horizontalDistance().getMaxValue();
        int maxVert = config.verticalDistance().getMaxValue();
        int minHoriz = config.horizontalDistance().getMinValue();
        int minVert = config.verticalDistance().getMinValue();

        double minDistSq = minHoriz * minHoriz + minVert * minVert;
        double maxDistSq = maxHoriz * maxHoriz + maxVert * maxVert;

        List<BlockPos> candidates = new ArrayList<>();

        BlockPos.withinManhattan(start, maxHoriz, maxVert, maxHoriz).forEach(pos -> {
            if (pos.equals(start)) return;
            double distSq = start.distSqr(pos);
            if (distSq >= minDistSq && distSq <= maxDistSq) {
                if (world.getBlockState(pos).is(config.targetTag())) {
                    candidates.add(pos.immutable());
                }
            }
        });

        if (candidates.isEmpty()) return false;

        BlockPos end = candidates.get(random.nextInt(candidates.size()));

        drawArch(world, start, end, config, random);
        return true;
    }

    private void drawArch(WorldGenLevel world, BlockPos posA, BlockPos posB, NaturalArchFeatureConfig config, RandomSource random) {
        int dx = posB.getX() - posA.getX();
        int dz = posB.getZ() - posA.getZ();
        double distance = Math.sqrt(dx * dx + dz * dz);

        int steps = (int) distance * 2;

        int archHeight = 3 + random.nextInt(5);

        BlockPos lastCore = null;

        for (int i = 0; i <= steps; i++) {
            double t = (double) i / steps;

            double x = posA.getX() + dx * t;
            double z = posA.getZ() + dz * t;

            double yArch = -4 * archHeight * (t - 0.5) * (t - 0.5) + archHeight;
            double y = posA.getY() + (posB.getY() - posA.getY()) * t + yArch;

            int thickness = 1 + random.nextInt(config.thickness().sample(random));
            int px = (int) Math.round(x) + random.nextInt(2) - 1;
            int pz = (int) Math.round(z) + random.nextInt(2) - 1;
            int py = (int) Math.round(y) + random.nextInt(2) - 1;

            BlockPos core = new BlockPos((int) Math.round(x), (int) Math.round(y), (int) Math.round(z));
            placeAndDecorate(world, config, random, core);

            for (int wx = 0; wx < thickness; wx++) {
                for (int wz = 0; wz < thickness; wz++) {
                    BlockPos pos = new BlockPos(px + wx, py, pz + wz);
                    if (pos.equals(core)) continue;

                    placeAndDecorate(world, config, random, pos);
                }
            }

            if (lastCore != null && !lastCore.equals(core)) {
                int stepsBetween = Math.max(Math.abs(core.getX() - lastCore.getX()), Math.max(Math.abs(core.getY() - lastCore.getY()), Math.abs(core.getZ() - lastCore.getZ())));
                for (int j = 1; j < stepsBetween; j++) {
                    double lerp = j / (double) stepsBetween;
                    int ix = (int) Math.round(lastCore.getX() + (core.getX() - lastCore.getX()) * lerp);
                    int iy = (int) Math.round(lastCore.getY() + (core.getY() - lastCore.getY()) * lerp);
                    int iz = (int) Math.round(lastCore.getZ() + (core.getZ() - lastCore.getZ()) * lerp);
                    BlockPos fillPos = new BlockPos(ix, iy, iz);
                    world.setBlock(fillPos, config.block().getState(random, fillPos), Block.UPDATE_CLIENTS);
                }
            }
            lastCore = core;
        }
    }

    private void placeAndDecorate(WorldGenLevel world, NaturalArchFeatureConfig config, RandomSource random, BlockPos pos) {
        world.setBlock(pos, config.block().getState(random, pos), Block.UPDATE_CLIENTS);

        BlockPos above = pos.above();
        if (config.topDecorator() != null && isAirAt(world, above)) {
            BlockState topState = config.topDecorator().getState(random, above);
            world.setBlock(above, topState, Block.UPDATE_CLIENTS);
        }
    }

    private static boolean isAirAt(WorldGenLevel world, BlockPos pos) {
        try {
            return world.getBlockState(pos).isAir();
        } catch (Exception e) {
            return false;
        }
    }
}
