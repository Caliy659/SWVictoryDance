package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class Yeehaw implements Listener {

    int alive = 0;
    File file = new File(Main.plugin.getDataFolder() + "/settings.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        Entity kesuyatu = player.getVehicle();

        if (kesuyatu instanceof Horse) {
            kesuyatu.remove();
        }

    }

    @EventHandler
    public void KillEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damaged = (Player) event.getEntity();
            if (event.getDamager() instanceof Player) {
                Player killer = (Player) event.getDamager();
                if (killer == null) {
                    return;
                }
                World w = killer.getWorld();
                if (Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("YEEHAW")) {
                    if ((damaged.getHealth() - event.getDamage()) <= 0) {
                        if (killer.getGameMode().equals(GameMode.SURVIVAL)) {
                        }
                        if (config.getString("VictoryDance.DanceType").equalsIgnoreCase("1")) {
                            alive = 0;
                            for (Player p : w.getPlayers()) {
                                if (p.getGameMode() == GameMode.SURVIVAL) {
                                    alive++;
                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                        @Override
                                        public void run() {
                                            if (alive == 2) {
                                                alive = 0;
                                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                                                    @Override
                                                    public void run() {
                                                        Horse horse = (Horse) killer.getWorld().spawn(killer.getLocation(), Horse.class);
                                                        horse.setPassenger(killer);
                                                        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE, 1));
                                                        Entity enti = killer.getVehicle();
                                                    }
                                                }, 9L);

                                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                                                    @Override
                                                    public void run() {
                                                        Entity enti = killer.getVehicle();
                                                        if (enti == null) {
                                                            return;
                                                        }
                                                        enti.remove();
                                                    }
                                                }, 219L);
                                            }
                                        }
                                    }, 1L);
                                }
                            }
                        } else if (config.getString("VictoryDance.DanceType").equalsIgnoreCase("2")) {
                            alive = 0;
                            for (Player p : w.getPlayers()) {
                                if (p.getGameMode() == GameMode.SURVIVAL) {
                                    alive++;
                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                        @Override
                                        public void run() {
                                            if (alive == 1) {
                                                alive = 0;
                                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                                                    @Override
                                                    public void run() {
                                                        Horse horse = (Horse) killer.getWorld().spawn(killer.getLocation(), Horse.class);
                                                        horse.setPassenger(killer);
                                                        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE, 1));
                                                        Entity enti = killer.getVehicle();
                                                    }
                                                }, 9L);

                                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                                                    @Override
                                                    public void run() {
                                                        Entity enti = killer.getVehicle();
                                                        if (enti == null) {
                                                            return;
                                                        }
                                                        enti.remove();
                                                    }
                                                }, 219L);
                                            }
                                        }
                                    }, 1L);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void CancelVehicleExit(VehicleExitEvent event) {
        Player player = (Player) event.getExited();
        Entity enti = player.getVehicle();
        if (enti instanceof Horse) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void PlayerTeleportEvent(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        Entity enti = player.getVehicle();

        if(event.getCause() == PlayerTeleportEvent.TeleportCause.PLUGIN) {
            if (enti instanceof Horse) {
                enti.remove();
            }
        }
        else if(event.getCause() == PlayerTeleportEvent.TeleportCause.COMMAND) {
            if (enti instanceof Horse) {
                enti.remove();
            }
        }
    }
}
