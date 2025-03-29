package net.rotgruengelb.titanium;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.item.TitaniumItemGroups;
import net.rotgruengelb.titanium.item.TitaniumItems;
import net.rotgruengelb.titanium.world.TitaniumGameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Titanium implements ModInitializer {

	public static final String MOD_ID = "titanium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final String VERSION = /*$ mod_version*/ "0.1.0";

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		TitaniumItems.initialize();
		TitaniumBlocks.initialize();
		TitaniumFluids.initialize();
		TitaniumGameRules.initialize();
		TitaniumItemGroups.initialize();
	}
}