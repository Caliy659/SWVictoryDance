package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.jaxonbrown.guardianBeam.beam.Beam;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class Guardians implements Listener {

    boolean dance = false;

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
                Location loc = killer.getLocation();
                if ((damaged.getHealth() - event.getDamage()) <= 0) {
                    if (Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("GUARDIANS")) {
                        NPCRegistry registry = CitizensAPI.getNPCRegistry();

                        NPC npc = registry.createNPC(EntityType.GUARDIAN, "");
                        npc.setFlyable(true);
                        npc.setProtected(true);
                        npc.faceLocation(killer.getLocation().add(0, 1.0, 0));

                        NPC npc2 = registry.createNPC(EntityType.GUARDIAN, "");
                        npc2.setFlyable(true);
                        npc2.setProtected(true);
                        npc2.faceLocation(killer.getLocation().add(0, 1.0, 0));

                        NPC npc3 = registry.createNPC(EntityType.GUARDIAN, "");
                        npc3.setFlyable(true);
                        npc3.setProtected(true);
                        npc3.faceLocation(killer.getLocation().add(0, 1.0, 0));
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                            int time = 200;
                            double y = 1.2;
                            int angle1 = 120;
                            int angle2 = 240;
                            int angle3 = 360;

                            int angle11 = 120;
                            int angle22 = 240;
                            int angle33 = 360;

                            @Override
                            public void run() {


                                Location loc1 = killer.getLocation();
                                Location loc2 = killer.getLocation();
                                Location loc3 = killer.getLocation();
                                Location locaa = killer.getLocation().add(0, 1.2, 0);
                                Location g1loc = npc.getStoredLocation();
                                Location g2loc = npc2.getStoredLocation();
                                Location g3loc = npc3.getStoredLocation();

                                double addxx1 = 2.3 * Math.sin(angle11 * (Math.PI / 180));
                                double addzz1 = 2.3 * Math.cos(angle11 * (Math.PI / 180));
                                double addxx2 = 2.3 * Math.sin(angle22 * (Math.PI / 180));
                                double addzz2 = 2.3 * Math.cos(angle22 * (Math.PI / 180));
                                double addxx3 = 2.3 * Math.sin(angle33 * (Math.PI / 180));
                                double addzz3 = 2.3 * Math.cos(angle33 * (Math.PI / 180));

                                npc.spawn(loc.clone().add(addxx1, y, addzz1));
                                npc2.spawn(loc.clone().add(addxx2, y, addzz2));
                                npc3.spawn(loc.clone().add(addxx3, y, addzz3));
                                npc.faceLocation(killer.getLocation().add(0, 1.0, 0));
                                npc2.faceLocation(killer.getLocation().add(0, 1.0, 0));
                                npc3.faceLocation(killer.getLocation().add(0, 1.0, 0));
                                Location gloc1 = npc.getStoredLocation();
                                Location gloc2 = npc2.getStoredLocation();
                                Location gloc3 = npc3.getStoredLocation();

                                dance = true;

                                Beam beam1 = new Beam(gloc1, killer.getLocation().add(0, 1, 0));
                                beam1.start();
                                Beam beam2 = new Beam(gloc2, killer.getLocation().add(0, 1, 0));
                                beam2.start();
                                Beam beam3 = new Beam(gloc3, killer.getLocation().add(0, 1, 0));
                                beam3.start();

                                int dancestart = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {
                                        double addx1 = 3.3 * Math.sin(angle1 * (Math.PI / 180));
                                        double addz1 = 2.3 * Math.cos(angle1 * (Math.PI / 180));
                                        double addx2 = 2.3 * Math.sin(angle2 * (Math.PI / 180));
                                        double addz2 = 2.3 * Math.cos(angle2 * (Math.PI / 180));
                                        double addx3 = 2.3 * Math.sin(angle3 * (Math.PI / 180));
                                        double addz3 = 2.3 * Math.cos(angle3 * (Math.PI / 180));
                                        Location gloc4 = npc3.getStoredLocation();
                                        Location gloc5 = npc2.getStoredLocation();
                                        Location gloc6 = npc.getStoredLocation();
                                        npc.teleport(killer.getLocation().clone().add(addx1, y, addz1), PlayerTeleportEvent.TeleportCause.PLUGIN);
                                        npc2.teleport(killer.getLocation().clone().add(addx2, y, addz2), PlayerTeleportEvent.TeleportCause.PLUGIN);
                                        npc3.teleport(killer.getLocation().clone().add(addx3, y, addz3), PlayerTeleportEvent.TeleportCause.PLUGIN);

                                        beam1.setStartingPosition(gloc5);
                                        beam1.setEndingPosition(killer.getLocation().add(0, 1, 0));

                                        beam2.setStartingPosition(gloc6);
                                        beam2.setEndingPosition(killer.getLocation().add(0, 1, 0));

                                        beam3.setStartingPosition(gloc4);
                                        beam3.setEndingPosition(killer.getLocation().add(0, 1, 0));

                                        npc.faceLocation(killer.getLocation().add(0, 1.0, 0));
                                        npc2.faceLocation(killer.getLocation().add(0, 1.0, 0));
                                        npc3.faceLocation(killer.getLocation().add(0, 1.0, 0));
                                        angle1 += 3;
                                        angle2 += 3;
                                        angle3 += 3;
                                    }
                                }, 0, 1);
                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                                    @Override
                                    public void run() {

                                        beam3.stop();
                                        beam2.stop();
                                        beam1.stop();
                                        npc.despawn();
                                        npc2.despawn();
                                        npc3.despawn();
                                        Bukkit.getScheduler().cancelTask(dancestart);
                                    }
                                }, 220L);
                            }
                        }, 10L);
                    }
                }
            }
        }
    }
}
