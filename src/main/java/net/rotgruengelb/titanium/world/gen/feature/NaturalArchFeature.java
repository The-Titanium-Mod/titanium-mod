package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.List;

public class NaturalArchFeature extends Feature<NaturalArchFeatureConfig> {
    public NaturalArchFeature(Codec<NaturalArchFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<NaturalArchFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos start = context.getOrigin();
        Random random = context.getRandom();
        NaturalArchFeatureConfig config = context.getConfig();

        if (!world.getBlockState(start).isIn(config.targetTag())) return false;

        int maxHoriz = config.horizontalDistance().getMax();
        int maxVert = config.verticalDistance().getMax();
        int minHoriz = config.horizontalDistance().getMin();
        int minVert = config.verticalDistance().getMin();

        double minDistSq = minHoriz * minHoriz + minVert * minVert;
        double maxDistSq = maxHoriz * maxHoriz + maxVert * maxVert;

        List<BlockPos> candidates = new ArrayList<>();

        // Find all valid target blocks in posA hollow spherical shell
        BlockPos.iterateOutwards(start, maxHoriz, maxVert, maxHoriz).forEach(pos -> {
            if (pos.equals(start)) return;
            double distSq = start.getSquaredDistance(pos);
            if (distSq >= minDistSq && distSq <= maxDistSq) {
                if (world.getBlockState(pos).isIn(config.targetTag())) {
                    candidates.add(pos.toImmutable());
                }
            }
        });

        if (candidates.isEmpty()) return false;

        BlockPos end = candidates.get(random.nextInt(candidates.size()));

        drawArch(world, start, end, config, random);
        return true;
    }

    private void drawArch(StructureWorldAccess world, BlockPos posA, BlockPos posB, NaturalArchFeatureConfig config, Random random) {
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

            int width = 1 + random.nextInt(2);
            int px = (int) Math.round(x) + random.nextInt(2) - 1;
            int pz = (int) Math.round(z) + random.nextInt(2) - 1;
            int py = (int) Math.round(y) + random.nextInt(2) - 1;

            BlockPos core = new BlockPos((int) Math.round(x), (int) Math.round(y), (int) Math.round(z));
            placeAndDecorate(world, config, random, core);

            for (int wx = 0; wx < width; wx++) {
                for (int wz = 0; wz < width; wz++) {
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
                    world.setBlockState(fillPos, config.block().get(random, fillPos), Block.NOTIFY_LISTENERS);
                }
            }
            lastCore = core;
        }
    }

    private void placeAndDecorate(StructureWorldAccess world, NaturalArchFeatureConfig config, Random random, BlockPos pos) {
        world.setBlockState(pos, config.block().get(random, pos), Block.NOTIFY_LISTENERS);

        BlockPos above = pos.up();
        if (config.topDecorator() != null && world.isAir(above)) {
            BlockState topState = config.topDecorator().get(random, above);
            world.setBlockState(above, topState, Block.NOTIFY_LISTENERS);
        }
    }
}
