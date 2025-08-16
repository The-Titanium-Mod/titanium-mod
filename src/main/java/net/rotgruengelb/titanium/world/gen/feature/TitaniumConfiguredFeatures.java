package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.collection.DataPool;
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
import net.rotgruengelb.titanium.world.gen.feature.config.HangingBlobFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.NaturalArchFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.TerrainDecorationFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.UndergroundVeinsFeatureConfig;
//?}

public class TitaniumConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILDWOOD_TREE = configuredFeature("wildwood_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_WILD_OUTGROWTHS = configuredFeature("patch_wildwood_wild_outgrowths");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILD_ROTTEN_WILDWOOD_GRASS = configuredFeature("patch_wild_rotten_wildwood_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_GRASS = configuredFeature("patch_wildwood_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_TALL_WILDWOOD_GRASS = configuredFeature("patch_tall_wildwood_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_LUMEN = configuredFeature("patch_wildwood_lumen");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_BLISTER = configuredFeature("patch_wildwood_blister");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_VOLLON_ARCH = configuredFeature("blue_vollon_arch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_VOLLON_ARCH = configuredFeature("red_vollon_arch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TENDON_ARCH = configuredFeature("tendon_arch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TENDON_VEINS = configuredFeature("blood_veins");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HANGING_TUMOR_GROWTH = configuredFeature("hanging_tumor_growth");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HANGING_SALT_CRYSTAL = configuredFeature("hanging_salt_crystal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROTTEN_SOD_VEGETATION_BONEMEAL = configuredFeature("rotten_sod_vegetation_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SOD_VEGETATION_BONEMEAL = configuredFeature("sod_vegetation_bonemeal");

    public static RegistryKey<ConfiguredFeature<?, ?>> configuredFeature(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Titanium.id(name));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        RegistryEntryLookup<PlacedFeature> placedFeatureLookup = featureRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        ConfiguredFeatures.register(featureRegisterable,
                PATCH_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(TitaniumBlocks.WILDWOOD_GRASS)))
        );
        ConfiguredFeatures.register(featureRegisterable,
                PATCH_TALL_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(TitaniumBlocks.TALL_WILDWOOD_GRASS)))
        );
        ConfiguredFeatures.register(featureRegisterable,
                PATCH_WILDWOOD_WILD_OUTGROWTHS,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        32,
                        7,
                        7,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new WeightedBlockStateProvider(
                                                createBlockStatePool()
                                                        .add(TitaniumBlocks.WILDWOOD_GRASS.getDefaultState(), 83)
                                                        .add(TitaniumBlocks.SMALL_TEETH.getDefaultState(), 5)
                                                        .add(TitaniumBlocks.WILDWOOD_LUMEN.getDefaultState(), 8)
                                                        .add(TitaniumBlocks.WILDWOOD_BLISTER.getDefaultState(), 1)
                                        )
                                ),
                                BlockPredicate.bothOf(BlockPredicate.IS_AIR, BlockPredicate.not(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), TitaniumBlocks.ROTTEN_SOD)))
                        )
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                SOD_VEGETATION_BONEMEAL,
                TitaniumFeatures.TERRAIN_DECORATION,
                new TerrainDecorationFeatureConfig(
                        UniformIntProvider.create(3, 5),
                        ConstantIntProvider.create(1),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.WILDWOOD_GRASS.getDefaultState(), 40)
                                        .add(TitaniumBlocks.TALL_WILDWOOD_GRASS.getDefaultState(), 12)
                                        .add(TitaniumBlocks.SMALL_TEETH.getDefaultState(), 1)
                                        .add(TitaniumBlocks.WILDWOOD_LUMEN.getDefaultState(), 8)
                                        .add(TitaniumBlocks.WILDWOOD_BLISTER.getDefaultState(), 1)
                                        .add(TitaniumBlocks.WILDWOOD_SAPLING.getDefaultState(), 1)
                        ),
                        BlockPredicate.allOf(BlockPredicate.IS_AIR, BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), TitaniumBlocks.SOD), BlockPredicate.matchingBlocks(Direction.UP.getVector(), Blocks.AIR))
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                ROTTEN_SOD_VEGETATION_BONEMEAL,
                TitaniumFeatures.TERRAIN_DECORATION,
                new TerrainDecorationFeatureConfig(
                        UniformIntProvider.create(3, 4),
                        ConstantIntProvider.create(1),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.ROTTEN_WILDWOOD_GRASS.getDefaultState(), 48)
                                        .add(TitaniumBlocks.ROTTING_WILDWOOD_GRASS.getDefaultState(), 24)
                                        .add(TitaniumBlocks.WILDWOOD_BLISTER.getDefaultState(), 1)
                                        .add(TitaniumBlocks.SMALL_TEETH.getDefaultState(), 1)
                        ),
                        BlockPredicate.allOf(BlockPredicate.IS_AIR, BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), TitaniumBlocks.ROTTEN_SOD), BlockPredicate.matchingBlocks(Direction.UP.getVector(), Blocks.AIR))
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                PATCH_WILD_ROTTEN_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        32,
                        9,
                        9,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new WeightedBlockStateProvider(
                                                createBlockStatePool()
                                                        .add(TitaniumBlocks.ROTTEN_WILDWOOD_GRASS.getDefaultState(), 1)
                                                        .add(TitaniumBlocks.ROTTING_WILDWOOD_GRASS.getDefaultState(), 10)
                                        )
                                ),
                                BlockPredicate.allOf(BlockPredicate.IS_AIR)
                        )
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
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
        ConfiguredFeatures.register(featureRegisterable,
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
        ConfiguredFeatures.register(featureRegisterable,
                BLUE_VOLLON_ARCH,
                TitaniumFeatures.NATURAL_ARCH,
                new NaturalArchFeatureConfig(
                        TitaniumBlockTags.SOD,
                        UniformIntProvider.create(9, 13),
                        UniformIntProvider.create(-1, 15),
                        UniformIntProvider.create(1, 2),
                        SimpleBlockStateProvider.of(TitaniumBlocks.BLUE_VOLLON),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.VOLLON_BRONCHI.getDefaultState(), 4)
                                        .add(TitaniumBlocks.VOLLON_NOODLES.getDefaultState(), 7)
                                        .add(TitaniumBlocks.VOLLON_STRINGS.getDefaultState(), 10)
                                        .add(Blocks.AIR.getDefaultState(), 6)
                        )
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                RED_VOLLON_ARCH,
                TitaniumFeatures.NATURAL_ARCH,
                new NaturalArchFeatureConfig(
                        TitaniumBlockTags.SOD,
                        UniformIntProvider.create(5, 13),
                        UniformIntProvider.create(1, 32),
                        UniformIntProvider.create(1, 2),
                        SimpleBlockStateProvider.of(TitaniumBlocks.RED_VOLLON),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.VOLLON_BRONCHI.getDefaultState(), 6)
                                        .add(TitaniumBlocks.VOLLON_NOODLES.getDefaultState(), 2)
                                        .add(TitaniumBlocks.VOLLON_STRINGS.getDefaultState(), 10)
                                        .add(Blocks.AIR.getDefaultState(), 8)
                        )
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                TENDON_ARCH,
                TitaniumFeatures.NATURAL_ARCH,
                new NaturalArchFeatureConfig(
                        TitaniumBlockTags.SOD,
                        UniformIntProvider.create(9, 11),
                        UniformIntProvider.create(15, 50),
                        UniformIntProvider.create(2, 3),
                        SimpleBlockStateProvider.of(TitaniumBlocks.TENDON),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.getDefaultState(), 4)
                        )
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                TENDON_VEINS,
                TitaniumFeatures.UNDERGROUND_VEINS,
                new UndergroundVeinsFeatureConfig(
                        TitaniumBlockTags.WILDWOOD_TERRAIN,
                        UniformIntProvider.create(31, 48),
                        UniformIntProvider.create(50, 70),
                        UniformIntProvider.create(30, 50),
                        UniformIntProvider.create(13, 14),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.getDefaultState(), 2)
                                        .add(TitaniumBlocks.BRAWN.getDefaultState(), 5)
                                        .add(TitaniumBlocks.TENDON.getDefaultState(), 7)
                        )
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                HANGING_TUMOR_GROWTH,
                TitaniumFeatures.HANGING_BLOB,
                new HangingBlobFeatureConfig(
                        TitaniumBlockTags.WILDWOOD_TERRAIN,
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.ROTTEN_SOD_BATCH.getDefaultState(), 7)
                                        .add(TitaniumBlocks.BRAWN.getDefaultState(), 9)
                                        .add(TitaniumBlocks.RED_VOLLON.getDefaultState(), 4)
                                        .add(TitaniumBlocks.BLUE_VOLLON.getDefaultState(), 5)
                                        .add(TitaniumBlocks.TENDON.getDefaultState(), 1)
                                        .add(TitaniumBlocks.WILDWOOD_WOOD.getDefaultState(), 1)
                        ),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.getDefaultState(), 7)
                                        .add(TitaniumBlocks.SMALL_TEETH.getDefaultState(), 1)
                                        .add(TitaniumBlocks.VOLLON_BRONCHI.getDefaultState(), 1)
                                        .add(TitaniumBlocks.VOLLON_STRINGS.getDefaultState(), 1)
                                        .add(TitaniumBlocks.VOLLON_NOODLES.getDefaultState(), 1)
                        ),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.getDefaultState(), 8)
                                        .add(TitaniumBlocks.VEINY_CLART.getDefaultState(), 1)
                                        .add(TitaniumBlocks.HANGING_TENDON.getDefaultState(), 1)
                        )
                )
        );
        ConfiguredFeatures.register(featureRegisterable,
                HANGING_SALT_CRYSTAL,
                TitaniumFeatures.HANGING_BLOB,
                new HangingBlobFeatureConfig(
                        TitaniumBlockTags.WILDWOOD_TERRAIN,
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.SALT.getDefaultState(), 1)
                        ),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.getDefaultState(), 24)
                                        .add(TitaniumBlocks.SALT.getDefaultState(), 1)
                        ),
                        new WeightedBlockStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.getDefaultState(), 14)
                                        .add(TitaniumBlocks.SALT.getDefaultState(), 1)
                        )
                )
        );
    }

    private static TreeFeatureConfig.Builder wildwoodTreeFeatureBuilder() {
        return genericTreeBuilder(TitaniumBlocks.WILDWOOD_LOG,
                TitaniumBlocks.WILDWOOD_LEAVES, 5, 3, 5, 2)
                .ignoreVines()
                .dirtProvider(BlockStateProvider.of(TitaniumBlocks.VEINY_CLART))
                .forceDirt();
    }

    private static TreeFeatureConfig.Builder genericTreeBuilder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeFeatureConfig.Builder(
                BlockStateProvider.of(log),
                new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.of(leaves),
                new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    //? if 1.21.1 {
    private static DataPool.Builder<BlockState> createBlockStatePool() {
        return DataPool.builder();
    }
    //?} else {
    /*private static Pool.Builder<BlockState> createBlockStatePool() {
        return Pool.builder();
    }
    *///?}
}
