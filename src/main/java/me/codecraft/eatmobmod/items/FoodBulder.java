package me.codecraft.eatmobmod.items;

import net.minecraft.item.FoodComponent;

public class FoodBulder {
    public static FoodComponent EDIBLE = new FoodComponent.Builder().hunger(10).saturationModifier(0.9f).alwaysEdible().build();
}
