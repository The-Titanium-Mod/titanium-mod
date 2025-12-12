package net.rotgruengelb.titanium.block;

import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.rotgruengelb.titanium.world.gen.feature.TitaniumConfiguredFeatures;

public class RottenSodBlock extends AbstractClartTopSoilBlock {
    public RottenSodBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void generateGrowFeatures(Registry<ConfiguredFeature<?, ?>> registry, ServerLevel world, ChunkGenerator chunkGenerator, RandomSource random, BlockPos pos) {
        this.generateFeature(registry, TitaniumConfiguredFeatures.ROTTEN_SOD_VEGETATION_BONEMEAL, world, chunkGenerator, random, pos);
    }

    @Override
    public boolean maySpread() {
        return false;
    }
}
