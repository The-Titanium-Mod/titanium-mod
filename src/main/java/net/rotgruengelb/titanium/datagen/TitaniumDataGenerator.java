package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

public class TitaniumDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TitaniumLanguageProvider::new);
        pack.addProvider(TitaniumModelProvider::new);
        pack.addProvider(TitaniumBlockTagProvider::new);
        pack.addProvider(TitaniumFluidTagProvider::new);
        pack.addProvider(TitaniumItemTagProvider::new);
        pack.addProvider(TitaniumBlockLootTableProvider::new);
        pack.addProvider(TitaniumDynamicRegistryProvider::new);
        pack.addProvider(TitaniumBiomeTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        TitaniumDynamicRegistryProvider.buildRegistry(registryBuilder);
    }
}
