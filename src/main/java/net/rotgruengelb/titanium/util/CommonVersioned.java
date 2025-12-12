package net.rotgruengelb.titanium.util;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.WorldGenLevel;

public class CommonVersioned {

	public static int getWorldMinY(WorldGenLevel world) {
		//? if 1.21.1 {
		return world.getMinBuildHeight();
		//?} else {
		/*return world.getMinY();
		 *///?}
	}

	public static Vec3i getDirectionUnitVec3i(Direction direction) {
		//? if 1.21.8 {
		/*return direction.getUnitVec3i();
		*///?} else {
		return direction.getNormal();
		//?}
	}
}
