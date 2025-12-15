package net.rotgruengelb.titanium.platform.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;

import java.util.concurrent.CompletableFuture;

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
//? if 1.21.8 {
import net.minecraft.data.tags.TagAppender;
//?}

public class TitaniumBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public TitaniumBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
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
        tagBuilder(BlockTags.SAPLINGS).add(
                WILDWOOD_SAPLING);

        tagBuilder(ConventionalBlockTags.WOODEN_FENCE_GATES).add(
                WILDWOOD_FENCE_GATE);
        tagBuilder(ConventionalBlockTags.WOODEN_FENCES).add(
                WILDWOOD_FENCE);
        tagBuilder(ConventionalBlockTags.STRIPPED_LOGS).add(
                STRIPPED_WILDWOOD_LOG);
        tagBuilder(ConventionalBlockTags.STRIPPED_WOODS).add(
                STRIPPED_WILDWOOD_WOOD);

        tagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(
                SOD,
                VEINY_SOD,
                ROTTEN_SOD,
                CLART,
                VEINY_CLART);
        tagBuilder(BlockTags.MINEABLE_WITH_HOE).add(
                BLUE_VOLLON,
                RED_VOLLON,
                TENDON,
                WILDWOOD_LEAVES)
                .addTag(TitaniumBlockTags.SOD_BATCH)
                .addTag(TitaniumBlockTags.VOLLON);
        tagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
                BRAWN,
                SALT)
                .addTag(TitaniumBlockTags.TEETH);
        tagBuilder(BlockTags.REPLACEABLE_BY_TREES)
                .addTag(TitaniumBlockTags.WILDWOOD_OUTGROWTHS);

        tagBuilder(BlockTags.REPLACEABLE)
                .add(wrapperLookup.lookupOrThrow(Registries.BLOCK)
                        .listElements()
                        .filter(r -> r.unwrapKey().get().location().getNamespace().equals(Titanium.MOD_ID))
                        .map(Holder.Reference::value)
                        .filter(block -> block.defaultBlockState().canBeReplaced())
                        .toArray(Block[]::new));
        //@formatter:on
    }

    //? if 1.21.1 {
    /*protected FabricTagProvider<Block>.FabricTagBuilder tagBuilder(TagKey<Block> tag) {
        return getOrCreateTagBuilder(tag);
    }
    *///?} else {
    protected TagAppender<Block, Block> tagBuilder(TagKey<Block> tag) {
        return super.valueLookupBuilder(tag);
    }
    //?}
}
