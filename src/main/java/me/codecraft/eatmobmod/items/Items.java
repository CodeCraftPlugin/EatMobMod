package me.codecraft.eatmobmod.items;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.eatmobmod.EatMobMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Items {
    public static final Item EDIBLE_COW = Registry.registerItems("edible_cow", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);
    public static final Item EDIBLE_PIG = Registry.registerItems("edible_pig", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);
    public static final Item EDIBLE_DRAGON = Registry.registerItems("edible_dragon", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);
    public static final Item EDIBLE_CREEPER = Registry.registerItems("edible_creeper", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);
    public static final Item EDIBLE_SPIDER = Registry.registerItems("edible_spider", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);
    public static final Item EDIBLE_CHICKEN = Registry.registerItems("edible_chicken", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);
    public static final Item EDIBLE_GOLEM = Registry.registerItems("edible_golem", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);
    public static final Item EDIBLE_BLAZE = Registry.registerItems("edible_blaze", EatMobMod.MOD_ID, new Item(new FabricItemSettings().food(FoodBulder.EDIBLE)),GroupItem.EATMOB);

    public static final Item INEDIBLE_PIG = Registry.registerItems("inedible_pig", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);
    public static final Item INEDIBLE_COW = Registry.registerItems("inedible_cow", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);
    public static final Item INEDIBLE_DRAGON = Registry.registerItems("inedible_dragon", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);
    public static final Item INEDIBLE_CREEPER = Registry.registerItems("inedible_creeper", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);
    public static final Item INEDIBLE_SPIDER = Registry.registerItems("inedible_spider", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);
    public static final Item INEDIBLE_CHICKEN = Registry.registerItems("inedible_chicken", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);
    public static final Item INEDIBLE_GOLEM = Registry.registerItems("inedible_golem", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);
    public static final Item INEDIBLE_BLAZE = Registry.registerItems("inedible_blaze", EatMobMod.MOD_ID, new Item(new FabricItemSettings()),GroupItem.EATMOB);

    public static void init() {

        System.out.println("loaded all the items");
    }
}
