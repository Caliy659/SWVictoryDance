package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.API.Title;
import fun.brou.VictoryDance.Animation.ArmorStandAnimator;
import fun.brou.VictoryDance.Main;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import java.io.File;

public class Dab implements Listener {


    public double random(final double min, final double max) {
        return Math.random() * (max - min) + min;
    }


    @SuppressWarnings("deprecation")
    @EventHandler
    public void KillEvent(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        if (killer == null) {
            return;
        }
        World w = killer.getWorld();
        Location l = killer.getLocation();
        ItemStack hand = killer.getItemInHand();
        ItemStack chestplate = killer.getInventory().getChestplate();
        ItemStack chestplateNULL = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = killer.getInventory().getLeggings();
        ItemStack leggingsNULL = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boot = killer.getInventory().getBoots();
        ItemStack bootNULL = new ItemStack(Material.LEATHER_BOOTS);

        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner(killer.getName());
        skull.setItemMeta(skullMeta);

        if (event.getEntity().getKiller() instanceof Player) {
            if(Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("DAB")) {

                Title vip1 = new Title(ChatColor.GREEN.toString() + "<o/", ChatColor.GREEN.toString() + killer.getDisplayName() + " §6Dabs!",0,1,1);
                vip1.setTitleColor(ChatColor.GREEN);
                vip1.setSubtitleColor(ChatColor.GOLD);

                Title vip2 = new Title(ChatColor.GREEN.toString() + "\\o>", ChatColor.GREEN.toString() + killer.getDisplayName() + " §6Dabs!",0,1,1);
                vip2.setTitleColor(ChatColor.GREEN);
                vip2.setSubtitleColor(ChatColor.GOLD);

                Title mvp1 = new Title(ChatColor.AQUA.toString() + "<o/", ChatColor.AQUA.toString() + killer.getDisplayName() + " §6Dabs!",0,1,1);
                mvp1.setTitleColor(ChatColor.AQUA);
                mvp1.setSubtitleColor(ChatColor.GOLD);

                Title mvp2 = new Title(ChatColor.AQUA.toString() + "\\o>", ChatColor.AQUA.toString() + killer.getDisplayName() + " §6Dabs!",0,1,1);
                mvp2.setTitleColor(ChatColor.AQUA);
                mvp2.setSubtitleColor(ChatColor.GOLD);

                Title mvpplusplus1 = new Title(ChatColor.GOLD.toString() + "<o/", ChatColor.GOLD.toString() + killer.getDisplayName() + " §6Dabs!",0,1,1);
                mvpplusplus1.setTitleColor(ChatColor.GOLD);
                mvpplusplus1.setSubtitleColor(ChatColor.GOLD);

                Title mvpplusplus2 = new Title(ChatColor.GOLD.toString() + "\\o>", ChatColor.GOLD.toString() + killer.getDisplayName() + " §6Dabs!",0,1,1);
                mvpplusplus2.setTitleColor(ChatColor.GOLD);
                mvpplusplus2.setSubtitleColor(ChatColor.GOLD);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                    @Override
                    public void run() {
                        for (int limit = 0; limit < 75; ++limit) {
                            float yaw = (float) random(360,1);

                            Location randomtp = new Location(killer.getWorld(), l.getX() + random(40,-40), 120, l.getZ() + random(40,-40), yaw,0);
                            int y = w.getHighestBlockYAt(randomtp);
                            randomtp.setY((double) (y));
                            ArmorStand as = killer.getWorld().spawn(randomtp, ArmorStand.class);
                            Location asl = as.getLocation();
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

                                int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {

                                        vip1.broadcast();

                                    }
                                }, 40, 40);

                                int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {

                                        vip2.broadcast();

                                    }
                                }, 20, 40);

                                int secondsss = 10;

                                Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                                    public void run() {
                                        as.remove();
                                        Bukkit.getScheduler().cancelTask(dab1);
                                        Bukkit.getScheduler().cancelTask(dab2);
                                    }
                                }, secondsss * 20L);
                            }

                            else if (killer.hasPermission("vd.hasMVP_MVP+")) {
                                mvp1.broadcast();

                                int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {

                                        mvp1.broadcast();

                                    }
                                }, 40, 40);

                                int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {

                                        mvp2.broadcast();

                                    }
                                }, 20, 40);

                                int secondsss = 10;

                                Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                                    public void run() {
                                        as.remove();
                                        Bukkit.getScheduler().cancelTask(dab1);
                                        Bukkit.getScheduler().cancelTask(dab2);
                                    }
                                }, secondsss * 20L);
                            }

                            else if (killer.hasPermission("vd.hasMVP++")) {
                                mvpplusplus1.broadcast();

                                int dab1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {

                                        mvpplusplus1.broadcast();

                                    }
                                }, 40, 40);

                                int dab2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                                    public void run() {

                                        mvpplusplus2.broadcast();

                                    }
                                }, 20, 40);

                                int secondsss = 10;

                                Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
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

               int d = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                     public void run() {
                         //ArmorStandAnimator.clearCache();
                         ArmorStandAnimator.updateAll();
                     }
                 }, 10, 1);
                 new BukkitRunnable() {

                    @Override
                    public void run() {
                        Bukkit.getScheduler().cancelTask(d);

                    }
                }.runTaskLater(Main.plugin, 220);
            }
        }
    }

    @EventHandler
    public void ArmorStandDestroy(EntityDamageByEntityEvent event){
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        final LivingEntity livingEntity = (LivingEntity)event.getEntity();
        if(!livingEntity.getType().equals(EntityType.ARMOR_STAND)){
            return;
        }

        if(event.getDamager() instanceof Player){
            Player p = (Player) event.getDamager();
            event.setCancelled(true);
            return;


        }else if(event.getDamager() instanceof Projectile){
            Projectile pro = (Projectile) event.getDamager();
            if(pro.getShooter() instanceof Player){
                Player p = (Player) pro.getShooter();
                event.setCancelled(true);
                return;
            }

            event.setCancelled(true);
            return;
        }
    }

    @EventHandler
    public void ArmorStandPreventPickUpArmor(PlayerInteractAtEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();
        if (entity instanceof ArmorStand) {
            event.setCancelled(true);

        }
    }
}
