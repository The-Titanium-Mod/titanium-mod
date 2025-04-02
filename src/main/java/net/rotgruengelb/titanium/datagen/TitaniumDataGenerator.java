package net.rotgruengelb.titanium.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TitaniumDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TitaniumLanguageProvider::new);
		pack.addProvider(TitaniumModelProvider::new);
		pack.addProvider(TitaniumBlockTagProvider::new);
		pack.addProvider(TitaniumFluidTagProvider::new);
		pack.addProvider(TitaniumItemTagProvider::new);
	}
}
