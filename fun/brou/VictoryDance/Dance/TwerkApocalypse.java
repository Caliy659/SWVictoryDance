package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;

public class TwerkApocalypse implements Listener {

    int alive = 0;
    File file = new File(Main.plugin.getDataFolder() + "/settings.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public double random(final double min, final double max) {
        return Math.random() * (max - min) + min;
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
                Location l = killer.getLocation();
                if ((damaged.getHealth() - event.getDamage()) <= 0) {
                    if (Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("TWERK_APOCALYPSE")) {
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
                                    }, 10L);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}