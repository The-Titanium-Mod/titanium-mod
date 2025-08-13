package net.rotgruengelb.titanium.block;

import net.minecraft.block.BlockState;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class SodBlock extends AbstractClartTopSoilBlock {
    public SodBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean maySpread() {
        return true;
    }

    @Override
    public void generateGrowFeatures(Registry<ConfiguredFeature<?, ?>> registry, ServerWorld world, ChunkGenerator chunkGenerator, Random random, BlockPos pos) {
    }
}
