package net.rotgruengelb.titanium.world;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class TitaniumGameRules {
	public static final GameRules.Key<GameRules.BooleanRule> BLOOD_SOURCE_CONVERSION = GameRuleRegistry.register("titanium:bloodSourceConversion", net.minecraft.world.GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));

	public static void initialize() { }
}