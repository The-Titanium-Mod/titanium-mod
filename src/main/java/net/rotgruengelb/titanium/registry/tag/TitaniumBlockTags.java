package net.rotgruengelb.titanium.registry.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumBlockTags {

	public static final TagKey<Block> CLART = TagKey.of(RegistryKeys.BLOCK, Titanium.id("clart"));
	public static final TagKey<Block> VOLLON = TagKey.of(RegistryKeys.BLOCK, Titanium.id("vollon"));
}
