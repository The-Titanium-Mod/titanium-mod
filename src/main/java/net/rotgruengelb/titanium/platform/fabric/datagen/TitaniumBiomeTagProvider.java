package net.rotgruengelb.titanium.platform.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;
//? if 1.21.8 {
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.ResourceKey;
//?}

import java.util.concurrent.CompletableFuture;

public class TitaniumBiomeTagProvider extends FabricTagProvider<Biome> {

    protected TitaniumBiomeTagProvider(
            FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tagBuilder(BiomeTags.IS_END).add(TitaniumBiomes.WILDWOOD_FOREST);
        tagBuilder(BiomeTags.IS_END).add(TitaniumBiomes.WILDWOOD_WASTES);
    }

    //? if 1.21.1 {
    /*protected FabricTagProvider<Biome>.FabricTagBuilder tagBuilder(TagKey<Biome> tag) {
        return getOrCreateTagBuilder(tag);
    }
    *///?} else {
    protected TagAppender<ResourceKey<Biome>, Biome> tagBuilder(TagKey<Biome> tag) {
        return super.builder(tag);
    }
    //?}
}
