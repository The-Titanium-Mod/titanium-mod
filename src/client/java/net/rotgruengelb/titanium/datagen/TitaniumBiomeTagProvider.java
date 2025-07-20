package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;

//? if 1.21.8 {
/*import net.minecraft.data.tag.ProvidedTagBuilder;
import net.minecraft.registry.RegistryKey;
*///?}

import java.util.concurrent.CompletableFuture;

public class TitaniumBiomeTagProvider extends FabricTagProvider<Biome> {

    protected TitaniumBiomeTagProvider(
            FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        tagBuilder(BiomeTags.IS_END).add(TitaniumBiomes.WILDWOOD_WASTES);
    }

    //? if 1.21.1 {
    protected FabricTagProvider<Biome>.FabricTagBuilder tagBuilder(TagKey<net.minecraft.world.biome.Biome> tag) {
        return getOrCreateTagBuilder(tag);
    }
    //?} else {
    /*protected ProvidedTagBuilder<RegistryKey<Biome>, Biome> tagBuilder(TagKey<Biome> tag) {
        return super.builder(tag);
    }
    *///?}
}
