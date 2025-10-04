package net.rotgruengelb.titanium.registry.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumBlockTags {

	public static final TagKey<Block> CLART_SOIL = tag("clart_soil");
    public static final TagKey<Block> SOD = tag("sod");
    public static final TagKey<Block> SOD_BATCH = tag("sod_batch");
	public static final TagKey<Block> VOLLON = tag("vollon");
    public static final TagKey<Block> VOLLON_OUTGROWTHS = tag("vollon_outgrowths");
    public static final TagKey<Block> WILDWOOD_TERRAIN = tag("wildwood_terrain");
    public static final TagKey<Block> WILDWOOD_LOGS = tag("wildwood_logs");
    public static final TagKey<Block> WILDWOOD_OUTGROWTHS = tag("wildwood_outgrowths");
    public static final TagKey<Block> TEETH = tag("teeth");

	private static TagKey<Block> tag(String id) {
		return TagKey.of(RegistryKeys.BLOCK, Titanium.id(id));
	}
}
