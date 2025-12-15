package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import net.rotgruengelb.titanium.world.gen.feature.config.TerrainDecorationFeatureConfig;

import static net.rotgruengelb.titanium.util.CommonVersioned.getWorldMinY;

public class TerrainDecorationFeature extends Feature<TerrainDecorationFeatureConfig> {
    public TerrainDecorationFeature(Codec<TerrainDecorationFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TerrainDecorationFeatureConfig> context) {
        WorldGenLevel structureWorldAccess = context.level();
        BlockPos originBlockPos = context.origin();
        TerrainDecorationFeatureConfig config = context.config();
        RandomSource random = context.random();
        final int spreadWith = config.spreadWidth().sample(random);
        final int spreadHeight = config.spreadHeight().sample(random);

        if (!config.predicate().test(structureWorldAccess, originBlockPos)) {
            return false;
        } else {
            int posY = originBlockPos.getY();
            if (posY >= getWorldMinY(structureWorldAccess) + 1 && posY + 1 < (getWorldMinY(structureWorldAccess) + structureWorldAccess.getHeight())) {
                int passes = 0;
                for (int k = 0; k < spreadHeight * spreadWith; k++) {
                    BlockPos blockPos = originBlockPos.offset(
                            random.nextInt(spreadWith) - random.nextInt(spreadWith),
                            random.nextInt(spreadHeight) - random.nextInt(spreadHeight),
                            random.nextInt(spreadWith) - random.nextInt(spreadWith)
                    );
                    BlockState blockState = config.decorator().getState(random, blockPos);
                    if (structureWorldAccess.isEmptyBlock(blockPos)
                            && blockPos.getY() > getWorldMinY(structureWorldAccess)
                            && blockState.canSurvive(structureWorldAccess, blockPos)) {
                        if (blockState.getBlock() instanceof DoublePlantBlock) {
                            DoublePlantBlock.placeAt(structureWorldAccess, blockState, blockPos, Block.UPDATE_CLIENTS);
                        } else {
                            structureWorldAccess.setBlock(blockPos, blockState, Block.UPDATE_CLIENTS);
                        }
                        passes++;
                    }
                }
                return passes > 0;
            } else {
                return false;
            }
        }
    }
}
