package com.qjl.myplugin.mycmdexecutors;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class myHalfExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("myhalf") && sender instanceof Player){
            Player p = (Player) sender;
                if(p.hasPermission("qjl.half")){
                    double amount = 0.5;
                    AttributeInstance attri = p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                    if( args.length == 0){
                        amount = -0.5F;
                    }else {
                        try {
                            amount = Double.parseDouble(args[0]);
                        } catch (Exception e){
                            return false;
                        };

                    }
                    attri.addModifier(new AttributeModifier(
                            "q", amount, AttributeModifier.Operation.ADD_SCALAR));
                    return true;

                }else{
                    p.sendMessage("permission denied");
                    return true;
                }
        }else {
            return false;
        }

    }
}
