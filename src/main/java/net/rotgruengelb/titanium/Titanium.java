package net.rotgruengelb.titanium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.fluid.TitaniumFluids;
import net.rotgruengelb.titanium.item.TitaniumItemGroups;
import net.rotgruengelb.titanium.item.TitaniumItems;
import net.rotgruengelb.titanium.world.TitaniumGameRules;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;
import net.rotgruengelb.titanium.world.gen.densityfunction.TitaniumDensityFunctionTypes;
import net.rotgruengelb.titanium.world.gen.feature.TitaniumFeatures;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Titanium implements ModInitializer {

    public static final String MOD_ID = "titanium";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final String VERSION = /*$ mod_version*/ "0.1.0";

    public static @NotNull Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

    @Override
    public void onInitialize() {

        TitaniumItems.initialize();
        TitaniumBlocks.initialize();
        TitaniumFluids.initialize();
        TitaniumGameRules.initialize();
        TitaniumItemGroups.initialize();
        TitaniumBiomes.initialize();
        TitaniumDensityFunctionTypes.initialize();
        TitaniumFeatures.initialize();

        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
            registerBuiltinResourcePack(modContainer, "new_terrain", ResourcePackActivationType.DEFAULT_ENABLED);
        });
    }

    static void registerBuiltinResourcePack(ModContainer modContainer, String path, ResourcePackActivationType activationType) {
        ResourceManagerHelper.registerBuiltinResourcePack(Titanium.id(path), modContainer, Text.translatable("pack.titanium." + path), activationType);
    }
}