package net.rotgruengelb.titanium.registry.tag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumItemTags {

    public static final TagKey<Item> CLART_SOIL = tag("clart_soil");
    public static final TagKey<Item> SOD = tag("sod");
    public static final TagKey<Item> SOD_BATCH = tag("sod_batch");
    public static final TagKey<Item> VOLLON = tag("vollon");
    public static final TagKey<Item> VOLLON_OUTGROWTHS = tag("vollon_outgrowths");
    public static final TagKey<Item> WILDWOOD_TERRAIN = tag("wildwood_terrain");
    public static final TagKey<Item> WILDWOOD_LOGS = tag("wildwood_logs");
    public static final TagKey<Item> WILDWOOD_OUTGROWTHS = tag("wildwood_outgrowths");
    public static final TagKey<Item> TEETH = tag("teeth");

	private static TagKey<Item> tag(String id) {
		return TagKey.of(RegistryKeys.ITEM, Titanium.id(id));
	}
}
