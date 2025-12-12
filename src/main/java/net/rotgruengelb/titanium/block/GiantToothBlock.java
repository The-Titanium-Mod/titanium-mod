package net.rotgruengelb.titanium.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.rotgruengelb.titanium.state.property.TitaniumProperties;
import org.jetbrains.annotations.Nullable;

public class GiantToothBlock extends TallSodPlantBlock {

	public static final BooleanProperty FLESHY = TitaniumProperties.FLESHY;

	public GiantToothBlock(Properties settings) {
		super(settings);
		this.registerDefaultState(this.defaultBlockState()
				.setValue(FLESHY, true));
	}

	public static boolean isBoneBlock(BlockGetter world, BlockPos pos) {
		return isBoneBlock(world.getBlockState(pos));
	}

	public static boolean isBoneBlock(BlockState blockState) {
		return blockState.is(Blocks.BONE_BLOCK);
	}


	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
		BlockState blockState = super.getStateForPlacement(ctx);
		if (blockState != null) {
			if (isBoneBlock(ctx.getLevel(), ctx.getClickedPos().below())) {
				return blockState.setValue(FLESHY, false);
			}
		}
		return blockState;
	}

	@Override
	protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
		return super.mayPlaceOn(floor, world, pos) || isBoneBlock(floor);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FLESHY);
	}
}
