package net.rotgruengelb.titanium.item;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;

//? if 1.21.8 {
/*import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
 *///?}

import java.util.function.Function;

public class TitaniumItems {

	public static final Item BLOOD_BUCKET = item(
            "blood_bucket",
			settings -> new BloodBucketItem(TitaniumFluids.BLOOD, settings),
            createBloodBucketItemSettings());
    public static final Item HARLIC = item(
            "harlic",
            harlicSettings());
    public static final Item VOLLON_ALVEOLI = item(
            "vollon_alveoli",
            settings());
    public static final Item VOLLON_LIGAMENTS = item(
            "vollon_ligaments",
            settings());

    public static Item item(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        return item(ResourceKey.create(Registries.ITEM, Titanium.id(name)), factory, settings);
    }

    public static Item item(String name, Item.Properties settings) {
        return item(ResourceKey.create(Registries.ITEM, Titanium.id(name)), Item::new, settings);
    }

    public static Item item(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
        //? if 1.21.8 {
        /*settings = settings.setId(key);
        *///?}
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static Item.Properties blockItemSettingFor(Block block) {
        //? if 1.21.8 {
        /*return blockItemSettings().overrideDescription(block.getDescriptionId());
         *///?} else {
        return settings();
        //?}
    }

    private static Item.Properties createBloodBucketItemSettings() {
        Item.Properties settings = blockItemSettings()
                .craftRemainder(Items.BUCKET)
                .stacksTo(1);
         FoodProperties.Builder foodBuilder = new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(0);
        //? if 1.21.1 {
        settings.food(
                foodBuilder.effect(
                        new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 1.0F
                ).build()
        );
        //?} else {
        /*settings.food(foodBuilder.build(), Consumables.defaultDrink()
                        .consumeSeconds(6.0F)
                        .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 600, 0), 1.0F))
                        .build())
                .usingConvertsTo(Items.BUCKET);
        *///?}
        return settings;
    }

    private static Item.Properties blockItemSettings() {
        return new BlockItem.Properties();
    }

    private static Item.Properties settings() {
        return new BlockItem.Properties();
    }

    private static Item.Properties harlicSettings() {
        return settings().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build());
    }

	public static void initialize() {
        Titanium.LOGGER.debug("Initialized TitaniumItems");
    }
}
