package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.item.TitaniumItems;

//? if 1.21.8 {
/*import net.minecraft.data.tag.ProvidedTagBuilder;
*///?}

import java.util.concurrent.CompletableFuture;

public class TitaniumItemTagProvider extends FabricTagProvider.ItemTagProvider {

	public TitaniumItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
		tagBuilder(ConventionalItemTags.BUCKETS).add(
				TitaniumItems.BLOOD_BUCKET
		);
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
