package me.driftay.savagealerts;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    ConsoleCommandSender Console = Bukkit.getConsoleSender();


    public void onEnable(){
        this.Console.sendMessage("§8§l§m====================================================");
        this.Console.sendMessage("                       §b§lSavage§cAlerts");
        this.Console.sendMessage(" ");
        this.Console.sendMessage("        §7§lStatus: §4§lEnabled");
        this.Console.sendMessage("        §7§lAuthor: §4§lDriftay");
        this.Console.sendMessage("        §7§lVersion: §4§l1.0");
        this.Console.sendMessage(" ");
        this.Console.sendMessage("§8§l§m====================================================");
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        this.getCommand("savagealerts").setExecutor(new SavageAlertsCMD(this));
        this.getServer().getPluginManager().registerEvents(new Events(this), this);

    }

    public void onDisable(){
        this.Console.sendMessage("§8§l§m====================================================");
        this.Console.sendMessage("                       §b§lSavage§cAlerts");
        this.Console.sendMessage(" ");
        this.Console.sendMessage("        §7§lStatus: §4§lDisabled");
        this.Console.sendMessage("        §7§lAuthor: §4§lDriftay");
        this.Console.sendMessage("        §7§lVersion: §4§l1.0");
        this.Console.sendMessage(" ");
        this.Console.sendMessage("§8§l§m====================================================");

    }

}
