package me.driftay.savagealerts;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SavageAlertsCMD implements CommandExecutor {
    private Main main;

    public SavageAlertsCMD(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("savagealerts")) {
            if (sender.hasPermission(main.getConfig().getString("Permission-Node"))) {
                if (args.length == 1) {
                    String arg1 = args[0];
                    if (args[0].equalsIgnoreCase("reload")) {
                        main.reloadConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Reloaded-Message")));
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("No-Args")));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("No-Permission")));
            }
        }
        return false;
    }
}
