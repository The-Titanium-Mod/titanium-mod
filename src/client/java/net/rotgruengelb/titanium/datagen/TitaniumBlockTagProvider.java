package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

import java.util.concurrent.CompletableFuture;

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
//? if 1.21.8 {
/*import net.minecraft.data.tag.ProvidedTagBuilder;
*///?}

public class TitaniumBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public TitaniumBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //@formatter:off
        tagBuilder(TitaniumBlockTags.WILDWOOD_TERRAIN).add(
                TitaniumBlocks.TENDON,
                TitaniumBlocks.BRAWN)
                .addTag(TitaniumBlockTags.CLART_SOIL);
        tagBuilder(TitaniumBlockTags.CLART_SOIL).add(
                CLART,
                VEINY_CLART)
                .addTag(TitaniumBlockTags.SOD);
        tagBuilder(TitaniumBlockTags.SOD).add(
                SOD,
                VEINY_SOD,
                SOD_BATCH,
                ROTTEN_SOD,
                ROTTEN_SOD_BATCH);
        tagBuilder(TitaniumBlockTags.VOLLON).add(
                BLUE_VOLLON,
                RED_VOLLON);
        tagBuilder(TitaniumBlockTags.SOD_BATCH).add(
                SOD_BATCH,
                ROTTEN_SOD_BATCH);
        tagBuilder(TitaniumBlockTags.WILDWOOD_LOGS).add(
                WILDWOOD_LOG,
                STRIPPED_WILDWOOD_LOG,
                WILDWOOD_WOOD,
                STRIPPED_WILDWOOD_WOOD);
        tagBuilder(TitaniumBlockTags.TEETH).add(
                SMALL_TEETH,
                GIANT_TOOTH,
                ROTTEN_GIANT_TOOTH);
        tagBuilder(TitaniumBlockTags.WILDWOOD_OUTGROWTHS).add(
                WILDWOOD_BLISTER,
                SHORT_WILDWOOD_GRASS,
                TALL_WILDWOOD_GRASS,
                WILDWOOD_LUMEN,
                ROTTEN_WILDWOOD_GRASS,
                ROTTING_WILDWOOD_GRASS)
                .addTag(TitaniumBlockTags.TEETH);
        tagBuilder(TitaniumBlockTags.VOLLON_OUTGROWTHS).add(
                VOLLON_BRONCHI,
                VOLLON_NOODLES,
                VOLLON_STRINGS);

		tagBuilder(BlockTags.PLANKS).add(
                WILDWOOD_PLANKS);
        tagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(TitaniumBlockTags.WILDWOOD_LOGS);
		tagBuilder(BlockTags.LEAVES).add(
                WILDWOOD_LEAVES);
		tagBuilder(BlockTags.FENCE_GATES).add(
                WILDWOOD_FENCE_GATE);
		tagBuilder(BlockTags.WOODEN_BUTTONS).add(
                WILDWOOD_BUTTON);
		tagBuilder(BlockTags.WOODEN_FENCES).add(
                WILDWOOD_FENCE);
		tagBuilder(BlockTags.WOODEN_DOORS).add(
                WILDWOOD_DOOR);
		tagBuilder(BlockTags.WOODEN_SLABS).add(
                WILDWOOD_SLAB);
		tagBuilder(BlockTags.WOODEN_STAIRS).add(
                WILDWOOD_STAIRS);
		tagBuilder(BlockTags.WOODEN_TRAPDOORS).add(
                WILDWOOD_TRAPDOOR);

        tagBuilder(BlockTags.SHOVEL_MINEABLE).add(
                SOD,
                VEINY_SOD,
                ROTTEN_SOD,
                CLART,
                VEINY_CLART);
        tagBuilder(BlockTags.HOE_MINEABLE).add(
                BLUE_VOLLON,
                RED_VOLLON,
                TENDON,
                WILDWOOD_LEAVES)
                .addTag(TitaniumBlockTags.SOD_BATCH)
                .addTag(TitaniumBlockTags.VOLLON);
        tagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                BRAWN,
                SALT)
                .addTag(TitaniumBlockTags.TEETH);
        tagBuilder(BlockTags.REPLACEABLE_BY_TREES)
                .addTag(TitaniumBlockTags.WILDWOOD_OUTGROWTHS);

        tagBuilder(BlockTags.REPLACEABLE)
                .add(getRegistryWrapperOrThrow(wrapperLookup, RegistryKeys.BLOCK)
                        .streamEntries()
                        .filter(r -> r.getKey().get().getValue().getNamespace().equals(Titanium.MOD_ID))
                        .map(RegistryEntry.Reference::value)
                        .filter(block -> block.getDefaultState().isReplaceable())
                        .toArray(Block[]::new));
        //@formatter:on
    }

    //? if 1.21.1 {
    protected FabricTagProvider<Block>.FabricTagBuilder tagBuilder(TagKey<Block> tag) {
        return getOrCreateTagBuilder(tag);
    }
    //?} else {
    /*protected ProvidedTagBuilder<Block, Block> tagBuilder(TagKey<Block> tag) {
        return super.valueLookupBuilder(tag);
    }
    *///?}

    @SuppressWarnings("SameParameterValue")
    private <T> RegistryWrapper.Impl<T> getRegistryWrapperOrThrow(RegistryWrapper.WrapperLookup registries, RegistryKey<Registry<T>> registryKey) {
        //? if 1.21.1 {
        return registries.getWrapperOrThrow(registryKey);
         //?} else {
        /*return registries.getOrThrow(registryKey);
        *///?}
    }
}
