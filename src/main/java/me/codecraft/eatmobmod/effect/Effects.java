package me.codecraft.eatmobmod.effect;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.eatmobmod.EatMobMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Effects {
    public static void init() {

        System.out.println("Effects initialized");
    }

    public static final StatusEffect LAVA_VISION = Registry.registerStatusEffects("lava_vision", EatMobMod.MOD_ID,
            new LavaVisionEffect(StatusEffectCategory.BENEFICIAL,0xe89056));
}
