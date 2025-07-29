package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.EffectsChangedCriterion;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.item.TitaniumItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TitaniumAdvancementProvider extends FabricAdvancementProvider {
    public static Pair<MutableText, MutableText> DRINK_BLOOD = advancementTranslationKey("drink_blood");

    protected TitaniumAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    @SuppressWarnings("removal")
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        Identifier enterEndGateway = RegistryKey.of(RegistryKeys.ADVANCEMENT, Identifier.ofVanilla("end/enter_end_gateway")).getValue();

        Advancement.Builder.create()
                .parent(enterEndGateway)
                .display(
                        TitaniumItems.BLOOD_BUCKET,
                        DRINK_BLOOD.getLeft(),
                        DRINK_BLOOD.getRight(),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true, true, true
                )
                .rewards(AdvancementRewards.Builder.experience(50))
                .criterion(
                        Registries.ITEM.getId(TitaniumItems.BLOOD_BUCKET).getPath(),
                        ConsumeItemCriterion.Conditions.predicate(
                                ItemPredicate.Builder.create().items(TitaniumItems.BLOOD_BUCKET)
                        )
                )
                .build(consumer, Titanium.id("drink_blood").toString());
    }

    public static Pair<MutableText, MutableText> advancementTranslationKey(String name) {
        final String baseTranslationKey = "advancement.titanium." + name;
        return new Pair<>(Text.translatable(baseTranslationKey), Text.translatable(baseTranslationKey + ".description"));
    }
}
