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
        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = createBuilderWithCommonFeatures(featureLookup, carverLookup)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.WILDWOOD_TREES)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.WILDWOOD_TREES_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.WILDWOOD_TREES_MID_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_FOREST)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_LUMEN_FOREST);
        return TitaniumBiomes.createEndBiome(lookupBackedBuilder);
    }

    public static Biome wastes(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = createBuilderWithCommonFeatures(featureLookup, carverLookup)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_WASTES);
        return TitaniumBiomes.createEndBiome(lookupBackedBuilder);
    }

    private static GenerationSettings.LookupBackedBuilder createBuilderWithCommonFeatures(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        return new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, TitaniumPlacedFeatures.BLUE_VOLLON_ARCH)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, TitaniumPlacedFeatures.RED_VOLLON_ARCH)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, TitaniumPlacedFeatures.TENDON_ARCH)
                .feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, TitaniumPlacedFeatures.HANGING_SALT_CRYSTAL)
                .feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, TitaniumPlacedFeatures.HANGING_TUMOR_GROWTH)
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, TitaniumPlacedFeatures.TENDON_VEINS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_BLISTER)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_TALL_WILDWOOD_GRASS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILD_ROTTEN_WILDWOOD_GRASS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_GRASS_MID_DEPTHS)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, TitaniumPlacedFeatures.PATCH_WILDWOOD_WILD_OUTGROWTHS);
    }
}
