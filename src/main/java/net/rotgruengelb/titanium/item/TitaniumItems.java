package net.rotgruengelb.titanium.item;

import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;

import java.util.function.Function;

public class TitaniumItems {

	public static final Item BLOOD_BUCKET = item("blood_bucket",
			settings -> new BucketItem(TitaniumFluids.BLOOD, settings), new Item.Settings().recipeRemainder(Items.BUCKET)
			.maxCount(1));

	public static Item item(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Titanium.MOD_ID, name));

		Item item = factory.apply(settings);

		Registry.register(Registries.ITEM, itemKey, item);
		return item;
	}

	public static void initialize() { }
}
