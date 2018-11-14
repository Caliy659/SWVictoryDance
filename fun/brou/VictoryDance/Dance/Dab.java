package fun.brou.VictoryDance.Dance;

import java.io.*;
import fun.brou.VictoryDance.*;
import org.bukkit.configuration.file.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.*;
import fun.brou.VictoryDance.API.*;
import fun.brou.VictoryDance.Animation.*;
import org.bukkit.plugin.*;
import org.bukkit.scheduler.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;

public class Dab implements Listener
{
    int alive;
    File file;
    FileConfiguration config;

    public Dab() {
        this.alive = 0;
        this.file = new File(Main.plugin.getDataFolder() + "/settings.yml");
        this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
    }

    public double random(final double min, final double max) {
        return Math.random() * (max - min) + min;
    }

    @EventHandler
    public void KillEvent(final EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player damaged = (Player) event.getEntity();
            if (event.getDamager() instanceof Player) {
                Player killer = (Player) event.getDamager();
                if (killer == null) {
                    return;
                }
                final World w = killer.getWorld();
                final Location l = killer.getLocation();
                final ItemStack hand = killer.getItemInHand();
                final ItemStack chestplate = killer.getInventory().getChestplate();
                final ItemStack chestplateNULL = new ItemStack(Material.LEATHER_CHESTPLATE);
                final ItemStack leggings = killer.getInventory().getLeggings();
                final ItemStack leggingsNULL = new ItemStack(Material.LEATHER_LEGGINGS);
                final ItemStack boot = killer.getInventory().getBoots();
                final ItemStack bootNULL = new ItemStack(Material.LEATHER_BOOTS);
                final ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                skullMeta.setOwner(killer.getName());
                skull.setItemMeta((ItemMeta) skullMeta);
                if ((damaged.getHealth() - event.getDamage()) <= 0) {
                    if (Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("DAB") && killer.getGameMode().equals((Object) GameMode.SURVIVAL)) {
                        if (this.config.getString("VictoryDance.DanceType").equalsIgnoreCase("1")) {
                            this.alive = 0;
                            for (final Player p : w.getPlayers()) {
                                if (p.getGameMode() == GameMode.SURVIVAL) {
                                    ++this.alive;
                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                        @Override
                                        public void run() {
                                            if (Dab.this.alive == 2) {
                                                Dab.this.alive = 0;
                                                final Title vip1 = new Title(ChatColor.GREEN.toString() + "<o/", ChatColor.GREEN.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                vip1.setTitleColor(ChatColor.GREEN);
                                                vip1.setSubtitleColor(ChatColor.GOLD);
                                                final Title vip2 = new Title(ChatColor.GREEN.toString() + "\\o>", ChatColor.GREEN.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                vip2.setTitleColor(ChatColor.GREEN);
                                                vip2.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvp1 = new Title(ChatColor.AQUA.toString() + "<o/", ChatColor.AQUA.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvp1.setTitleColor(ChatColor.AQUA);
                                                mvp1.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvp2 = new Title(ChatColor.AQUA.toString() + "\\o>", ChatColor.AQUA.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvp2.setTitleColor(ChatColor.AQUA);
                                                mvp2.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvpplusplus1 = new Title(ChatColor.GOLD.toString() + "<o/", ChatColor.GOLD.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvpplusplus1.setTitleColor(ChatColor.GOLD);
                                                mvpplusplus1.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvpplusplus2 = new Title(ChatColor.GOLD.toString() + "\\o>", ChatColor.GOLD.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvpplusplus2.setTitleColor(ChatColor.GOLD);
                                                mvpplusplus2.setSubtitleColor(ChatColor.GOLD);
                                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        for (int limit = 0; limit < 75; ++limit) {
                                                            final float yaw = (float) Dab.this.random(360.0, 1.0);
                                                            final Location randomtp = new Location(killer.getWorld(), l.getX() + Dab.this.random(40.0, -40.0), 120.0, l.getZ() + Dab.this.random(40.0, -40.0), yaw, 0.0f);
                                                            final int y = w.getHighestBlockYAt(randomtp);
                                                            randomtp.setY((double) y);
                                                            final ArmorStand as = (ArmorStand) killer.getWorld().spawn(randomtp, (Class) ArmorStand.class);
                                                            final Location asl = as.getLocation();
                                                            asl.setYaw(yaw);
                                                            as.teleport(asl);
                                                            as.setGravity(false);
                                                            as.setArms(true);
                                                            as.setItemInHand(hand);
                                                            as.setHelmet(skull);
                                                            if (killer.getInventory().getChestplate() == null) {
                                                                as.setChestplate(chestplateNULL);
                                                            } else {
                                                                as.setChestplate(chestplate);
                                                            }
                                                            if (killer.getInventory().getLeggings() == null) {
                                                                as.setLeggings(leggingsNULL);
                                                            } else {
                                                                as.setLeggings(leggings);
                                                            }
                                                            if (killer.getInventory().getBoots() == null) {
                                                                as.setBoots(bootNULL);
                                                            } else {
                                                                as.setBoots(boot);
                                                            }
                                                            new ArmorStandAnimator(new File(Main.plugin.getDataFolder(), "dab_animetion.txt"), as);
                                                            ArmorStandAnimator.clearCache();
                                                            ArmorStandAnimator.updateAll();
                                                            if (killer.hasPermission("vd.hasVIP_VIP+")) {
                                                                vip1.broadcast();
                                                                final int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        vip1.broadcast();
                                                                    }
                                                                }, 40L, 40L);
                                                                final int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        vip2.broadcast();
                                                                    }
                                                                }, 20L, 40L);
                                                                final int secondsss = 10;
                                                                Bukkit.getScheduler().runTaskLater((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        as.remove();
                                                                        Bukkit.getScheduler().cancelTask(dab1);
                                                                        Bukkit.getScheduler().cancelTask(dab2);
                                                                    }
                                                                }, secondsss * 20L);
                                                            } else if (killer.hasPermission("vd.hasMVP_MVP+")) {
                                                                mvp1.broadcast();
                                                                final int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvp1.broadcast();
                                                                    }
                                                                }, 40L, 40L);
                                                                final int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvp2.broadcast();
                                                                    }
                                                                }, 20L, 40L);
                                                                final int secondsss = 10;
                                                                Bukkit.getScheduler().runTaskLater((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        as.remove();
                                                                        Bukkit.getScheduler().cancelTask(dab1);
                                                                        Bukkit.getScheduler().cancelTask(dab2);
                                                                    }
                                                                }, secondsss * 20L);
                                                            } else if (killer.hasPermission("vd.hasMVP++")) {
                                                                mvpplusplus1.broadcast();
                                                                final int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvpplusplus1.broadcast();
                                                                    }
                                                                }, 40L, 40L);
                                                                final int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvpplusplus2.broadcast();
                                                                    }
                                                                }, 20L, 40L);
                                                                final int secondsss = 10;
                                                                Bukkit.getScheduler().runTaskLater((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        as.remove();
                                                                        Bukkit.getScheduler().cancelTask(dab1);
                                                                        Bukkit.getScheduler().cancelTask(dab2);
                                                                    }
                                                                }, secondsss * 20L);
                                                            }
                                                        }
                                                    }
                                                }, 10L);
                                                final int d = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ArmorStandAnimator.updateAll();
                                                    }
                                                }, 10L, 1L);
                                                new BukkitRunnable() {
                                                    public void run() {
                                                        Bukkit.getScheduler().cancelTask(d);
                                                    }
                                                }.runTaskLater((Plugin) Main.plugin, 220L);
                                            }
                                        }
                                    }, 1L);
                                }
                            }
                        } else if (this.config.getString("VictoryDance.DanceType").equalsIgnoreCase("2")) {
                            this.alive = 0;
                            for (final Player p : w.getPlayers()) {
                                if (p.getGameMode() == GameMode.SURVIVAL) {
                                    ++this.alive;
                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                        @Override
                                        public void run() {
                                            if (Dab.this.alive == 1) {
                                                Dab.this.alive = 0;
                                                final Title vip1 = new Title(ChatColor.GREEN.toString() + "<o/", ChatColor.GREEN.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                vip1.setTitleColor(ChatColor.GREEN);
                                                vip1.setSubtitleColor(ChatColor.GOLD);
                                                final Title vip2 = new Title(ChatColor.GREEN.toString() + "\\o>", ChatColor.GREEN.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                vip2.setTitleColor(ChatColor.GREEN);
                                                vip2.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvp1 = new Title(ChatColor.AQUA.toString() + "<o/", ChatColor.AQUA.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvp1.setTitleColor(ChatColor.AQUA);
                                                mvp1.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvp2 = new Title(ChatColor.AQUA.toString() + "\\o>", ChatColor.AQUA.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvp2.setTitleColor(ChatColor.AQUA);
                                                mvp2.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvpplusplus1 = new Title(ChatColor.GOLD.toString() + "<o/", ChatColor.GOLD.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvpplusplus1.setTitleColor(ChatColor.GOLD);
                                                mvpplusplus1.setSubtitleColor(ChatColor.GOLD);
                                                final Title mvpplusplus2 = new Title(ChatColor.GOLD.toString() + "\\o>", ChatColor.GOLD.toString() + killer.getDisplayName() + " §6Dabs!", 0, 1, 1);
                                                mvpplusplus2.setTitleColor(ChatColor.GOLD);
                                                mvpplusplus2.setSubtitleColor(ChatColor.GOLD);
                                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        for (int limit = 0; limit < 75; ++limit) {
                                                            final float yaw = (float) Dab.this.random(360.0, 1.0);
                                                            final Location randomtp = new Location(killer.getWorld(), l.getX() + Dab.this.random(40.0, -40.0), 120.0, l.getZ() + Dab.this.random(40.0, -40.0), yaw, 0.0f);
                                                            final int y = w.getHighestBlockYAt(randomtp);
                                                            randomtp.setY((double) y);
                                                            final ArmorStand as = (ArmorStand) killer.getWorld().spawn(randomtp, (Class) ArmorStand.class);
                                                            final Location asl = as.getLocation();
                                                            asl.setYaw(yaw);
                                                            as.teleport(asl);
                                                            as.setGravity(false);
                                                            as.setArms(true);
                                                            as.setItemInHand(hand);
                                                            as.setHelmet(skull);
                                                            if (killer.getInventory().getChestplate() == null) {
                                                                as.setChestplate(chestplateNULL);
                                                            } else {
                                                                as.setChestplate(chestplate);
                                                            }
                                                            if (killer.getInventory().getLeggings() == null) {
                                                                as.setLeggings(leggingsNULL);
                                                            } else {
                                                                as.setLeggings(leggings);
                                                            }
                                                            if (killer.getInventory().getBoots() == null) {
                                                                as.setBoots(bootNULL);
                                                            } else {
                                                                as.setBoots(boot);
                                                            }
                                                            new ArmorStandAnimator(new File(Main.plugin.getDataFolder(), "dab_animetion.txt"), as);
                                                            ArmorStandAnimator.clearCache();
                                                            ArmorStandAnimator.updateAll();
                                                            if (killer.hasPermission("vd.hasVIP_VIP+")) {
                                                                vip1.broadcast();
                                                                final int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        vip1.broadcast();
                                                                    }
                                                                }, 40L, 40L);
                                                                final int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        vip2.broadcast();
                                                                    }
                                                                }, 20L, 40L);
                                                                final int secondsss = 10;
                                                                Bukkit.getScheduler().runTaskLater((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        as.remove();
                                                                        Bukkit.getScheduler().cancelTask(dab1);
                                                                        Bukkit.getScheduler().cancelTask(dab2);
                                                                    }
                                                                }, secondsss * 20L);
                                                            } else if (killer.hasPermission("vd.hasMVP_MVP+")) {
                                                                mvp1.broadcast();
                                                                final int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvp1.broadcast();
                                                                    }
                                                                }, 40L, 40L);
                                                                final int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvp2.broadcast();
                                                                    }
                                                                }, 20L, 40L);
                                                                final int secondsss = 10;
                                                                Bukkit.getScheduler().runTaskLater((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        as.remove();
                                                                        Bukkit.getScheduler().cancelTask(dab1);
                                                                        Bukkit.getScheduler().cancelTask(dab2);
                                                                    }
                                                                }, secondsss * 20L);
                                                            } else if (killer.hasPermission("vd.hasMVP++")) {
                                                                mvpplusplus1.broadcast();
                                                                final int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvpplusplus1.broadcast();
                                                                    }
                                                                }, 40L, 40L);
                                                                final int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        mvpplusplus2.broadcast();
                                                                    }
                                                                }, 20L, 40L);
                                                                final int secondsss = 10;
                                                                Bukkit.getScheduler().runTaskLater((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        as.remove();
                                                                        Bukkit.getScheduler().cancelTask(dab1);
                                                                        Bukkit.getScheduler().cancelTask(dab2);
                                                                    }
                                                                }, secondsss * 20L);
                                                            }
                                                        }
                                                    }
                                                }, 10L);
                                                final int d = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, (Runnable) new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ArmorStandAnimator.updateAll();
                                                    }
                                                }, 10L, 1L);
                                                new BukkitRunnable() {
                                                    public void run() {
                                                        Bukkit.getScheduler().cancelTask(d);
                                                    }
                                                }.runTaskLater((Plugin) Main.plugin, 220L);
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
    public void ArmorStandDestroy(final EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }
        final LivingEntity livingEntity = (LivingEntity)event.getEntity();
        if (!livingEntity.getType().equals((Object)EntityType.ARMOR_STAND)) {
            return;
        }
        if (event.getDamager() instanceof Player) {
            final Player p = (Player)event.getDamager();
            event.setCancelled(true);
            return;
        }
        if (!(event.getDamager() instanceof Projectile)) {
            return;
        }
        final Projectile pro = (Projectile)event.getDamager();
        if (pro.getShooter() instanceof Player) {
            final Player p2 = (Player)pro.getShooter();
            event.setCancelled(true);
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void ArmorStandPreventPickUpArmor(final PlayerInteractAtEntityEvent event) {
        final Entity entity = event.getRightClicked();
        final Player player = event.getPlayer();
        if (entity instanceof ArmorStand) {
            event.setCancelled(true);
        }
    }
}
