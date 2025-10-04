package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rotgruengelb.titanium.world.gen.feature.config.HangingBlobFeatureConfig;

public class HangingBlobFeature extends Feature<HangingBlobFeatureConfig> {

    public HangingBlobFeature(Codec<HangingBlobFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<HangingBlobFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        HangingBlobFeatureConfig config = context.getConfig();

        if (!world.isAir(origin)) {
            return false;
        }

        BlockState above = world.getBlockState(origin.up());
        if (!above.isIn(config.targetTag())) {
            return false;
        }

        BlockState initialState = config.blockProvider().get(random, origin);
        world.setBlockState(origin, initialState, Block.NOTIFY_LISTENERS);

        for (int i = 0; i < 1500; i++) {
            BlockPos targetPos = origin.add(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));

            if (world.getBlockState(targetPos).isAir()) {
                int adjacentCount = 0;

                for (Direction dir : Direction.values()) {
                    if (world.getBlockState(targetPos.offset(dir)).isOf(initialState.getBlock())) {
                        adjacentCount++;
                    }
                    if (adjacentCount > 1) {
                        break;
                    }
                }

                if (adjacentCount == 1) {
                    world.setBlockState(targetPos, config.blockProvider().get(random, targetPos), Block.NOTIFY_LISTENERS);

                    BlockPos abovePos = targetPos.up();
                    if (world.isAir(abovePos)) {
                        world.setBlockState(abovePos, config.topDecorator().get(random, abovePos), Block.NOTIFY_LISTENERS);
                    }

                    BlockPos belowPos = targetPos.down();
                    if (world.isAir(belowPos)) {
                        world.setBlockState(belowPos, config.bottomDecorator().get(random, belowPos), Block.NOTIFY_LISTENERS);
                    }
                }
            }
        }
        return true;
    }
}
