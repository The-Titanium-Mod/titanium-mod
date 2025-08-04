package net.rotgruengelb.titanium.registry.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumBlockTags {

	public static final TagKey<Block> CLART_SOIL = tag("clart_soil");
	public static final TagKey<Block> VOLLON = tag("vollon");

	private static TagKey<Block> tag(String id) {
		return TagKey.of(RegistryKeys.BLOCK, Titanium.id(id));
	}
}
