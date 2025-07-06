package net.rotgruengelb.titanium.block;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.rotgruengelb.titanium.Titanium;

public class TitaniumBlockTypes {

    public static class TitaniumWoodTypes {
        public static final WoodType WILDWOOD = woodType("wildwood", TitaniumBlockSetTypes.WILDWOOD, new WoodTypeBuilder());

        private static WoodType woodType(String name, BlockSetType blockSetType, WoodTypeBuilder woodTypeBuilder) {
            return woodTypeBuilder.register(Titanium.id(name), blockSetType);
        }
    }

    public static class TitaniumBlockSetTypes {

        public static final BlockSetType WILDWOOD = blockSet("wildwood", new BlockSetTypeBuilder());

        private static BlockSetType blockSet(String name, BlockSetTypeBuilder blockSetTypeBuilder) {
            return blockSetTypeBuilder.register(Titanium.id(name));
        }
    }
}
