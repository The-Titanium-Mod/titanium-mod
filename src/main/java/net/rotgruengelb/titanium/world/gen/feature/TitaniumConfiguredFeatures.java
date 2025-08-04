package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public class TitaniumConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILDWOOD_TREE = configuredFeature("wildwood_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_WILD_OUTGROWTHS = configuredFeature("patch_wildwood_wild_outgrowths");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_GRASS = configuredFeature("patch_wildwood_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_TALL_WILDWOOD_GRASS = configuredFeature("patch_tall_wildwood_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_LUMEN = configuredFeature("patch_wildwood_lumen");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_BLISTER = configuredFeature("patch_wildwood_blister");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_BLUE_VOLLON_ARCH = configuredFeature("small_red_vollon_arch");

    public static RegistryKey<ConfiguredFeature<?, ?>> configuredFeature(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Titanium.id(name));
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        RegistryEntryLookup<PlacedFeature> placedFeatureLookup = featureRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        WeightedBlockStateProvider wildwoodVegetationMixWeightedBlockStateProvider = new WeightedBlockStateProvider(
                Pool.<BlockState>builder()
                        .add(TitaniumBlocks.WILDWOOD_GRASS.getDefaultState(), 83)
                        .add(TitaniumBlocks.SMALL_TEETH.getDefaultState(), 5)
                        .add(TitaniumBlocks.WILDWOOD_LUMEN.getDefaultState(), 8)
                        .add(TitaniumBlocks.WILDWOOD_BLISTER.getDefaultState(), 1)
        );
        ConfiguredFeatures.register(
                featureRegisterable,
                PATCH_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(TitaniumBlocks.WILDWOOD_GRASS)))
        );
        ConfiguredFeatures.register(
                featureRegisterable,
                PATCH_TALL_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(TitaniumBlocks.TALL_WILDWOOD_GRASS)))
        );
        ConfiguredFeatures.register(
                featureRegisterable,
                PATCH_WILDWOOD_WILD_OUTGROWTHS,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        32,
                        7,
                        7,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        wildwoodVegetationMixWeightedBlockStateProvider
                                ),
                                BlockPredicate.bothOf(BlockPredicate.IS_AIR, BlockPredicate.not(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), TitaniumBlocks.ROTTEN_SOD)))
                        )
                )
        );
        ConfiguredFeatures.register(
                featureRegisterable,
                PATCH_WILDWOOD_LUMEN,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        16,
                        2,
                        4,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        BlockStateProvider.of(TitaniumBlocks.WILDWOOD_LUMEN.getDefaultState()
                                        ))
                        ))
        );
        ConfiguredFeatures.register(
                featureRegisterable,
                PATCH_WILDWOOD_BLISTER,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        16,
                        2,
                        4,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        BlockStateProvider.of(TitaniumBlocks.WILDWOOD_BLISTER.getDefaultState()
                                        ))
                        ))
        );
        ConfiguredFeatures.register(featureRegisterable,
                WILDWOOD_TREE,
                Feature.TREE, wildwoodTreeFeatureBuilder().build()
        );
        ConfiguredFeatures.register(
                featureRegisterable,
                SMALL_BLUE_VOLLON_ARCH,
                TitaniumFeatures.NATURAL_ARCH,
                new NaturalArchFeatureConfig(
                        SimpleBlockStateProvider.of(TitaniumBlocks.BLUE_VOLLON),
                        TitaniumBlockTags.CLART_SOIL,
                        UniformIntProvider.create(1, 3),
                        UniformIntProvider.create(2, 10),
                        UniformIntProvider.create(3, 6),
                        ConstantIntProvider.create(-5),
                        ConstantIntProvider.create(5),
                        BlockPredicate.IS_AIR
                )
        );
    }


    private static TreeFeatureConfig.Builder wildwoodTreeFeatureBuilder() {
        return treeFeatureBuilder(TitaniumBlocks.WILDWOOD_LOG,
                TitaniumBlocks.WILDWOOD_LEAVES, 5, 3, 5, 2)
                .ignoreVines()
                .dirtProvider(BlockStateProvider.of(TitaniumBlocks.VEINY_CLART))
                .forceDirt();
    }

    private static TreeFeatureConfig.Builder treeFeatureBuilder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeFeatureConfig.Builder(
                BlockStateProvider.of(log),
                new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.of(leaves),
                new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }
}
