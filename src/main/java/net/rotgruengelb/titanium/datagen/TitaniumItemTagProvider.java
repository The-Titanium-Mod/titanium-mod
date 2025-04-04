package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.rotgruengelb.titanium.item.TitaniumItems;

import java.util.concurrent.CompletableFuture;

public class TitaniumItemTagProvider extends FabricTagProvider.ItemTagProvider {

	public TitaniumItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//@formatter:off
		getOrCreateTagBuilder(ConventionalItemTags.BUCKETS).add(
				TitaniumItems.BLOOD_BUCKET
		);
		//@formatter:on
	}
}
