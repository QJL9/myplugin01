package com.qjl.myplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MyBow {
    static ItemStack bow = null;
    public static ItemStack getBow() {
        if (bow == null){
            bow = new ItemStack(Material.BOW);
            ItemMeta bowData = bow.getItemMeta();
            bowData.setUnbreakable(true);
            bowData.setDisplayName(ChatColor.AQUA + "QJl's bow");
            bow.setItemMeta(bowData);
            return bow;

        }else{
            return bow;
        }

    }
}