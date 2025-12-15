package net.rotgruengelb.titanium.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public abstract class AbstractClartTopSoilBlock extends Block implements BonemealableBlock {

    public AbstractClartTopSoilBlock(Properties settings) {
        super(settings);
    }

    private static boolean stayAlive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.is(TitaniumBlockTags.SOD_BATCH)) {
            return true;
        } else if (blockState.getFluidState().getAmount() == 8) {
            return false;
        } else {
            //? if 1.21.1 {
            /*int i = LightEngine.getLightBlockInto(world, state, pos, blockState, blockPos, Direction.UP, blockState.getLightBlock(world, blockPos));
             *///?} else {
            int i = LightEngine.getLightBlockInto(state, blockState, Direction.UP, blockState.getLightBlock());
            //?}
            return i < 15;
        }
    }

    private static boolean canSpread(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.above();
        return stayAlive(state, world, pos) && world.getFluidState(blockPos).isEmpty();
    }

    public abstract boolean maySpread();

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.above();
        ChunkGenerator chunkGenerator = world.getChunkSource().getGenerator();
        //? if 1.21.1 {
        /*Registry<ConfiguredFeature<?, ?>> registry = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
         *///?} else {
        Registry<ConfiguredFeature<?, ?>> registry = world.registryAccess().lookupOrThrow(Registries.CONFIGURED_FEATURE);
        //?}
        this.generateGrowFeatures(registry, world, chunkGenerator, random, blockPos);
    }

    public abstract void generateGrowFeatures(Registry<ConfiguredFeature<?, ?>> registry, ServerLevel world, ChunkGenerator chunkGenerator, RandomSource random, BlockPos pos);

    //? if 1.21.8 {
    public void generateFeature(Registry<ConfiguredFeature<?, ?>> registry, ResourceKey<ConfiguredFeature<?, ?>> key, ServerLevel world, ChunkGenerator chunkGenerator, RandomSource random, BlockPos pos) {
        registry.getOptional(key).ifPresent(entry -> entry.place(world, chunkGenerator, random, pos));
    }
    //?} else {
    /*public void generateFeature(Registry<ConfiguredFeature<?, ?>> registry, ResourceKey<ConfiguredFeature<?, ?>> key, ServerLevel world, ChunkGenerator chunkGenerator, RandomSource random, BlockPos pos) {
        registry.getHolder(key).ifPresent((entry) -> entry.value().place(world, chunkGenerator, random, pos));
    }
    *///?}

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!stayAlive(state, world, pos)) {
            world.setBlockAndUpdate(pos, TitaniumBlocks.CLART.defaultBlockState());
        } else if (maySpread()) {
            BlockState blockState = this.defaultBlockState();
            for (int i = 0; i < 4; ++i) {
                BlockPos blockPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (world.getBlockState(blockPos).is(TitaniumBlocks.CLART) && canSpread(blockState, world, blockPos)) {
                    world.setBlockAndUpdate(blockPos, blockState);
                }
            }
        }
    }

    @Override
    public BonemealableBlock.Type getType() {
        return Type.NEIGHBOR_SPREADER;
    }
}
