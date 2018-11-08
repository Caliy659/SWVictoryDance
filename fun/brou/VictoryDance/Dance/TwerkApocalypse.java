package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class TwerkApocalypse implements Listener {

        public double random(final double min, final double max) {
            return Math.random() * (max - min) + min;
        }

        @EventHandler
        public void KillEvent(PlayerDeathEvent event) {

            Player killer = event.getEntity().getKiller();
            if (killer == null) {
                return;
            }
            World w = killer.getWorld();
            Location l = killer.getLocation();

            if (event.getEntity().getKiller() instanceof Player) {
                if (Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("TWERK_APOCALYPSE")) {
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                        @Override
                        public void run() {
                            for (int limit = 0; limit < 55; ++limit) {
                                NPCRegistry registry = CitizensAPI.getNPCRegistry();
                                NPC npc = registry.createNPC(EntityType.PLAYER, ChatColor.GREEN.toString() + "" + killer.getName());
                                float yaw = (float) random(360, 0);
                                Location randomtp = new Location(killer.getWorld(), l.getX() + random(40, -40), 120, l.getZ() + random(40, -40));
                                int y = w.getHighestBlockYAt(randomtp);
                                randomtp.setY((double) (y));
                                npc.spawn(randomtp);
                                Player p = (Player) npc.getEntity();
                                Location npcloc = p.getLocation();
                                npcloc.setYaw(yaw);
                                p.teleport(npcloc);

                                //fix head direction
                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        npc.setName(ChatColor.GREEN.toString() + "" + killer.getName());
                                        npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, killer.getName());
                                    }
                                }, 1L);

                                int sneak = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {
                                        Player p2 = (Player) npc.getEntity();
                                        p2.setSneaking(true);

                                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                            @Override
                                            public void run() {
                                                p2.setSneaking(false);
                                            }
                                        }, 7L);
                                    }
                                }, 5, 17);

                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        npc.destroy();
                                        Bukkit.getScheduler().cancelTask(sneak);
                                    }
                                }, 200L);
                            }

                            for (int limit = 0; limit < 55; ++limit) {
                                NPCRegistry registry = CitizensAPI.getNPCRegistry();
                                NPC npc = registry.createNPC(EntityType.PLAYER, ChatColor.GREEN.toString() + "" + killer.getName());
                                float yaw = (float) random(360, 0);
                                Location randomtp = new Location(killer.getWorld(), l.getX() + random(40, -40), 120, l.getZ() + random(40, -40));
                                int y = w.getHighestBlockYAt(randomtp);
                                randomtp.setY((double) (y));
                                npc.spawn(randomtp);
                                Player p = (Player) npc.getEntity();
                                Location npcloc = p.getLocation();
                                npcloc.setYaw(yaw);
                                p.teleport(npcloc);

                                //fix head direction
                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        npc.setName(ChatColor.GREEN.toString() + "" + killer.getName());
                                        npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, killer.getName());
                                    }
                                }, 1L);

                                int sneak = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {
                                        Player p2 = (Player) npc.getEntity();
                                        p2.setSneaking(true);

                                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                            @Override
                                            public void run() {
                                                p2.setSneaking(false);
                                            }
                                        }, 7L);
                                    }
                                }, 10, 17);

                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        npc.destroy();
                                        Bukkit.getScheduler().cancelTask(sneak);
                                    }
                                }, 200L);
                            }
                        }
                    }, 10L);
                }
            }
        }
    }
