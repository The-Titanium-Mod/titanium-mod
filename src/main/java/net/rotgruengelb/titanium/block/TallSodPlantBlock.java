package net.rotgruengelb.titanium.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.rotgruengelb.titanium.registry.TitaniumModBlockTags;

public class TallSodPlantBlock extends TallPlantBlock {

	public TallSodPlantBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
		return floor.isIn(TitaniumModBlockTags.CLART);
	}
}
