package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rotgruengelb.titanium.world.gen.feature.config.UndergroundVeinsFeatureConfig;

public class UndergroundVeinsFeature extends Feature<UndergroundVeinsFeatureConfig> {

    public UndergroundVeinsFeature(Codec<UndergroundVeinsFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<UndergroundVeinsFeatureConfig> context) {
        WorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        UndergroundVeinsFeatureConfig config = context.getConfig();

        BlockPos.Mutable mutable = origin.mutableCopy();
        Direction[] horizontal = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        int steps = config.maxSteps().get(random);
        int maxDistance = config.maxDistanceFromOrigin().get(random);

        Direction currentDirection;

        for (int i = 0; i < steps; i++) {
            if (mutable.getManhattanDistance(origin) > maxDistance) {
                break;
            }

            if (world.getBlockState(mutable).isIn(config.replaceable())) {
                BlockState veinBlock = config.stateProvider().get(random, mutable);
                world.setBlockState(mutable, veinBlock, 2);
            }

            if (random.nextInt(100) < config.verticalStepChance().get(random)) {
                if (random.nextInt(100) < config.downwardStepChance().get(random)) {
                    mutable.move(Direction.DOWN);
                } else {
                    mutable.move(Direction.UP);
                }
            } else {
                currentDirection = horizontal[random.nextInt(horizontal.length)];
                mutable.move(currentDirection);
            }
        }

        return true;
    }
}