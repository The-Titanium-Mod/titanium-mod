package net.rotgruengelb.titanium.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.rotgruengelb.titanium.state.property.TitaniumProperties;
import org.jetbrains.annotations.Nullable;

public class GiantToothBlock extends TallSodPlantBlock {

	public static final BooleanProperty FLESHY = TitaniumProperties.FLESHY;

	public GiantToothBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState()
				.with(FLESHY, true));
	}

	public static boolean isBoneBlock(BlockView world, BlockPos pos) {
		return isBoneBlock(world.getBlockState(pos));
	}

	public static boolean isBoneBlock(BlockState blockState) {
		return blockState.isOf(Blocks.BONE_BLOCK);
	}


	@Override
	public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
		BlockState blockState = super.getPlacementState(ctx);
		if (blockState != null) {
			if (isBoneBlock(ctx.getWorld(), ctx.getBlockPos().down())) {
				return blockState.with(FLESHY, false);
			}
		}
		return blockState;
	}

	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
		return super.canPlantOnTop(floor, world, pos) || isBoneBlock(floor);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(FLESHY);
	}
}
