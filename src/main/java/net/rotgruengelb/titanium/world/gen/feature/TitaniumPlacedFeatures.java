package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.NoiseBasedCountPlacement;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public class TitaniumPlacedFeatures {

    public static final PlacementModifier BOTTOM_TO_30_RANGE = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(30));
    public static final PlacementModifier FIXED_30_TO_85_RANGE = HeightRangePlacement.uniform(VerticalAnchor.absolute(85), VerticalAnchor.absolute(30));

    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_WILD_OUTGROWTHS = placedFeature("patch_wildwood_wild_outgrowths");
    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_GRASS_WASTES = placedFeature("patch_wildwood_grass_wastes");
    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_GRASS_FOREST = placedFeature("patch_wildwood_grass_forest");
    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_GRASS = placedFeature("patch_wildwood_grass");
    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_GRASS_DEPTHS = placedFeature("patch_wildwood_grass_depths");
    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_GRASS_MID_DEPTHS = placedFeature("patch_wildwood_grass_mid_depths");
    public static final ResourceKey<PlacedFeature> PATCH_TALL_WILDWOOD_GRASS = placedFeature("patch_tall_wildwood_grass");
    public static final ResourceKey<PlacedFeature> PATCH_WILD_ROTTEN_WILDWOOD_GRASS = placedFeature("patch_wild_rotten_wildwood_grass");
    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_LUMEN_FOREST = placedFeature("patch_wildwood_lumen_forest");
    public static final ResourceKey<PlacedFeature> PATCH_WILDWOOD_BLISTER = placedFeature("patch_wildwood_blister");
    public static final ResourceKey<PlacedFeature> WILDWOOD_TREES = placedFeature("wildwood_trees");
    public static final ResourceKey<PlacedFeature> WILDWOOD_TREES_DEPTHS = placedFeature("wildwood_trees_depths");
    public static final ResourceKey<PlacedFeature> WILDWOOD_TREES_MID_DEPTHS = placedFeature("wildwood_trees_mid_depths");
    public static final ResourceKey<PlacedFeature> BLUE_VOLLON_ARCH = placedFeature("blue_vollon_arch");
    public static final ResourceKey<PlacedFeature> RED_VOLLON_ARCH = placedFeature("red_vollon_arch");
    public static final ResourceKey<PlacedFeature> TENDON_ARCH = placedFeature("tendon_arch");
    public static final ResourceKey<PlacedFeature> TENDON_VEINS = placedFeature("tendon_veins");
    public static final ResourceKey<PlacedFeature> HANGING_TUMOR_GROWTH = placedFeature("hanging_tumor_growth");
    public static final ResourceKey<PlacedFeature> HANGING_SALT_CRYSTAL = placedFeature("hanging_salt_crystal");

    public static ResourceKey<PlacedFeature> placedFeature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Titanium.id(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> featureRegisterable) {
        HolderGetter<ConfiguredFeature<?, ?>> configureFeatureLookup = featureRegisterable.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(featureRegisterable, WILDWOOD_TREES,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.WILDWOOD_TREE),
                CountPlacement.of(21),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                InSquarePlacement.spread(),
                RandomOffsetPlacement.horizontal(ConstantInt.of(1)),
                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(TitaniumBlocks.WILDWOOD_SAPLING.defaultBlockState(), BlockPos.ZERO)),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, WILDWOOD_TREES_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.WILDWOOD_TREE),
                CountPlacement.of(23),
                InSquarePlacement.spread(),
                BOTTOM_TO_30_RANGE,
                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(TitaniumBlocks.WILDWOOD_SAPLING.defaultBlockState(), BlockPos.ZERO)),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, WILDWOOD_TREES_MID_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.WILDWOOD_TREE),
                CountPlacement.of(30),
                InSquarePlacement.spread(),
                FIXED_30_TO_85_RANGE,
                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(TitaniumBlocks.WILDWOOD_SAPLING.defaultBlockState(), BlockPos.ZERO)),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_WILD_OUTGROWTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_WILD_OUTGROWTHS),
                CountPlacement.of(7),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                CountPlacement.of(20),
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_GRASS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                NoiseBasedCountPlacement.of(5, 50.0, 2.0),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_GRASS_WASTES,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                NoiseThresholdCountPlacement.of(-0.8, 8, 13),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_GRASS_FOREST,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                NoiseThresholdCountPlacement.of(-0.8, 4, 10),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_TALL_WILDWOOD_GRASS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_TALL_WILDWOOD_GRASS),
                NoiseThresholdCountPlacement.of(-0.4, 4, 3),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_GRASS_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                CountPlacement.of(UniformInt.of(10, 13)),
                InSquarePlacement.spread(),
                BOTTOM_TO_30_RANGE,
                NoiseThresholdCountPlacement.of(-0.8, 4, 10),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_GRASS_MID_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                CountPlacement.of(UniformInt.of(11, 20)),
                InSquarePlacement.spread(),
                FIXED_30_TO_85_RANGE,
                NoiseThresholdCountPlacement.of(-0.8, 4, 10),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILD_ROTTEN_WILDWOOD_GRASS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILD_ROTTEN_WILDWOOD_GRASS),
                CountPlacement.of(UniformInt.of(6, 12)),
                PlacementUtils.FULL_RANGE,
                NoiseBasedCountPlacement.of(3, 30.0, 0.2),
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(TitaniumBlockTags.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_LUMEN_FOREST,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_LUMEN),
                CountPlacement.of(2),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(1),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, PATCH_WILDWOOD_BLISTER,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_BLISTER),
                CountPlacement.of(2),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(1),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, BLUE_VOLLON_ARCH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.BLUE_VOLLON_ARCH),
                CountPlacement.of(1),
                PlacementUtils.FULL_RANGE,
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, RED_VOLLON_ARCH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.RED_VOLLON_ARCH),
                CountPlacement.of(2),
                RarityFilter.onAverageOnceEvery(2),
                PlacementUtils.FULL_RANGE,
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, TENDON_ARCH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.TENDON_ARCH),
                CountPlacement.of(1),
                PlacementUtils.FULL_RANGE,
                InSquarePlacement.spread(),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(TitaniumBlocks.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, TENDON_VEINS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.TENDON_VEINS),
                CountPlacement.of(2),
                PlacementUtils.FULL_RANGE,
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(TitaniumBlockTags.SOD), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, HANGING_TUMOR_GROWTH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.HANGING_TUMOR_GROWTH),
                CountPlacement.of(7),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        );
        PlacementUtils.register(featureRegisterable, HANGING_SALT_CRYSTAL,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.HANGING_SALT_CRYSTAL),
                CountPlacement.of(5),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        );
    }
}
