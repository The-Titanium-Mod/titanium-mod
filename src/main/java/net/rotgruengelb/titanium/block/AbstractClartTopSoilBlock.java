package net.rotgruengelb.titanium.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public abstract class AbstractClartTopSoilBlock extends Block implements Fertilizable {

    public AbstractClartTopSoilBlock(Settings settings) {
        super(settings);
    }

    private static boolean stayAlive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isIn(TitaniumBlockTags.SOD_BATCH)) {
            return true;
        } else if (blockState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            //? if 1.21.1 {
            int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
             //?} else {
            /*int i = ChunkLightProvider.getRealisticOpacity(state, blockState, Direction.UP, blockState.getOpacity());
            *///?}
            return i < 15;
        }
    }

    private static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return stayAlive(state, world, pos) && world.getFluidState(blockPos).isEmpty();
    }

    public abstract boolean maySpread();

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        //? if 1.21.1 {
        Registry<ConfiguredFeature<?, ?>> registry = world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE);
         //?} else {
        /*Registry<ConfiguredFeature<?, ?>> registry = world.getRegistryManager().getOrThrow(RegistryKeys.CONFIGURED_FEATURE);
        *///?}
        this.generateGrowFeatures(registry, world, chunkGenerator, random, blockPos);
    }

    public abstract void generateGrowFeatures(Registry<ConfiguredFeature<?, ?>> registry, ServerWorld world, ChunkGenerator chunkGenerator, Random random, BlockPos pos);

    //? if 1.21.8 {
    /*public void generateFeature(Registry<ConfiguredFeature<?, ?>> registry, RegistryKey<ConfiguredFeature<?, ?>> key, ServerWorld world, ChunkGenerator chunkGenerator, Random random, BlockPos pos) {
        registry.getOptional(key).ifPresent(entry -> entry.value().generate(world, chunkGenerator, random, pos));
    }
    *///?} else {
    public void generateFeature(Registry<ConfiguredFeature<?, ?>> registry, RegistryKey<ConfiguredFeature<?, ?>> key, ServerWorld world, ChunkGenerator chunkGenerator, Random random, BlockPos pos) {
        registry.getEntry(key).ifPresent((entry) -> entry.value().generate(world, chunkGenerator, random, pos));
    }
    //?}

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!stayAlive(state, world, pos)) {
            world.setBlockState(pos, TitaniumBlocks.CLART.getDefaultState());
        } else if (maySpread()) {
            BlockState blockState = this.getDefaultState();
            for (int i = 0; i < 4; ++i) {
                BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (world.getBlockState(blockPos).isOf(TitaniumBlocks.CLART) && canSpread(blockState, world, blockPos)) {
                    world.setBlockState(blockPos, blockState);
                }
            }
        }
    }

    @Override
    public Fertilizable.FertilizableType getFertilizableType() {
        return FertilizableType.NEIGHBOR_SPREADER;
    }
}
