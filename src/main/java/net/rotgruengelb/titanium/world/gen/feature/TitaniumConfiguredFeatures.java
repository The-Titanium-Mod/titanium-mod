package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;
import net.rotgruengelb.titanium.world.gen.feature.config.HangingBlobFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.NaturalArchFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.TerrainDecorationFeatureConfig;
import net.rotgruengelb.titanium.world.gen.feature.config.UndergroundVeinsFeatureConfig;



//? if 1.21.1 {
/*import net.minecraft.util.random.SimpleWeightedRandomList;
*///?} else {
import net.minecraft.util.random.WeightedList;
//?}

import static net.rotgruengelb.titanium.util.CommonVersioned.getDirectionUnitVec3i;

public class TitaniumConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILDWOOD_TREE = configuredFeature("wildwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_WILD_OUTGROWTHS = configuredFeature("patch_wildwood_wild_outgrowths");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILD_ROTTEN_WILDWOOD_GRASS = configuredFeature("patch_wild_rotten_wildwood_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_GRASS = configuredFeature("patch_wildwood_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_WILDWOOD_GRASS = configuredFeature("patch_tall_wildwood_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_LUMEN = configuredFeature("patch_wildwood_lumen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILDWOOD_BLISTER = configuredFeature("patch_wildwood_blister");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_VOLLON_ARCH = configuredFeature("blue_vollon_arch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_VOLLON_ARCH = configuredFeature("red_vollon_arch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TENDON_ARCH = configuredFeature("tendon_arch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TENDON_VEINS = configuredFeature("blood_veins");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_TUMOR_GROWTH = configuredFeature("hanging_tumor_growth");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_SALT_CRYSTAL = configuredFeature("hanging_salt_crystal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROTTEN_SOD_VEGETATION_BONEMEAL = configuredFeature("rotten_sod_vegetation_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOD_VEGETATION_BONEMEAL = configuredFeature("sod_vegetation_bonemeal");

    public static ResourceKey<ConfiguredFeature<?, ?>> configuredFeature(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Titanium.id(name));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> featureRegisterable) {
        HolderGetter<PlacedFeature> placedFeatureLookup = featureRegisterable.lookup(Registries.PLACED_FEATURE);

        FeatureUtils.register(featureRegisterable,
                PATCH_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TitaniumBlocks.SHORT_WILDWOOD_GRASS)))
        );
        FeatureUtils.register(featureRegisterable,
                PATCH_TALL_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TitaniumBlocks.TALL_WILDWOOD_GRASS)))
        );
        FeatureUtils.register(featureRegisterable,
                PATCH_WILDWOOD_WILD_OUTGROWTHS,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        32,
                        7,
                        7,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new WeightedStateProvider(
                                                createBlockStatePool()
                                                        .add(TitaniumBlocks.SHORT_WILDWOOD_GRASS.defaultBlockState(), 83)
                                                        .add(TitaniumBlocks.SMALL_TEETH.defaultBlockState(), 5)
                                                        .add(TitaniumBlocks.WILDWOOD_LUMEN.defaultBlockState(), 8)
                                                        .add(TitaniumBlocks.WILDWOOD_BLISTER.defaultBlockState(), 1)
                                        )
                                ),
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(getDirectionUnitVec3i(Direction.DOWN), TitaniumBlocks.ROTTEN_SOD)))
                        )
                )
        );
        FeatureUtils.register(featureRegisterable,
                SOD_VEGETATION_BONEMEAL,
                TitaniumFeatures.TERRAIN_DECORATION,
                new TerrainDecorationFeatureConfig(
                        UniformInt.of(3, 5),
                        ConstantInt.of(1),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.SHORT_WILDWOOD_GRASS.defaultBlockState(), 40)
                                        .add(TitaniumBlocks.TALL_WILDWOOD_GRASS.defaultBlockState(), 12)
                                        .add(TitaniumBlocks.SMALL_TEETH.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.WILDWOOD_LUMEN.defaultBlockState(), 8)
                                        .add(TitaniumBlocks.WILDWOOD_BLISTER.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.WILDWOOD_SAPLING.defaultBlockState(), 1)
                        ),
                        BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(getDirectionUnitVec3i(Direction.DOWN), TitaniumBlocks.SOD), BlockPredicate.matchesBlocks(getDirectionUnitVec3i(Direction.UP), Blocks.AIR))
                )
        );
        FeatureUtils.register(featureRegisterable,
                ROTTEN_SOD_VEGETATION_BONEMEAL,
                TitaniumFeatures.TERRAIN_DECORATION,
                new TerrainDecorationFeatureConfig(
                        UniformInt.of(3, 4),
                        ConstantInt.of(1),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.ROTTEN_WILDWOOD_GRASS.defaultBlockState(), 48)
                                        .add(TitaniumBlocks.ROTTING_WILDWOOD_GRASS.defaultBlockState(), 24)
                                        .add(TitaniumBlocks.WILDWOOD_BLISTER.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.SMALL_TEETH.defaultBlockState(), 1)
                        ),
                        BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(getDirectionUnitVec3i(Direction.DOWN), TitaniumBlocks.ROTTEN_SOD), BlockPredicate.matchesBlocks(getDirectionUnitVec3i(Direction.UP), Blocks.AIR))
                )
        );
        FeatureUtils.register(featureRegisterable,
                PATCH_WILD_ROTTEN_WILDWOOD_GRASS,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        32,
                        9,
                        9,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new WeightedStateProvider(
                                                createBlockStatePool()
                                                        .add(TitaniumBlocks.ROTTEN_WILDWOOD_GRASS.defaultBlockState(), 1)
                                                        .add(TitaniumBlocks.ROTTING_WILDWOOD_GRASS.defaultBlockState(), 10)
                                        )
                                ),
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE)
                        )
                )
        );
        FeatureUtils.register(featureRegisterable,
                PATCH_WILDWOOD_LUMEN,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        16,
                        2,
                        4,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        BlockStateProvider.simple(TitaniumBlocks.WILDWOOD_LUMEN.defaultBlockState()
                                        ))
                        ))
        );
        FeatureUtils.register(featureRegisterable,
                PATCH_WILDWOOD_BLISTER,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        16,
                        2,
                        4,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        BlockStateProvider.simple(TitaniumBlocks.WILDWOOD_BLISTER.defaultBlockState()
                                        ))
                        ))
        );
        FeatureUtils.register(featureRegisterable,
                WILDWOOD_TREE,
                Feature.TREE, wildwoodTreeFeatureBuilder().build()
        );
        FeatureUtils.register(featureRegisterable,
                BLUE_VOLLON_ARCH,
                TitaniumFeatures.NATURAL_ARCH,
                new NaturalArchFeatureConfig(
                        TitaniumBlockTags.SOD,
                        UniformInt.of(9, 13),
                        UniformInt.of(-1, 15),
                        UniformInt.of(1, 2),
                        SimpleStateProvider.simple(TitaniumBlocks.BLUE_VOLLON),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.VOLLON_BRONCHI.defaultBlockState(), 4)
                                        .add(TitaniumBlocks.VOLLON_NOODLES.defaultBlockState(), 7)
                                        .add(TitaniumBlocks.VOLLON_STRINGS.defaultBlockState(), 10)
                                        .add(Blocks.AIR.defaultBlockState(), 6)
                        )
                )
        );
        FeatureUtils.register(featureRegisterable,
                RED_VOLLON_ARCH,
                TitaniumFeatures.NATURAL_ARCH,
                new NaturalArchFeatureConfig(
                        TitaniumBlockTags.SOD,
                        UniformInt.of(5, 13),
                        UniformInt.of(1, 32),
                        UniformInt.of(1, 2),
                        SimpleStateProvider.simple(TitaniumBlocks.RED_VOLLON),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.VOLLON_BRONCHI.defaultBlockState(), 6)
                                        .add(TitaniumBlocks.VOLLON_NOODLES.defaultBlockState(), 2)
                                        .add(TitaniumBlocks.VOLLON_STRINGS.defaultBlockState(), 10)
                                        .add(Blocks.AIR.defaultBlockState(), 8)
                        )
                )
        );
        FeatureUtils.register(featureRegisterable,
                TENDON_ARCH,
                TitaniumFeatures.NATURAL_ARCH,
                new NaturalArchFeatureConfig(
                        TitaniumBlockTags.SOD,
                        UniformInt.of(9, 11),
                        UniformInt.of(15, 50),
                        UniformInt.of(2, 3),
                        SimpleStateProvider.simple(TitaniumBlocks.TENDON),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.defaultBlockState(), 4)
                        )
                )
        );
        FeatureUtils.register(featureRegisterable,
                TENDON_VEINS,
                TitaniumFeatures.UNDERGROUND_VEINS,
                new UndergroundVeinsFeatureConfig(
                        TitaniumBlockTags.WILDWOOD_TERRAIN,
                        UniformInt.of(31, 48),
                        UniformInt.of(50, 70),
                        UniformInt.of(30, 50),
                        UniformInt.of(13, 14),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.defaultBlockState(), 2)
                                        .add(TitaniumBlocks.BRAWN.defaultBlockState(), 5)
                                        .add(TitaniumBlocks.TENDON.defaultBlockState(), 7)
                        )
                )
        );
        FeatureUtils.register(featureRegisterable,
                HANGING_TUMOR_GROWTH,
                TitaniumFeatures.HANGING_BLOB,
                new HangingBlobFeatureConfig(
                        TitaniumBlockTags.WILDWOOD_TERRAIN,
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.ROTTEN_SOD_BATCH.defaultBlockState(), 7)
                                        .add(TitaniumBlocks.BRAWN.defaultBlockState(), 9)
                                        .add(TitaniumBlocks.RED_VOLLON.defaultBlockState(), 4)
                                        .add(TitaniumBlocks.BLUE_VOLLON.defaultBlockState(), 5)
                                        .add(TitaniumBlocks.TENDON.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.WILDWOOD_WOOD.defaultBlockState(), 1)
                        ),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.defaultBlockState(), 7)
                                        .add(TitaniumBlocks.SMALL_TEETH.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.VOLLON_BRONCHI.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.VOLLON_STRINGS.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.VOLLON_NOODLES.defaultBlockState(), 1)
                        ),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.defaultBlockState(), 8)
                                        .add(TitaniumBlocks.VEINY_CLART.defaultBlockState(), 1)
                                        .add(TitaniumBlocks.HANGING_TENDON.defaultBlockState(), 1)
                        )
                )
        );
        FeatureUtils.register(featureRegisterable,
                HANGING_SALT_CRYSTAL,
                TitaniumFeatures.HANGING_BLOB,
                new HangingBlobFeatureConfig(
                        TitaniumBlockTags.WILDWOOD_TERRAIN,
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(TitaniumBlocks.SALT.defaultBlockState(), 1)
                        ),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.defaultBlockState(), 24)
                                        .add(TitaniumBlocks.SALT.defaultBlockState(), 1)
                        ),
                        new WeightedStateProvider(
                                createBlockStatePool()
                                        .add(Blocks.AIR.defaultBlockState(), 14)
                                        .add(TitaniumBlocks.SALT.defaultBlockState(), 1)
                        )
                )
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder wildwoodTreeFeatureBuilder() {
        return genericTreeBuilder(TitaniumBlocks.WILDWOOD_LOG,
                TitaniumBlocks.WILDWOOD_LEAVES, 5, 3, 5, 2)
                .ignoreVines()
                .dirt(BlockStateProvider.simple(TitaniumBlocks.VEINY_CLART))
                .forceDirt();
    }

    private static TreeConfiguration.TreeConfigurationBuilder genericTreeBuilder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    //? if 1.21.1 {
    /*private static SimpleWeightedRandomList.Builder<BlockState> createBlockStatePool() {
        return SimpleWeightedRandomList.builder();
    }
    *///?} else {
    private static WeightedList.Builder<BlockState> createBlockStatePool() {
        return WeightedList.builder();
    }
    //?}
}
