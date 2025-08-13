package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

public class TitaniumPlacedFeatures {

    public static final PlacementModifier BOTTOM_TO_30_RANGE = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(30));
    public static final PlacementModifier FIXED_30_TO_85_RANGE = HeightRangePlacementModifier.uniform(YOffset.fixed(85), YOffset.fixed(30));

    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_WILD_OUTGROWTHS = placedFeature("patch_wildwood_wild_outgrowths");
    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_GRASS_WASTES = placedFeature("patch_wildwood_grass_wastes");
    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_GRASS_FOREST = placedFeature("patch_wildwood_grass_forest");
    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_GRASS = placedFeature("patch_wildwood_grass");
    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_GRASS_DEPTHS = placedFeature("patch_wildwood_grass_depths");
    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_GRASS_MID_DEPTHS = placedFeature("patch_wildwood_grass_mid_depths");
    public static final RegistryKey<PlacedFeature> PATCH_TALL_WILDWOOD_GRASS = placedFeature("patch_tall_wildwood_grass");
    public static final RegistryKey<PlacedFeature> PATCH_WILD_ROTTEN_WILDWOOD_GRASS = placedFeature("patch_wild_rotten_wildwood_grass");
    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_LUMEN_FOREST = placedFeature("patch_wildwood_lumen_forest");
    public static final RegistryKey<PlacedFeature> PATCH_WILDWOOD_BLISTER = placedFeature("patch_wildwood_blister");
    public static final RegistryKey<PlacedFeature> WILDWOOD_TREES = placedFeature("wildwood_trees");
    public static final RegistryKey<PlacedFeature> WILDWOOD_TREES_DEPTHS = placedFeature("wildwood_trees_depths");
    public static final RegistryKey<PlacedFeature> WILDWOOD_TREES_MID_DEPTHS = placedFeature("wildwood_trees_mid_depths");
    public static final RegistryKey<PlacedFeature> BLUE_VOLLON_ARCH = placedFeature("blue_vollon_arch");
    public static final RegistryKey<PlacedFeature> RED_VOLLON_ARCH = placedFeature("red_vollon_arch");
    public static final RegistryKey<PlacedFeature> TENDON_ARCH = placedFeature("tendon_arch");
    public static final RegistryKey<PlacedFeature> TENDON_VEINS = placedFeature("tendon_veins");
    public static final RegistryKey<PlacedFeature> HANGING_TUMOR_GROWTH = placedFeature("hanging_tumor_growth");
    public static final RegistryKey<PlacedFeature> HANGING_SALT_CRYSTAL = placedFeature("hanging_salt_crystal");

    public static RegistryKey<PlacedFeature> placedFeature(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Titanium.id(name));
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configureFeatureLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        PlacedFeatures.register(featureRegisterable, WILDWOOD_TREES,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.WILDWOOD_TREE),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                CountPlacementModifier.of(16),
                SquarePlacementModifier.of(),
                RandomOffsetPlacementModifier.horizontally(ConstantIntProvider.create(1)),
                BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(TitaniumBlocks.WILDWOOD_SAPLING.getDefaultState(), BlockPos.ORIGIN)),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, WILDWOOD_TREES_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.WILDWOOD_TREE),
                BOTTOM_TO_30_RANGE,
                CountPlacementModifier.of(19),
                SquarePlacementModifier.of(),
                BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(TitaniumBlocks.WILDWOOD_SAPLING.getDefaultState(), BlockPos.ORIGIN)),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, WILDWOOD_TREES_MID_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.WILDWOOD_TREE),
                FIXED_30_TO_85_RANGE,
                CountPlacementModifier.of(12),
                SquarePlacementModifier.of(),
                BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(TitaniumBlocks.WILDWOOD_SAPLING.getDefaultState(), BlockPos.ORIGIN)),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_WILD_OUTGROWTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_WILD_OUTGROWTHS),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                CountPlacementModifier.of(30),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 12),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_GRASS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                NoiseBasedCountPlacementModifier.of(5, 50.0, 2.0),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 16),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_GRASS_WASTES,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                NoiseThresholdCountPlacementModifier.of(-0.8, 8, 13),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 16),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_GRASS_FOREST,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                NoiseThresholdCountPlacementModifier.of(-0.8, 4, 10),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 16),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_TALL_WILDWOOD_GRASS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_TALL_WILDWOOD_GRASS),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                NoiseThresholdCountPlacementModifier.of(-0.4, 4, 1),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 16),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_GRASS_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                BOTTOM_TO_30_RANGE,
                NoiseBasedCountPlacementModifier.of(6, 80.0, 1.1),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 16),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_GRASS_MID_DEPTHS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_GRASS),
                FIXED_30_TO_85_RANGE,
                NoiseBasedCountPlacementModifier.of(3, 70.0, 1.1),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 16),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILD_ROTTEN_WILDWOOD_GRASS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILD_ROTTEN_WILDWOOD_GRASS),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                NoiseBasedCountPlacementModifier.of(3, 30.0, 0.2),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlockTag(TitaniumBlockTags.SOD), BlockPredicate.IS_AIR, 16),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_LUMEN_FOREST,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_LUMEN),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                CountPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                RarityFilterPlacementModifier.of(1),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 12),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, PATCH_WILDWOOD_BLISTER,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.PATCH_WILDWOOD_BLISTER),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                CountPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                RarityFilterPlacementModifier.of(1),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 12),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, BLUE_VOLLON_ARCH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.BLUE_VOLLON_ARCH),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                CountPlacementModifier.of(1),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 12),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, RED_VOLLON_ARCH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.RED_VOLLON_ARCH),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                CountPlacementModifier.of(2),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 12),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, TENDON_ARCH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.TENDON_ARCH),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                CountPlacementModifier.of(1),
                SquarePlacementModifier.of(),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlocks(TitaniumBlocks.SOD), BlockPredicate.IS_AIR, 12),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, TENDON_VEINS,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.TENDON_VEINS),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                CountPlacementModifier.of(2),
                EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.matchingBlockTag(TitaniumBlockTags.SOD), BlockPredicate.IS_AIR, 12),
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, HANGING_TUMOR_GROWTH,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.HANGING_TUMOR_GROWTH),
                CountPlacementModifier.of(7),
                SquarePlacementModifier.of(),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(featureRegisterable, HANGING_SALT_CRYSTAL,
                configureFeatureLookup.getOrThrow(TitaniumConfiguredFeatures.HANGING_SALT_CRYSTAL),
                CountPlacementModifier.of(5),
                SquarePlacementModifier.of(),
                PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                BiomePlacementModifier.of()
        );
    }
}
