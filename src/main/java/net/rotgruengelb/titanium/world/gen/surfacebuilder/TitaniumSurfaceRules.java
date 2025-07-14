package net.rotgruengelb.titanium.world.gen.surfacebuilder;

import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.rotgruengelb.titanium.Titanium;
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
                                // SOD: 1 block on surface
                                condition(STONE_DEPTH_FLOOR,
                                        block(TitaniumBlocks.SOD.getDefaultState())
                                ),

                                // CLART ~7 block layer below surface
                                condition(
                                        stoneDepth(5, false, 5, VerticalSurfaceType.FLOOR),
                                        block(TitaniumBlocks.CLART.getDefaultState())
                                ),

                                // VEINY_CLART: ~1 block as a transition layer
                                condition(
                                        stoneDepth(8, false, 0, VerticalSurfaceType.FLOOR),
                                        block(TitaniumBlocks.VEINY_CLART.getDefaultState())
                                ),

                                // TENDON: ~1–2 blocks as a transition layer
                                condition(
                                        stoneDepth(10, false, 0, VerticalSurfaceType.FLOOR),
                                        block(TitaniumBlocks.TENDON.getDefaultState())
                                ),

                                // BRAWN: everything deeper
                                block(TitaniumBlocks.BRAWN.getDefaultState())
                        )
                )
        );
        //@formatter:on
    }
}
