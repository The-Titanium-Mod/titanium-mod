package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TitaniumDynamicRegistryProvider extends FabricDynamicRegistryProvider {
    public TitaniumDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.BIOME, TitaniumBiomes::bootstrap);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        addAll(entries, registries.getWrapperOrThrow(RegistryKeys.BIOME), Titanium.MOD_ID);
    }

    @Override
    public String getName() {
        return "Titanium Dynamic Registries";
    }

    /**
     * @see FabricDynamicRegistryProvider.Entries#addAll(RegistryWrapper.Impl)
     */
    public <T> List<RegistryEntry<T>> addAll(Entries entries, RegistryWrapper.Impl<T> registry, String modId) {
        return registry.streamKeys().filter(registryKey -> registryKey.getValue().getNamespace().equals(modId)).map(key -> entries.add(registry, key)).toList();
    }
}
