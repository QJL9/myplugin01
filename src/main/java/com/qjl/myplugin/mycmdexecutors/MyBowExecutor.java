package com.qjl.myplugin.mycmdexecutors;

import com.qjl.myplugin.utils.MyBow;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MyBowExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("bow") && sender instanceof Player) {
            Player p = (Player) sender;
            if (sender.hasPermission("qjl.bow")) {
                ItemStack bow = MyBow.getBow();
                p.getWorld().dropItem(p.getLocation(), bow);
            }
        }

        return true;
    }
}
