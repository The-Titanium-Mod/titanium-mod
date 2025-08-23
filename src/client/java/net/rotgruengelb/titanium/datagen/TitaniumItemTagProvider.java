package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.item.TitaniumItems;
import net.rotgruengelb.titanium.registry.tag.TitaniumBlockTags;
import net.rotgruengelb.titanium.registry.tag.TitaniumItemTags;
import org.jetbrains.annotations.Nullable;

//? if 1.21.8 {
/*import net.minecraft.data.tag.ProvidedTagBuilder;
*///?}

import java.util.concurrent.CompletableFuture;

public class TitaniumItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public TitaniumItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
        tagBuilder(ConventionalItemTags.BUCKETS).add(
				TitaniumItems.BLOOD_BUCKET);
        tagBuilder(ConventionalItemTags.FRUIT_FOODS).add(
                TitaniumItems.HARLIC);

        copy(TitaniumBlockTags.WILDWOOD_TERRAIN, TitaniumItemTags.WILDWOOD_TERRAIN);
        copy(TitaniumBlockTags.CLART_SOIL, TitaniumItemTags.CLART_SOIL);
        copy(TitaniumBlockTags.SOD, TitaniumItemTags.SOD);
        copy(TitaniumBlockTags.VOLLON, TitaniumItemTags.VOLLON);
        copy(TitaniumBlockTags.SOD_BATCH, TitaniumItemTags.SOD_BATCH);
        copy(TitaniumBlockTags.TEETH, TitaniumItemTags.TEETH);
        copy(TitaniumBlockTags.WILDWOOD_LOGS, TitaniumItemTags.WILDWOOD_LOGS);
        copy(TitaniumBlockTags.WILDWOOD_OUTGROWTHS, TitaniumItemTags.WILDWOOD_OUTGROWTHS);
        copy(TitaniumBlockTags.VOLLON_OUTGROWTHS, TitaniumItemTags.VOLLON_OUTGROWTHS);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(ConventionalBlockTags.WOODEN_FENCES, ConventionalItemTags.WOODEN_FENCES);
        copy(ConventionalBlockTags.WOODEN_FENCE_GATES, ConventionalItemTags.WOODEN_FENCE_GATES);
        copy(ConventionalBlockTags.STRIPPED_LOGS, ConventionalItemTags.STRIPPED_LOGS);
        copy(ConventionalBlockTags.STRIPPED_WOODS, ConventionalItemTags.STRIPPED_WOODS);
		//@formatter:on
	}

    //? if 1.21.1 {
    protected FabricTagProvider<Item>.FabricTagBuilder tagBuilder(TagKey<Item> tag) {
        return getOrCreateTagBuilder(tag);
    }
    //?} else {
    /*protected ProvidedTagBuilder<Item, Item> tagBuilder(TagKey<Item> tag) {
        return super.valueLookupBuilder(tag);
    }
    *///?}
}
