package net.rotgruengelb.titanium.world.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.rotgruengelb.titanium.world.gen.feature.TitaniumPlacedFeatures;

public class WildwoodBiomeFamily {
    public static Biome forest(HolderGetter<PlacedFeature> featureLookup, HolderGetter<ConfiguredWorldCarver<?>> carverLookup) {
        BiomeGenerationSettings.Builder lookupBackedBuilder = createBuilderWithCommonFeatures(featureLookup, carverLookup)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.WILDWOOD_TREES)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.WILDWOOD_TREES_DEPTHS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.WILDWOOD_TREES_MID_DEPTHS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_FOREST)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_LUMEN_FOREST);
        return TitaniumBiomes.createEndBiome(lookupBackedBuilder);
    }

    public static Biome wastes(HolderGetter<PlacedFeature> featureLookup, HolderGetter<ConfiguredWorldCarver<?>> carverLookup) {
        BiomeGenerationSettings.Builder lookupBackedBuilder = createBuilderWithCommonFeatures(featureLookup, carverLookup)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_WASTES);
        return TitaniumBiomes.createEndBiome(lookupBackedBuilder);
    }

    private static BiomeGenerationSettings.Builder createBuilderWithCommonFeatures(HolderGetter<PlacedFeature> featureLookup, HolderGetter<ConfiguredWorldCarver<?>> carverLookup) {
        return new BiomeGenerationSettings.Builder(featureLookup, carverLookup)
                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.END_GATEWAY_RETURN)
                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, TitaniumPlacedFeatures.BLUE_VOLLON_ARCH)
                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, TitaniumPlacedFeatures.RED_VOLLON_ARCH)
                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, TitaniumPlacedFeatures.TENDON_ARCH)
                .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, TitaniumPlacedFeatures.HANGING_SALT_CRYSTAL)
                .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, TitaniumPlacedFeatures.HANGING_TUMOR_GROWTH)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TitaniumPlacedFeatures.TENDON_VEINS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_BLISTER)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_TALL_WILDWOOD_GRASS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILD_ROTTEN_WILDWOOD_GRASS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_DEPTHS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_MID_DEPTHS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_WILD_OUTGROWTHS);
    }
}
