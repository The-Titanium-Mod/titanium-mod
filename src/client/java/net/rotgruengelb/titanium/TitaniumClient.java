package net.rotgruengelb.titanium;

import net.fabricmc.api.ClientModInitializer;

public class TitaniumClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		TitaniumRenderer.initialize();
	}
}