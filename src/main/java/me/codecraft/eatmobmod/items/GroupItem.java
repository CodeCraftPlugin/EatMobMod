package me.codecraft.eatmobmod.items;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.eatmobmod.EatMobMod;
import net.minecraft.item.ItemGroup;

public class GroupItem {
    public static final ItemGroup EATMOB = Registry.registerItemGroup("eatmob", EatMobMod.MOD_ID,Items.EDIBLE_COW);
}
