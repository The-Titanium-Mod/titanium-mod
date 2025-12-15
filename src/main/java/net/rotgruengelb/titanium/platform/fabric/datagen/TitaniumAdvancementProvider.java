package net.rotgruengelb.titanium.platform.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.item.TitaniumItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TitaniumAdvancementProvider extends FabricAdvancementProvider {
    public static Tuple<MutableComponent, MutableComponent> DRINK_BLOOD = advancementTranslationKey("drink_blood");

    protected TitaniumAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    @SuppressWarnings({"removal", "unused"})
    public void generateAdvancement(HolderLookup.Provider wrapperLookup, Consumer<AdvancementHolder> consumer) {
        //? if 1.21.8 {
        HolderLookup<Item> itemLookup = wrapperLookup.lookupOrThrow(Registries.ITEM);
		HolderLookup<Block> blockLookup = wrapperLookup.lookupOrThrow(Registries.BLOCK);
         //?}
        ResourceLocation enterEndGateway = ResourceKey.create(Registries.ADVANCEMENT, ResourceLocation.withDefaultNamespace("end/enter_end_gateway")).location();

        Advancement.Builder.advancement()
                .parent(enterEndGateway)
                .display(
                        TitaniumItems.BLOOD_BUCKET,
                        DRINK_BLOOD.getA(),
                        DRINK_BLOOD.getB(),
                        null,
                        AdvancementType.CHALLENGE,
                        true, true, true
                )
                .rewards(AdvancementRewards.Builder.experience(50))
                .addCriterion(
                        BuiltInRegistries.ITEM.getKey(TitaniumItems.BLOOD_BUCKET).getPath(),
                        ConsumeItemTrigger.TriggerInstance.usedItem(
                                ItemPredicate.Builder.item().of(
                                        //? if 1.21.8 {
                                        itemLookup,
                                         //?}
                                        TitaniumItems.BLOOD_BUCKET
                                )
                        )
                )
                .save(consumer, Titanium.id("drink_blood").toString());
    }

    public static Tuple<MutableComponent, MutableComponent> advancementTranslationKey(String name) {
        final String baseTranslationKey = "advancement.titanium." + name;
        return new Tuple<>(Component.translatable(baseTranslationKey), Component.translatable(baseTranslationKey + ".description"));
    }
}
