package me.codecraft.eatmobmod;

import me.codecraft.eatmobmod.effect.Effects;
import me.codecraft.eatmobmod.items.Items;
import net.fabricmc.api.ModInitializer;

public class EatMobMod implements ModInitializer {

    public static final String MOD_ID = "eatmobmod";
    @Override
    public void onInitialize() {
        Items.init();
        Effects.init();
    }
}
