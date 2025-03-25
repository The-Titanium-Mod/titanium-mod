package net.rotgruengelb.titanium.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RootsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.rotgruengelb.titanium.registry.TitaniumModBlockTags;

public class SodPlantBlock extends RootsBlock {

    public SodPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(TitaniumModBlockTags.CLART);
    }
}
