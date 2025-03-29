package net.rotgruengelb.titanium.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.Titanium;

import java.util.function.Function;

public class TitaniumItems {

	public static Item item(String name, Item.Settings settings, Function<Item.Settings, Item> factory) {
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Titanium.MOD_ID, name));

		Item item = factory.apply(settings);

		Registry.register(Registries.ITEM, itemKey, item);
		return item;
	}

	public static void initialize() { }
}
