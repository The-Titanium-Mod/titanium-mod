package net.rotgruengelb.titanium.mixin;

import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ChunkGeneratorSettings.class)
public interface ChunkGeneratorSettingsAccessor {
    @Mutable
    @Accessor
    void setSurfaceRule(MaterialRules.MaterialRule materialRule);
}
