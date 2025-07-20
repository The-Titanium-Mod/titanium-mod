package net.rotgruengelb.titanium.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumEntities {

	public static EntityType<WaspephantEntity> WASPEPHANT = register("waspephant",
			EntityType.Builder.create(WaspephantEntity::new, SpawnGroup.MONSTER)
					.dimensions(3.0f, 3.0f)
					.eyeHeight(2.5f)
	);

	private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
		Identifier id = Titanium.id(name);
		return Registry.register(Registries.ENTITY_TYPE, id, builder.build(name));
	}

	public static void initialize() {
		FabricDefaultAttributeRegistry.register(WASPEPHANT, WaspephantEntity.createAttributes());
	}

}
