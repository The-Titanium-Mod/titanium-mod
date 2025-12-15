package net.rotgruengelb.titanium.platform.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;

import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;
import net.rotgruengelb.titanium.world.gen.feature.TitaniumConfiguredFeatures;
import net.rotgruengelb.titanium.world.gen.feature.TitaniumPlacedFeatures;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TitaniumDynamicRegistryProvider extends FabricDynamicRegistryProvider {
    public TitaniumDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.BIOME, TitaniumBiomes::bootstrap);
        registryBuilder.add(Registries.CONFIGURED_FEATURE, TitaniumConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, TitaniumPlacedFeatures::bootstrap);
    }

    @Override
    public void configure(HolderLookup.Provider registries, Entries entries) {
        addAll(entries, registries.lookupOrThrow(Registries.BIOME), Titanium.MOD_ID);
        addAll(entries, registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), Titanium.MOD_ID);
        addAll(entries, registries.lookupOrThrow(Registries.PLACED_FEATURE), Titanium.MOD_ID);
    }

    @Override
    public @NotNull String getName() {
        return "Titanium Dynamic Registries";
    }

    /**
     * @see Entries#addAll(HolderLookup.RegistryLookup)
     */
    @SuppressWarnings("UnusedReturnValue")
    public <T> List<Holder<T>> addAll(Entries entries, HolderLookup.RegistryLookup<T> registry, String modId) {
        return registry.listElementIds().filter(registryKey -> registryKey.location().getNamespace().equals(modId)).map(key -> entries.add(registry, key)).toList();
    }
}
