package com.qjl.myplugin.mylisteners;

import com.qjl.myplugin.utils.MyBow;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class BowListener implements org.bukkit.event.Listener {

    private Entity arrow = null;

    @EventHandler
    public void onQJLBowShoot(EntityShootBowEvent e){
        ItemStack bow = e.getBow();
        Bukkit.getLogger().info("arrow start");
        if (bow.equals( MyBow.getBow() )){
            arrow = e.getProjectile();
            Bukkit.getLogger().info("arrow stored");

        }else{
            arrow = null;
        }

    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e){
        if (arrow != null){
            Block b = e.getHitBlock();
            Entity en = e.getHitEntity();
            if (b != null){
                //summon lighnting
                b.getWorld().strikeLightning(b.getLocation());
                arrow.remove();
                arrow = null;
            } else if (en != null) {
                //summon
                en.getWorld().strikeLightning(en.getLocation());
                arrow.remove();
                arrow = null;

            }
        }else{}
    }


}
