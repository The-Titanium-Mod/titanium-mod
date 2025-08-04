package net.rotgruengelb.titanium.world.biome;

import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.EndPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.rotgruengelb.titanium.world.gen.feature.TitaniumPlacedFeatures;

public class WildwoodBiomeFamily {
    public static Biome forest(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, TitaniumPlacedFeatures.SMALL_BLUE_VOLLON_ARCH)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_WILD_OUTGROWTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.WILDWOOD_TREES)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_FOREST)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_MID_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_LUMEN_FOREST)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_BLISTER)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_TALL_WILDWOOD_GRASS);
        return TitaniumBiomes.createEndBiome(lookupBackedBuilder);
    }

    public static Biome wastes(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, TitaniumPlacedFeatures.SMALL_BLUE_VOLLON_ARCH)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_WILD_OUTGROWTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_WASTES)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_MID_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_BLISTER)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_TALL_WILDWOOD_GRASS);
        return TitaniumBiomes.createEndBiome(lookupBackedBuilder);
    }
}
