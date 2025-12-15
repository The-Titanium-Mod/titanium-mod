package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.rotgruengelb.titanium.world.gen.feature.config.UndergroundVeinsFeatureConfig;

public class UndergroundVeinsFeature extends Feature<UndergroundVeinsFeatureConfig> {

    public UndergroundVeinsFeature(Codec<UndergroundVeinsFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<UndergroundVeinsFeatureConfig> context) {
        LevelAccessor world = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        UndergroundVeinsFeatureConfig config = context.config();

        BlockPos.MutableBlockPos mutable = origin.mutable();
        Direction[] horizontal = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        int steps = config.maxSteps().sample(random);
        int maxDistance = config.maxDistanceFromOrigin().sample(random);

        Direction currentDirection;

        for (int i = 0; i < steps; i++) {
            if (mutable.distManhattan(origin) > maxDistance) {
                break;
            }

            if (world.getBlockState(mutable).is(config.replaceable())) {
                BlockState veinBlock = config.stateProvider().getState(random, mutable);
                world.setBlock(mutable, veinBlock, 2);
            }

            if (random.nextInt(100) < config.verticalStepChance().sample(random)) {
                if (random.nextInt(100) < config.downwardStepChance().sample(random)) {
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
