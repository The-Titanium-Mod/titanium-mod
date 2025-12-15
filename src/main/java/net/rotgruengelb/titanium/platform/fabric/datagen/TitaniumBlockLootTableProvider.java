package net.rotgruengelb.titanium.platform.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static net.rotgruengelb.titanium.block.TitaniumBlocks.*;
import static net.rotgruengelb.titanium.item.TitaniumItems.*;

public class TitaniumBlockLootTableProvider extends FabricBlockLootTableProvider {

    protected TitaniumBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
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

        add(WILDWOOD_LEAVES, wildwoodLeavesDrops(WILDWOOD_LEAVES, WILDWOOD_SAPLING, HARLIC));

        dropSelf(BLUE_VOLLON);
        dropSelf(RED_VOLLON);
        dropSelf(TENDON);
        dropSelf(BRAWN);
        dropSelf(GIANT_TOOTH);
        dropSelf(ROTTEN_SOD_BATCH);
        dropSelf(SOD_BATCH);
        dropSelf(SALT);
        dropSelf(SMALL_TEETH);
        dropSelf(ROTTEN_GIANT_TOOTH);

        dropSelf(WILDWOOD_SAPLING);
        dropSelf(WILDWOOD_LOG);
        dropSelf(WILDWOOD_WOOD);
        dropSelf(STRIPPED_WILDWOOD_LOG);
        dropSelf(STRIPPED_WILDWOOD_WOOD);
        dropSelf(WILDWOOD_PLANKS);
        dropSelf(WILDWOOD_SLAB);
        dropSelf(WILDWOOD_STAIRS);
        dropSelf(WILDWOOD_BUTTON);
        dropSelf(WILDWOOD_PRESSURE_PLATE);
        add(WILDWOOD_DOOR, createDoorTable(WILDWOOD_DOOR));
        dropSelf(WILDWOOD_TRAPDOOR);
        dropSelf(WILDWOOD_FENCE);
        dropSelf(WILDWOOD_FENCE_GATE);
    }

    public void addClartDrop(Block block) {
        this.add(block, block1 -> this.createSingleItemTableWithSilkTouch(block1, CLART));
    }

    public void addShearsDrop(Block block) {
        this.add(block, createShearsOnlyDrop(block));
    }

    public void addOnlyShearsOrSilkTouchDrop(Block block) {
        this.add(block, dropsOnlyWithSilkTouchOrShears(block));
    }

    public LootTable.Builder dropsOnlyWithSilkTouchOrShears(ItemLike drop) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.createWithShearsCondition().or(this.hasSilkTouch())).add(LootItem.lootTableItem(drop)));
    }

    public LootItemCondition.Builder createWithShearsCondition() {
        //? if 1.21.1 {
        /*return MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
        *///?} else {
        return super.hasShears();
        //?}
    }

    public void addVollonDrop(Block block, int minAlveoli, int maxAlveoli, int minLigaments, int maxLigaments) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.getWithSilkTouchOrShearsCondition())
                        .add(LootItem.lootTableItem(block))
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.getWithSilkTouchOrShearsCondition().invert())
                        .add(this.applyExplosionDecay(
                                block,
                                LootItem.lootTableItem(VOLLON_ALVEOLI)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(minAlveoli, maxAlveoli)))
                        ))
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.getWithSilkTouchOrShearsCondition().invert())
                        .add(this.applyExplosionDecay(
                                block,
                                LootItem.lootTableItem(VOLLON_LIGAMENTS)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(minLigaments, maxLigaments)))
                        ))
                )
        );
    }

    public LootItemCondition.Builder getWithSilkTouchOrShearsCondition() {
		return this.hasShearsOrSilkTouch();
    }

    protected LootTable.Builder wildwoodLeavesDrops(Block leaves, Block sapling, ItemLike fruit) {
        HolderLookup.RegistryLookup<Enchantment> impl = getRegistryWrapperOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(leaves, sapling, NORMAL_LEAVES_SAPLING_CHANCES)
                .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveShearsOrSilkTouch())
                                .add(
                                        this.applyExplosionCondition(leaves, LootItem.lootTableItem(fruit))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(impl.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))
                                )
                );
    }

    @SuppressWarnings("SameParameterValue")
    public <T> HolderLookup.RegistryLookup<T> getRegistryWrapperOrThrow(ResourceKey<Registry<T>> registryKey) {
        return this.registries.lookupOrThrow(registryKey);
    }
}
