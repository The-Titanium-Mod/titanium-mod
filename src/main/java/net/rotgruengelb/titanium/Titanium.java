package net.rotgruengelb.titanium;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.item.TitaniumItemGroups;
import net.rotgruengelb.titanium.item.TitaniumItems;
import net.rotgruengelb.titanium.platform.Platform;
import net.rotgruengelb.titanium.platform.fabric.FabricPlatform;
import net.rotgruengelb.titanium.registry.TitaniumGameplayContent;
import net.rotgruengelb.titanium.world.TitaniumGameRules;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;
import net.rotgruengelb.titanium.world.gen.densityfunction.TitaniumDensityFunctionTypes;
import net.rotgruengelb.titanium.world.gen.feature.TitaniumFeatures;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {

//?} neoforge {
/*import com.example.modtemplate.platform.neoforge.NeoforgePlatform;
 *///?}

@SuppressWarnings("LoggingSimilarMessage")
public class Titanium {

	public static final String MOD_ID = /*$ mod_id*/ "titanium";
	public static final String MOD_VERSION = /*$ mod_version*/ "0.1.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Titanium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_ID, Titanium.xplat().loader());

		TitaniumItems.initialize();
		TitaniumBlocks.initialize();
		TitaniumFluids.initialize();
		TitaniumGameRules.initialize();
		TitaniumItemGroups.initialize();
		TitaniumGameplayContent.initialize();

		// Worldgen
		TitaniumBiomes.initialize();
		TitaniumDensityFunctionTypes.initialize();
		TitaniumFeatures.initialize();

		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			registerBuiltinResourcePack(modContainer, "new_terrain", ResourcePackActivationType.DEFAULT_ENABLED);
		});
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}", MOD_ID, Titanium.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static @NotNull ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	static void registerBuiltinResourcePack(ModContainer modContainer, String path, ResourcePackActivationType activationType) {
		ResourceManagerHelper.registerBuiltinResourcePack(Titanium.id(path), modContainer, Component.translatable("pack.titanium." + path), activationType);
	}

	static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?}
	}
}
