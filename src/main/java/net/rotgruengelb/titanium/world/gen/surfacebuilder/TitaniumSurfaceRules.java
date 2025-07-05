package net.rotgruengelb.titanium.world.gen.surfacebuilder;

import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;

import static net.minecraft.world.gen.surfacebuilder.MaterialRules.*;

public class TitaniumSurfaceRules {

    public static MaterialRules.MaterialRule createTitaniumEndSurfaceRule() {
        //@formatter:off
        return sequence(
                condition(
                        biome(TitaniumBiomes.WILDWOOD_WASTES),
                        sequence(
                                condition(STONE_DEPTH_FLOOR,
                                        block(TitaniumBlocks.SOD.getDefaultState())),
                                block(TitaniumBlocks.CLART.getDefaultState())
                        )
                )
        );
        //@formatter:on
    }
}
