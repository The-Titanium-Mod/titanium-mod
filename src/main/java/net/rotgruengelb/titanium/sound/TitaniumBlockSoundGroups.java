package net.rotgruengelb.titanium.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

import static net.rotgruengelb.titanium.sound.TitaniumSoundEvents.*;

public class TitaniumBlockSoundGroups {
    public static final BlockSoundGroup TENDON = blockSoundGroup(
            BLOCK_TENDON_BREAK,
            BLOCK_TENDON_STEP,
            BLOCK_TENDON_PLACE,
            BLOCK_TENDON_HIT,
            BLOCK_TENDON_FALL);

    private static BlockSoundGroup blockSoundGroup(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        return new BlockSoundGroup(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }

    private static BlockSoundGroup blockSoundGroup(SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        return new BlockSoundGroup(1.0F, 1.0F, breakSound, stepSound, placeSound, hitSound, fallSound);
    }
}

