package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
import static net.rotgruengelb.titanium.item.TitaniumItems.*;

public class TitaniumBlockLootTableProvider extends FabricBlockLootTableProvider {

    protected TitaniumBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void generate() {
        addClartDrop(CLART);
        addClartDrop(SOD);
        addClartDrop(VEINY_SOD);
        addClartDrop(ROTTEN_SOD);
        addClartDrop(VEINY_CLART);

        addShearsDrop(HANGING_TENDON);
        addShearsDrop(TALL_WILDWOOD_GRASS);
        addShearsDrop(ROTTING_WILDWOOD_GRASS);
        addShearsDrop(ROTTEN_WILDWOOD_GRASS);
        addShearsDrop(SHORT_WILDWOOD_GRASS);
        addShearsDrop(WILDWOOD_LUMEN);

        addVollonDrop(VOLLON_NOODLES, 0, 0, 3, 4);
        addVollonDrop(VOLLON_STRINGS, 0, 1, 2, 3);
        addVollonDrop(VOLLON_BRONCHI, 2, 3, 0, 1);

        addOnlyShearsOrSilkTouchDrop(WILDWOOD_BLISTER);
        addOnlyShearsOrSilkTouchDrop(BUNNY_CATCHER);

        addDrop(WILDWOOD_LEAVES, wildwoodLeavesDrops(WILDWOOD_LEAVES, WILDWOOD_SAPLING, HARLIC));

        addDrop(BLUE_VOLLON);
        addDrop(RED_VOLLON);
        addDrop(TENDON);
        addDrop(BRAWN);
        addDrop(GIANT_TOOTH);
        addDrop(ROTTEN_SOD_BATCH);
        addDrop(SOD_BATCH);
        addDrop(SALT);
        addDrop(SMALL_TEETH);
        addDrop(ROTTEN_GIANT_TOOTH);

        addDrop(WILDWOOD_SAPLING);
        addDrop(WILDWOOD_LOG);
        addDrop(WILDWOOD_WOOD);
        addDrop(STRIPPED_WILDWOOD_LOG);
        addDrop(STRIPPED_WILDWOOD_WOOD);
        addDrop(WILDWOOD_PLANKS);
        addDrop(WILDWOOD_SLAB);
        addDrop(WILDWOOD_STAIRS);
        addDrop(WILDWOOD_BUTTON);
        addDrop(WILDWOOD_PRESSURE_PLATE);
        addDrop(WILDWOOD_DOOR, doorDrops(WILDWOOD_DOOR));
        addDrop(WILDWOOD_TRAPDOOR);
        addDrop(WILDWOOD_FENCE);
        addDrop(WILDWOOD_FENCE_GATE);
    }

    public void addClartDrop(Block block) {
        this.addDrop(block, block1 -> this.drops(block1, CLART));
    }

    public void addShearsDrop(Block block) {
        this.addDrop(block, dropsWithShears(block));
    }

    public void addOnlyShearsOrSilkTouchDrop(Block block) {
        this.addDrop(block, dropsOnlyWithSilkTouchOrShears(block));
    }

    public LootTable.Builder dropsOnlyWithSilkTouchOrShears(ItemConvertible drop) {
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).conditionally(this.createWithShearsCondition().or(this.createSilkTouchCondition())).with(ItemEntry.builder(drop)));
    }

    public LootCondition.Builder createWithShearsCondition() {
        //? if 1.21.1 {
        return MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS));
        //?} else {
        /*return super.createWithShearsCondition();
        *///?}
    }

    public void addVollonDrop(Block block, int minAlveoli, int maxAlveoli, int minLigaments, int maxLigaments) {
        this.addDrop(block, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(this.getWithSilkTouchOrShearsCondition())
                        .with(ItemEntry.builder(block))
                )
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(this.getWithSilkTouchOrShearsCondition().invert())
                        .with(this.applyExplosionDecay(
                                block,
                                ItemEntry.builder(VOLLON_ALVEOLI)
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(minAlveoli, maxAlveoli)))
                        ))
                )
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(this.getWithSilkTouchOrShearsCondition().invert())
                        .with(this.applyExplosionDecay(
                                block,
                                ItemEntry.builder(VOLLON_LIGAMENTS)
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(minLigaments, maxLigaments)))
                        ))
                )
        );
    }

    public LootCondition.Builder getWithSilkTouchOrShearsCondition() {
        //? if 1.21.1 {
        return this.createWithShearsOrSilkTouchCondition();
         //?} else {
        /*return this.createWithSilkTouchOrShearsCondition();
        *///?}
    }

    protected LootTable.Builder wildwoodLeavesDrops(Block leaves, Block sapling, ItemConvertible fruit) {
        RegistryWrapper.Impl<Enchantment> impl = getRegistryWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, SAPLING_DROP_CHANCE)
                .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .with(
                                        this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(fruit))
                                                .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))
                                )
                );
    }

    @SuppressWarnings("SameParameterValue")
    public  <T> RegistryWrapper.Impl<T> getRegistryWrapperOrThrow(RegistryKey<Registry<T>> registryKey) {
        //? if 1.21.1 {
        return this.registryLookup.getWrapperOrThrow(registryKey);
        //?} else {
        /*return this.registries.getOrThrow(registryKey);
         *///?}
    }
}
