package net.rotgruengelb.titanium.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PATCH_GRASS_JUNGLE = placedFeature("patch_grass_jungle");

    public static RegistryKey<PlacedFeature> placedFeature(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Titanium.id(name));
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {

    }
}
