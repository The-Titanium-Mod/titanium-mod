package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
        Random random = context.getRandom();
        BlockPos origin = context.getOrigin();
        NaturalArchFeatureConfig config = context.getConfig();

        List<BlockPos> potentialTargets = new ArrayList<>();

        int maxRange = config.maxRange().get(random);
        int minY = config.minVerticalDelta().get(random);
        int maxY = config.maxVerticalDelta().get(random);

        for (int dx = -maxRange; dx <= maxRange; dx++) {
            for (int dz = -maxRange; dz <= maxRange; dz++) {
                if (dx == 0 && dz == 0) continue;

                for (int dy = minY; dy <= maxY; dy++) {
                    BlockPos target = origin.add(dx, dy, dz);
                    if (world.getBlockState(target).isIn(config.targetBlocks())) {
                        potentialTargets.add(target);
                    }
                }
            }
        }

        if (!potentialTargets.isEmpty()) {
            BlockPos chosenTarget = potentialTargets.get(random.nextInt(potentialTargets.size()));
            drawArch(world, origin, chosenTarget, config, random);
            return true;
        }

        return false;
    }

    private void drawArch(StructureWorldAccess world, BlockPos start, BlockPos end, NaturalArchFeatureConfig config, Random random) {
        int steps = 16;
        double height = config.archRadius().get(random);

        for (int i = 0; i <= steps; i++) {
            double t = i / (double) steps;
            double x = MathHelper.lerp(start.getX(), end.getX(), t);
            double z = MathHelper.lerp(start.getZ(), end.getZ(), t);
            double y = parabolicLerp(start.getY(), end.getY(), t, height);

            BlockPos pos = new BlockPos((int) x, (int) y, (int) z);

            for (int dx = -config.archThickness().get(random) / 2; dx <= config.archThickness().get(random) / 2; dx++) {
                for (int dz = -config.archThickness().get(random) / 2; dz <= config.archThickness().get(random) / 2; dz++) {
                    BlockPos offset = pos.add(dx, 0, dz);
                    if (config.placementPredicate().test(world, offset)) {
                        BlockState state = config.archBlockProvider().get(random, offset);
                        world.setBlockState(offset, state, Block.NOTIFY_LISTENERS);
                    }
                }
            }
        }
    }

    private double parabolicLerp(double a, double b, double t, double height) {
        return MathHelper.lerp(a, b, t) + (4 * height * t * (1 - t));
    }
}
