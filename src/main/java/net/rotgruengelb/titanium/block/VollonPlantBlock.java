package net.rotgruengelb.titanium.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public class VollonPlantBlock extends RootsBlock {

	public VollonPlantBlock(Properties settings) {
		super(settings);
	}

	@Override
	protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
		return floor.is(TitaniumBlockTags.VOLLON);
	}
}
