package net.rotgruengelb.titanium.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
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
        return item(RegistryKey.of(RegistryKeys.ITEM, Titanium.id(name)), factory, settings);
    }

    public static Item item(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        //? if 1.21.8 {
        /*settings = settings.registryKey(key);
        *///?}
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public static Item.Settings createBlockItemSettingFor(Block block) {
        @SuppressWarnings({"UnnecessaryLocalVariable", "RedundantSuppression"})
        Item.Settings settings = new BlockItem.Settings();
        //? if 1.21.8 {
        /*return settings.translationKey(block.getTranslationKey());
         *///?} else {
        return settings;
        //?}
    }

	public static void initialize() { }
}
