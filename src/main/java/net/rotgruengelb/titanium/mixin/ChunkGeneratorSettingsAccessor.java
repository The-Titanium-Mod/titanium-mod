package net.rotgruengelb.titanium.mixin;

import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(NoiseGeneratorSettings.class)
@MixinEnvironment(type = MixinEnvironment.Env.MAIN)
public interface ChunkGeneratorSettingsAccessor {
    @Mutable
    @Accessor
    void setSurfaceRule(SurfaceRules.RuleSource materialRule);
}
