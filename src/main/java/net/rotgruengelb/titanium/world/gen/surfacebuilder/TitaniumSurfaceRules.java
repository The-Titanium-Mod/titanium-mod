package net.rotgruengelb.titanium.world.gen.surfacebuilder;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.rotgruengelb.titanium.block.TitaniumBlocks;
import net.rotgruengelb.titanium.world.biome.TitaniumBiomes;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class TitaniumSurfaceRules {

    public static SurfaceRules.RuleSource createTitaniumEndSurfaceRule() {
        //@formatter:off
        return sequence(
                ifTrue(
                        isBiome(TitaniumBiomes.WILDWOOD_FOREST),
                        createWildwoodSurfaceRuleSequence()
                ),
                ifTrue(
                        isBiome(TitaniumBiomes.WILDWOOD_WASTES),
                        createWildwoodSurfaceRuleSequence()
                )
        );
        //@formatter:on
    }

    private static SurfaceRules.RuleSource createWildwoodSurfaceRuleSequence() {
        return
                sequence(
                        // SOD: 1 block on surface
                        ifTrue(ON_FLOOR,
                                state(TitaniumBlocks.SOD.defaultBlockState())
                        ),

                        // CLART: ~7 block layer below surface
                        ifTrue(
                                stoneDepthCheck(5, false, 5, CaveSurface.FLOOR),
                                state(TitaniumBlocks.CLART.defaultBlockState())
                        ),

                        // VEINY_CLART: ~1 block as a transition layer
                        ifTrue(
                                stoneDepthCheck(8, false, 0, CaveSurface.FLOOR),
                                state(TitaniumBlocks.VEINY_CLART.defaultBlockState())
                        ),

                        // TENDON: ~1–2 blocks as a transition layer
                        ifTrue(
                                stoneDepthCheck(10, false, 0, CaveSurface.FLOOR),
                                state(TitaniumBlocks.TENDON.defaultBlockState())
                        ),

                        // BRAWN: everything deeper
                        state(TitaniumBlocks.BRAWN.defaultBlockState())
                );
    }
}
