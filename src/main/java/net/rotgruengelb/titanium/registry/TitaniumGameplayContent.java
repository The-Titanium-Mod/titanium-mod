package net.rotgruengelb.titanium.registry;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.rotgruengelb.titanium.Titanium;
import net.rotgruengelb.titanium.block.TitaniumBlocks;

public class TitaniumGameplayContent {
    public static void initialize() {
        StrippableBlockRegistry.register(TitaniumBlocks.WILDWOOD_LOG, TitaniumBlocks.STRIPPED_WILDWOOD_LOG);
        StrippableBlockRegistry.register(TitaniumBlocks.WILDWOOD_WOOD, TitaniumBlocks.STRIPPED_WILDWOOD_WOOD);

        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.SOD_BATCH, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.ROTTEN_SOD_BATCH, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.ROTTING_WILDWOOD_GRASS, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.ROTTEN_WILDWOOD_GRASS, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.WILDWOOD_BLISTER, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.WILDWOOD_LUMEN, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.SHORT_WILDWOOD_GRASS, 0.30F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.BLUE_VOLLON, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.RED_VOLLON, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.VOLLON_BRONCHI, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.VOLLON_NOODLES, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.VOLLON_STRINGS, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.WILDWOOD_LEAVES, 0.30F);
        CompostingChanceRegistry.INSTANCE.add(TitaniumBlocks.WILDWOOD_SAPLING, 0.30F);

        Titanium.LOGGER.debug("Initialized TitaniumGameplayContent");
    }
}
