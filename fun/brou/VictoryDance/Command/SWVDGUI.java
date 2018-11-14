package fun.brou.VictoryDance.Command;

import fun.brou.VictoryDance.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.File;
import java.util.ArrayList;

public class SWVDGUI  implements CommandExecutor, Listener {

    File file = new File(Main.plugin.getDataFolder() + "/settings.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if ((sender instanceof Player)) {
            if (args.length == 0) {
                p.sendMessage("§7§m----------------------------------------------");
                p.sendMessage("");
                p.sendMessage("§6§lSWVictoryDance §fby §6§lBrou (namem)");
                p.sendMessage("");
                p.sendMessage("§6/swvd gui §7§m-- §f Open Victory Dance GUI");
                p.sendMessage("§6/swvd reload §7§m-- §f Reload Config file");
                p.sendMessage("");
                p.sendMessage("§7§m----------------------------------------------");
                return true;
                //if (cmd.getName().equalsIgnoreCase("swvd")) {
            }
            if (args[0].equalsIgnoreCase("gui")) {

                Inventory gui = Bukkit.createInventory(null, 54, "§8Victory Dances");

                ItemStack dra = new ItemStack(Material.DRAGON_EGG);
                ItemMeta metaref1 = dra.getItemMeta();

                ItemStack guardian = new ItemStack(Material.PRISMARINE);
                ItemMeta g2 = guardian.getItemMeta();

                ItemStack dabskull = new ItemStack(Material.SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
                SkullMeta metadab = (SkullMeta) dabskull.getItemMeta();
                metadab.setOwner("AnonymousKiller");

                ItemStack yeehaw = new ItemStack(Material.SADDLE);
                ItemMeta y2 = yeehaw.getItemMeta();

                ItemStack apo = new ItemStack(Material.LEATHER_BOOTS, 1);
                LeatherArmorMeta l2 = (LeatherArmorMeta)apo.getItemMeta();
                l2.setColor(Color.fromRGB(255, 0,84));
                apo.setItemMeta(l2);

                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§7Ride a Dragon capable of");
                lore.add("§7destroying the map.");
                lore.add(" ");
                lore.add("§7Rarity: §6LEGENDARY");

                if (p.hasPermission("vd.dragonrider")) {
                    lore.add("§7Unlocked: §aRanked reward");
                    lore.add("");
                    lore.add("§eClick to select");
                }
                if (!p.hasPermission("vd.dragonrider")) {
                    lore.add("");
                    lore.add("§cGiven as a ranked reward");
                }

                ArrayList<String> lore2 = new ArrayList<String>();
                lore2.add("§7Perform a Guardian");
                lore2.add("§7summoning ritual.");
                lore2.add(" ");
                lore2.add("§7Rarity: §5EPIC");
                if (p.hasPermission("vd.guardians")) {
                    lore2.add("§7Unlocked: §aRanked reward");
                    lore2.add("");
                    lore2.add("§eClick to select");
                    //lore2.add("§cCurrently Disabled!");
                }
                if (!p.hasPermission("vd.guardians")) {
                    lore2.add("");
                    lore2.add("§cGiven as a ranked reward");
                    //lore2.add("§cCurrently Disabled!");
                }

                ArrayList<String> lore3 = new ArrayList<String>();
                lore3.add("§7Dab to the haters.");
                lore3.add(" ");
                lore3.add("§7Rarity: §6LEGENDARY");
                if (p.hasPermission("vd.dab")) {
                    lore3.add("");
                    lore3.add("§eClick to select");
                }
                if (!p.hasPermission("vd.dab")) {
                    lore3.add("");
                }

                ArrayList<String> lore4 = new ArrayList<String>();
                lore4.add("§7Ride a horse like it's");
                lore4.add("§71876.");
                lore4.add(" ");
                lore4.add("§7Rarity: §aCOMMON");
                if (p.hasPermission("vd.yeehaw")) {
                    lore4.add("");
                    lore4.add("§eClick to select");
                }
                if (!p.hasPermission("vd.yeehaw")) {
                    lore4.add("");
                }

                ArrayList<String> lore5 = new ArrayList<String>();
                lore5.add("§7Spawn tons more of yourself");
                lore5.add("§7and have them twerk.");
                lore5.add(" ");
                lore5.add("§7Rarity: §6LEGENDARY");
                if (p.hasPermission("vd.twerkapocalypse")) {
                    lore5.add("");
                    lore5.add("§eClick to select");
                }
                if (!p.hasPermission("vd.twerkapocalypse")) {
                    lore5.add("");
                }

                metaref1.setLore(lore);
                if (p.hasPermission("vd.dragonrider")) {
                    metaref1.setDisplayName(ChatColor.GREEN + "Dragon Rider");
                }if (!p.hasPermission("vd.dragonrider")) {
                    metaref1.setDisplayName(ChatColor.RED + "Dragon Rider");
                }

                g2.setLore(lore2);
                if (p.hasPermission("vd.guardians")) {
                    g2.setDisplayName(ChatColor.GREEN + "Guardians");
                }if (!p.hasPermission("vd.guardians")) {
                    g2.setDisplayName(ChatColor.RED + "Guardians");
                }

                metadab.setLore(lore3);
                if (p.hasPermission("vd.dab")) {
                    metadab.setDisplayName(ChatColor.GREEN + "Dab");
                }if (!p.hasPermission("vd.dab")) {
                    metadab.setDisplayName(ChatColor.RED + "Dab");
                }
                y2.setLore(lore4);
                if (p.hasPermission("vd.yeehaw")) {
                    y2.setDisplayName(ChatColor.GREEN + "Yeehaw");
                }if (!p.hasPermission("vd.yeehaw")) {
                    y2.setDisplayName(ChatColor.RED + "Yeehaw");
                }

                l2.setLore(lore5);
                if (p.hasPermission("vd.twerkapocalypse")) {
                    l2.setDisplayName(ChatColor.GREEN + "Twerk Apocalypse");
                }if (!p.hasPermission("vd.twerkapocalypse")) {
                    l2.setDisplayName(ChatColor.RED + "Twerk Apocalypse");
                }

                dra.setItemMeta(metaref1);
                guardian.setItemMeta(g2);
                dabskull.setItemMeta(metadab);
                yeehaw.setItemMeta(y2);
                apo.setItemMeta(l2);
                gui.setItem(24, dra);
                gui.setItem(23, apo);
                gui.setItem(22, dabskull);
                gui.setItem(21, guardian);
                gui.setItem(20, yeehaw);

                p.openInventory(gui);
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                Main.plugin.saveConfig();
                Main.plugin.reloadConfig();
                config.saveToString();
                
                p.sendMessage("§aconfig.yml reloaded!");
            }
        }
        return false;
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equalsIgnoreCase("§8Victory Dances")) {
            if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) {
                return;

            }
            if (e.getSlot() == 24 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Dragon Rider"))) {
                if (p.hasPermission("vd.dragonrider")) {
                    e.setCancelled(true);
                    p.sendMessage("§6You selected §aDragon Rider§6!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 2f);
                    Main.plugin.getConfig().set(p.getUniqueId().toString() + ".DANCE", "DRAGON_RIDER");
                    Main.plugin.saveConfig();
                }
            }
            if(e.getSlot() == 24 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Dragon Rider"))) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0.5f);
                p.sendMessage(ChatColor.RED + "You dont have the Dragon Rider Victory Dance!");

            }

            if (e.getSlot() == 23 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Twerk Apocalypse"))) {
                if (p.hasPermission("vd.twerkapocalypse")) {
                    e.setCancelled(true);
                    p.sendMessage("§6You selected §aTwerk Apocalypse§6!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 2f);
                    Main.plugin.getConfig().set(p.getUniqueId().toString() + ".DANCE", "TWERK_APOCALYPSE");
                    Main.plugin.saveConfig();
                }
            }
            if(e.getSlot() == 23 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Twerk Apocalypse"))) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0.5f);
                p.sendMessage(ChatColor.RED + "You dont have the Twerk Apocalypse Victory Dance!");

            }

            if (e.getSlot() == 22 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Dab"))) {
                if (p.hasPermission("vd.dab")) {
                    e.setCancelled(true);
                    p.sendMessage("§6You selected §aDab§6!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 2f);
                    Main.plugin.getConfig().set(p.getUniqueId().toString() + ".DANCE", "DAB");
                    Main.plugin.saveConfig();
                }
            }
            if (e.getSlot() == 22 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Dab"))) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0.5f);
                p.sendMessage(ChatColor.RED + "You dont have the Dab Victory Dance!");
            }
            if (e.getSlot() == 21 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Guardians"))) {
                if (p.hasPermission("vd.guardians")) {
                    e.setCancelled(true);
                    p.sendMessage(ChatColor.RED + "Currently Disabled!");
                    p.sendMessage("§6You selected §aGuardians§6!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 2f);
                    Main.plugin.getConfig().set(p.getUniqueId().toString() + ".DANCE", "GUARDIANS");
                    Main.plugin.saveConfig();
                }
            }if (e.getSlot() == 21 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Guardians"))) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0.5f);
                p.sendMessage(ChatColor.RED + "You dont have the Guardians Victory Dance!");
            }

            if (e.getSlot() == 20 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Yeehaw"))) {
                if (p.hasPermission("vd.yeehaw")) {
                    e.setCancelled(true);
                    p.sendMessage("§6You selected §aYeehaw§6!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 2f);
                    Main.plugin.getConfig().set(p.getUniqueId().toString() + ".DANCE", "YEEHAW");
                    Main.plugin.saveConfig();
                }
            }if (e.getSlot() == 20 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Yeehaw"))) {
                e.setCancelled(true);
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0.5f);
                p.sendMessage(ChatColor.RED + "You dont have the Yeehaw Victory Dance!");
            }
        }
    }
}