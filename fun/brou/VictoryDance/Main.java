package fun.brou.VictoryDance;

import fun.brou.VictoryDance.Command.SWVDGUI;
import fun.brou.VictoryDance.Dance.*;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Main plugin;

    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents((Listener)new SWVDGUI(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new DragonRider(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Yeehaw(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Dab(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Guardians(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new TwerkApocalypse(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new AnvilRain(), (Plugin)this);
        if ((getServer().getPluginManager().getPlugin("Citizens") == null) || (!getServer().getPluginManager().getPlugin("Citizens").isEnabled()))
        {
            Bukkit.getConsoleSender().sendMessage("");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Citizens 2.0 not found");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "SWVictoryDance has been unloaded");
            Bukkit.getConsoleSender().sendMessage("");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }else {
            Bukkit.getConsoleSender().sendMessage( "");
            Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "§6§m----------------------------------------");
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "SWVictortDance has been enabled! " + ChatColor.DARK_GRAY + "(" + ChatColor.GREEN + "Ver: " + getDescription().getVersion() + ChatColor.DARK_GRAY + ")");
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "author: Brou4747 " + ChatColor.DARK_GRAY + "(" + ChatColor.GREEN + "namem" + ChatColor.DARK_GRAY + ")");
            Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "§6§m----------------------------------------");
            Bukkit.getConsoleSender().sendMessage( "");
        }
        getCommand("swvd").setExecutor(new SWVDGUI());
        saveDefaultConfig();
        FileConfiguration config = getConfig();

    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "SWVictoryDance has been unloaded");
    }
}