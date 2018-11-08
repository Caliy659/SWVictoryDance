package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Logger;

public class Yeehaw implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        Entity kesuyatu = player.getVehicle();


        if (kesuyatu instanceof Horse) {
            kesuyatu.remove();
        }

    }

    @EventHandler
    public void KillEvent(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        if (killer == null) {
            return;
        }
        World w = killer.getWorld();

        if (event.getEntity().getKiller() instanceof Player) {
            if(Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("YEEHAW")) {

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                    @Override
                    public void run() {
                        Horse horse = (Horse) killer.getWorld().spawn(killer.getLocation(), Horse.class);
                        horse.setPassenger(killer);
                        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE, 1));
                        Entity enti = killer.getVehicle();
                    }
                }, 10L);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                    @Override
                    public void run() {
                        Entity enti = killer.getVehicle();
                        if (enti == null) {
                            return;
                        }
                        enti.remove();
                    }
                }, 220L);
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
}
