package net.rotgruengelb.titanium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rotgruengelb.titanium.world.gen.feature.config.TerrainDecorationFeatureConfig;

public class TerrainDecorationFeature extends Feature<TerrainDecorationFeatureConfig> {
    public TerrainDecorationFeature(Codec<TerrainDecorationFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<TerrainDecorationFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos originBlockPos = context.getOrigin();
        TerrainDecorationFeatureConfig config = context.getConfig();
        Random random = context.getRandom();
        final int spreadWith = config.spreadWidth().get(random);
        final int spreadHeight = config.spreadHeight().get(random);

        if (!config.predicate().test(structureWorldAccess, originBlockPos)) {
            return false;
        } else {
            int posY = originBlockPos.getY();
            if (posY >= structureWorldAccess.getBottomY() + 1 && posY + 1 < structureWorldAccess.getTopY()) {
                int passes = 0;
                for (int k = 0; k < spreadHeight * spreadWith; k++) {
                    BlockPos blockPos = originBlockPos.add(
                            random.nextInt(spreadWith) - random.nextInt(spreadWith),
                            random.nextInt(spreadHeight) - random.nextInt(spreadHeight),
                            random.nextInt(spreadWith) - random.nextInt(spreadWith)
                    );
                    BlockState blockState = config.decorator().get(random, blockPos);
                    if (structureWorldAccess.isAir(blockPos)
                            && blockPos.getY() > structureWorldAccess.getBottomY()
                            && blockState.canPlaceAt(structureWorldAccess, blockPos)) {
                        if (blockState.getBlock() instanceof TallPlantBlock) {
                            TallPlantBlock.placeAt(structureWorldAccess, blockState, blockPos, Block.NOTIFY_LISTENERS);
                        } else {
                            structureWorldAccess.setBlockState(blockPos, blockState, Block.NOTIFY_LISTENERS);
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
