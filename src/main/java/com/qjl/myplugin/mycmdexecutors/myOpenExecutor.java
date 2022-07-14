package com.qjl.myplugin.mycmdexecutors;

import com.qjl.myplugin.MyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class myOpenExecutor implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("open") && sender instanceof Player) {
            Player p = (Player) sender;
            if (sender.hasPermission("qjl.open")) {

                Player p2 = Bukkit.getPlayer("qjl");
                Inventory i = p2.getInventory();


                myRunnable task = new myRunnable();
                task.sender = p;
                p.openInventory(i);
                task.runTaskLater(MyPlugin.getthis(), 20);
            }
        }
        return true;
    }
}
class myRunnable extends BukkitRunnable{
    public Player sender;
    @Override
    public void run() {
        sender.closeInventory();
    }
}
