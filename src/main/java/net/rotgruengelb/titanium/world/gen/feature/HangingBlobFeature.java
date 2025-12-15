package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.rotgruengelb.titanium.world.gen.feature.config.HangingBlobFeatureConfig;

public class HangingBlobFeature extends Feature<HangingBlobFeatureConfig> {

    public HangingBlobFeature(Codec<HangingBlobFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<HangingBlobFeatureConfig> context) {
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        HangingBlobFeatureConfig config = context.config();

        if (!world.isEmptyBlock(origin)) {
            return false;
        }

        BlockState above = world.getBlockState(origin.above());
        if (!above.is(config.targetTag())) {
            return false;
        }

        BlockState initialState = config.blockProvider().getState(random, origin);
        world.setBlock(origin, initialState, Block.UPDATE_CLIENTS);

        for (int i = 0; i < 1500; i++) {
            BlockPos targetPos = origin.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));

            if (world.getBlockState(targetPos).isAir()) {
                int adjacentCount = 0;

                for (Direction dir : Direction.values()) {
                    if (world.getBlockState(targetPos.relative(dir)).is(initialState.getBlock())) {
                        adjacentCount++;
                    }
                    if (adjacentCount > 1) {
                        break;
                    }
                }

                if (adjacentCount == 1) {
                    world.setBlock(targetPos, config.blockProvider().getState(random, targetPos), Block.UPDATE_CLIENTS);

                    BlockPos abovePos = targetPos.above();
                    if (world.isEmptyBlock(abovePos)) {
                        world.setBlock(abovePos, config.topDecorator().getState(random, abovePos), Block.UPDATE_CLIENTS);
                    }

                    BlockPos belowPos = targetPos.below();
                    if (world.isEmptyBlock(belowPos)) {
                        world.setBlock(belowPos, config.bottomDecorator().getState(random, belowPos), Block.UPDATE_CLIENTS);
                    }
                }
            }
        }
        return true;
    }
}
