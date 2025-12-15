package net.rotgruengelb.titanium.platform.fabric.datagen;

//? fabric {

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;

public class FabricDataGeneratorEntrypoint implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		var blockTagProvider = pack.addProvider(TitaniumBlockTagProvider::new);
		pack.addProvider((o, r) -> new TitaniumItemTagProvider(o, r, blockTagProvider));
		pack.addProvider(TitaniumBlockLootTableProvider::new);
		pack.addProvider(TitaniumLanguageProvider::new);
		pack.addProvider(TitaniumModelProvider::new);
		pack.addProvider(TitaniumFluidTagProvider::new);
		pack.addProvider(TitaniumDynamicRegistryProvider::new);
		pack.addProvider(TitaniumBiomeTagProvider::new);
		pack.addProvider(TitaniumAdvancementProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		TitaniumDynamicRegistryProvider.buildRegistry(registryBuilder);
	}
}

//?}
