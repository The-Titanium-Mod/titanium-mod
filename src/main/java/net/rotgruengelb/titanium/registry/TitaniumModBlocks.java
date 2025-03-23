package net.rotgruengelb.titanium.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.rotgruengelb.titanium.TitaniumMod;

import java.util.function.Function;

public class TitaniumModBlocks
{
    public static Block CLART = register("clart", Block::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.ROOTED_DIRT));

    public static Block SOD = register("sod", Block::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.NYLIUM));

    public static Block SOD_BATCH = register("sod_batch", Block::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS));

    public static Block VEINY_CLART = register("veiny_clart", Block::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.ROOTED_DIRT));

    public static Block VEINY_SOD = register("veiny_sod", Block::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.NYLIUM));

    public static Block ROTTEN_SOD = register("rotten_sod", Block::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.NYLIUM));

    public static Block ROTTEN_SOD_BATCH = register("rotten_sod_batch", Block::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.GRASS));

    protected static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, TitaniumMod.id(name));

        Block block = factory.apply(settings);

        TitaniumModItems.register(name,
                new BlockItem.Settings(),
                itemSettings -> new BlockItem(block, itemSettings));

        Registry.register(Registries.BLOCK, blockKey, block);
        return block;
    }

    protected static Block registerWithoutItem(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, Block> factory) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, TitaniumMod.id(name));

        Block block = factory.apply(settings);

        Registry.register(Registries.BLOCK, blockKey, block);
        return block;
    }

    public static void initialize() {

    }
}
