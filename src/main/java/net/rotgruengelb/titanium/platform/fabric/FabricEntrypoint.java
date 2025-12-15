package net.rotgruengelb.titanium.platform.fabric;

//? fabric {

import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;
import net.rotgruengelb.titanium.Titanium;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		Titanium.onInitialize();
		FabricEventSubscriber.registerEvents();
	}
}
//?}
