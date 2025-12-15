package net.rotgruengelb.titanium.fluid;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.item.Item;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.item.TitaniumItems;
import net.rotgruengelb.titanium.registry.tag.TitaniumFluidTags;
import net.rotgruengelb.titanium.world.TitaniumGameRules;

import java.util.Optional;

public abstract class BloodFluid extends FlowingFluid {
	@Override
	public Fluid getFlowing() {
		return TitaniumFluids.FLOWING_BLOOD;
	}

	@Override
	public Fluid getSource() {
		return TitaniumFluids.BLOOD;
	}

    @Override
    //? if 1.21.1 {
    /*protected boolean canConvertToSource(Level world) {
    *///?} else {
    protected boolean canConvertToSource(ServerLevel world) {
    //?}
		return world.getGameRules()
				.getBoolean(TitaniumGameRules.BLOOD_SOURCE_CONVERSION);
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState state) {
		BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
		Block.dropResources(state, world, pos, blockEntity);
	}

	@Override
	protected int getSlopeFindDistance(LevelReader world) {
		return 3;
	}

	@Override
	protected int getDropOff(LevelReader world) {
		return 2;
	}

	@Override
	public Item getBucket() {
		return TitaniumItems.BLOOD_BUCKET;
	}

	@Override
	protected boolean canBeReplacedWith(FluidState state, BlockGetter world, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.is(TitaniumFluidTags.BLOOD);
	}

	@Override
	public boolean isSame(Fluid fluid) {
		return fluid == TitaniumFluids.BLOOD || fluid == TitaniumFluids.FLOWING_BLOOD;
	}

	@Override
	public int getTickDelay(LevelReader world) {
		return 5;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Optional.of(SoundEvents.BUCKET_FILL);
	}

	@Override
	protected BlockState createLegacyBlock(FluidState state) {
		return TitaniumBlocks.BLOOD.defaultBlockState()
				.setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
	}

	public static class Flowing extends BloodFluid {
		@Override
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		@Override
		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		@Override
		public boolean isSource(FluidState state) {
			return false;
		}
	}

	public static class Still extends BloodFluid {
		@Override
		public int getAmount(FluidState state) {
			return 8;
		}

		@Override
		public boolean isSource(FluidState state) {
			return true;
		}
	}
}
