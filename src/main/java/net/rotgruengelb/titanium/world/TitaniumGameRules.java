package net.rotgruengelb.titanium.world;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> BLOOD_SOURCE_CONVERSION = GameRuleRegistry.register("titanium:bloodSourceConversion", net.minecraft.world.level.GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));

	public static void initialize() {
        Titanium.LOGGER.debug("Initialized TitaniumGameRules");
    }
}
