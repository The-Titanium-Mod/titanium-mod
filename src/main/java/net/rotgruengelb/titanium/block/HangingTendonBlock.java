package net.rotgruengelb.titanium.block;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;

//? if 1.21.8 {
/*import net.minecraft.world.level.ScheduledTickAccess;
*///?} else {
import net.minecraft.world.level.LevelAccessor;
//?}

public class HangingTendonBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0);

    public HangingTendonBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isFaceSturdy(world, blockPos, Direction.DOWN);
    }

    //? if 1.21.1 {
    @Override
	protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		if (direction == Direction.UP && !this.canSurvive(state, world, pos)) {
			world.scheduleTick(pos, this, 1);
			return state;
		}

		return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
	}
    //?} else {
    /*@Override
    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (direction == Direction.UP && !this.canSurvive(state, world, pos)) {
            tickView.scheduleTick(pos, this, 1);
            return state;
        }

        return super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }
    *///?}
    @Override
    protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!this.canSurvive(state, world, pos)) {
            world.destroyBlock(pos, true);
        }
    }
}
