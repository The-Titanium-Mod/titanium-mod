package net.rotgruengelb.titanium.block;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;

public class TitaniumBlockTypes {

	public static class TitaniumWoodTypes {
		public static final WoodType WILDWOOD = register(new WoodType("titanium:wildwood",
				TitaniumBlockTypes.TitaniumBlockSetTypes.WILDWOOD));

		private static WoodType register(WoodType type) {
			WoodType.VALUES.put(type.name(), type);
			return type;
		}
	}

	public static class TitaniumBlockSetTypes {
		public static final BlockSetType WILDWOOD = register(new BlockSetType("titanium:wildwood"));

		private static BlockSetType register(BlockSetType blockSetType) {
			BlockSetType.VALUES.put(blockSetType.name, blockSetType);
			return blockSetType;
		}
	}
}
