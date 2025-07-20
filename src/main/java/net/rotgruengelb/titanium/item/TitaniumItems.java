package net.rotgruengelb.titanium.item;

import net.minecraft.entity.EntityType;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.entity.TitaniumEntities;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;

import java.util.function.Function;

public class TitaniumItems {

	public static final Item BLOOD_BUCKET = item("blood_bucket",
			settings -> new BucketItem(TitaniumFluids.BLOOD, settings), new Item.Settings()
					.recipeRemainder(Items.BUCKET)
					.maxCount(1));

	public static final Item WASPEPHANT_SPAWN_EGG = item("waspehpant_spawn_egg",
			settings -> new SpawnEggItem(TitaniumEntities.WASPEPHANT, 0x48315b, 0x151515, settings), new Item.Settings());

	public static Item item(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Titanium.id(name));

		Item item = factory.apply(settings);

		Registry.register(Registries.ITEM, itemKey, item);
		return item;
	}

	public static void initialize() { }
}
