package net.rotgruengelb.titanium.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.item.TitaniumItems;
import net.rotgruengelb.titanium.registry.tag.TitaniumFluidTags;
import net.rotgruengelb.titanium.world.TitaniumGameRules;

import java.util.Optional;

public abstract class BloodFluid extends FlowableFluid {
	@Override
	public Fluid getFlowing() {
		return TitaniumFluids.FLOWING_BLOOD;
	}

	@Override
	public Fluid getStill() {
		return TitaniumFluids.BLOOD;
	}

	@Override
	protected boolean isInfinite(World world) {
		return world.getGameRules()
				.getBoolean(TitaniumGameRules.BLOOD_SOURCE_CONVERSION);

	}

	@Override
	protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
		BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
		Block.dropStacks(state, world, pos, blockEntity);
	}

	@Override
	protected int getMaxFlowDistance(WorldView world) {
		return 3;
	}

	@Override
	protected int getLevelDecreasePerBlock(WorldView world) {
		return 2;
	}

	@Override
	public Item getBucketItem() {
		return TitaniumItems.BLOOD_BUCKET;
	}

	@Override
	protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(TitaniumFluidTags.BLOOD);
	}

	@Override
	public boolean matchesType(Fluid fluid) {
		return fluid == TitaniumFluids.BLOOD || fluid == TitaniumFluids.FLOWING_BLOOD;
	}

	@Override
	public int getTickRate(WorldView world) {
		return 5;
	}

	@Override
	protected float getBlastResistance() {
		return 100.0F;
	}

	@Override
	public Optional<SoundEvent> getBucketFillSound() {
		return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
	}

	@Override
	protected BlockState toBlockState(FluidState state) {
		return TitaniumBlocks.BLOOD.getDefaultState()
				.with(FluidBlock.LEVEL, getBlockStateLevel(state));
	}

	public static class Flowing extends BloodFluid {
		@Override
		protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
			super.appendProperties(builder);
			builder.add(LEVEL);
		}

		@Override
		public int getLevel(FluidState state) {
			return state.get(LEVEL);
		}

		@Override
		public boolean isStill(FluidState state) {
			return false;
		}
	}

	public static class Still extends BloodFluid {
		@Override
		public int getLevel(FluidState state) {
			return 8;
		}

		@Override
		public boolean isStill(FluidState state) {
			return true;
		}
	}
}
