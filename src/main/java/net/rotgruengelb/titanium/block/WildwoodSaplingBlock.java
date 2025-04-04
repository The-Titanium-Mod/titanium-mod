package net.rotgruengelb.titanium.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public class WildwoodSaplingBlock extends SaplingBlock {

	public WildwoodSaplingBlock(SaplingGenerator generator, Settings settings) {
		super(generator, settings);
	}

	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
		return floor.isIn(TitaniumBlockTags.CLART);
	}
}
