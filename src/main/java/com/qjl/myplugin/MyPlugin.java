package com.qjl.myplugin;

import com.qjl.myplugin.mycmdexecutors.MyBowExecutor;
import com.qjl.myplugin.mycmdexecutors.myHalfExecutor;
import com.qjl.myplugin.mycmdexecutors.myOpenExecutor;
import com.qjl.myplugin.mylisteners.BowListener;
import com.qjl.myplugin.mylisteners.MyListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
public final class MyPlugin extends JavaPlugin {
    static private JavaPlugin thisplugin;
    public static JavaPlugin getthis(){
        return thisplugin;

    }
    @Override
    public void onEnable() {
        thisplugin = this;

        this.getLogger().info("hello");

        Bukkit.getPluginManager().registerEvents(new MyListener(), this);
        Bukkit.getPluginManager().registerEvents(new BowListener(), this);

        PluginCommand cmd1 = this.getCommand("myhalf");
        PluginCommand cmd2 = this.getCommand("open");
        PluginCommand cmd3 = this.getCommand("bow");

        cmd1.setExecutor(new myHalfExecutor());
        cmd2.setExecutor(new myOpenExecutor());
        cmd3.setExecutor(new MyBowExecutor());

        NamespacedKey nsk = new NamespacedKey(this, "key1");
        FurnaceRecipe fr1 = new FurnaceRecipe(nsk, new ItemStack(Material.GRASS), Material.STONE, 1F, 40);
        Bukkit.addRecipe(fr1);
        //

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
