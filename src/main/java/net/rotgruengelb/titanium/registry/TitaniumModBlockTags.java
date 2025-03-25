package net.rotgruengelb.titanium.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.TitaniumMod;

public class TitaniumModBlockTags
{
    public static final TagKey<Block> CLART = TagKey.of(RegistryKeys.BLOCK, TitaniumMod.id("clart"));
    public static final TagKey<Block> VOLLON = TagKey.of(RegistryKeys.BLOCK, TitaniumMod.id("vollon"));
}
