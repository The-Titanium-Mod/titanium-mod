package net.rotgruengelb.titanium.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public class WildwoodSaplingBlock extends SaplingBlock {

	public WildwoodSaplingBlock(TreeGrower generator, Properties settings) {
		super(generator, settings);
	}

	@Override
	protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
		return floor.is(TitaniumBlockTags.CLART_SOIL);
	}
}
