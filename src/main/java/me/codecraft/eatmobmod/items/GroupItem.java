package me.codecraft.eatmobmod.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class GroupItem {
    public static final ItemGroup EATMOB = FabricItemGroupBuilder.build(new Identifier("eatmobmod", "eatmob"), () -> new ItemStack(Items.EDIBLE_COW));
}
