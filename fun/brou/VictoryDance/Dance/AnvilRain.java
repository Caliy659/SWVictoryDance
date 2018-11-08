package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class AnvilRain implements Listener {

    /**
     ブロックを消すときの処理がまだ完璧に出来てないため
     アイディアがある方はdiscordに送ってください (難しい処理は理解できないかもしれないです)
     **/

    /*public double random(final double min, final double max) {
        return Math.random() * (max - min) + min;
    }

    @EventHandler
    public void KillEvent(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        World w = killer.getWorld();
        if (event.getEntity().getKiller() instanceof Player) {
            if(Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("ANVIL_RAIN")) {
                for (int i = 0; i < 100; ++i) {

                    int dancestart = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

                        public void run() {
                            Location kloc = killer.getLocation().add(random(-50, 50), (double) 50, random(-50, 50));
                            Block block = kloc.getBlock();
                            if (block.getType() == Material.AIR) {
                                Location loc = kloc;
                                int bloc = w.getHighestBlockYAt(kloc);
                                loc = kloc.add(random(5, 1), random(8, 1), random(5, 1));
                                for (int limit = 0; limit < 100; ++limit) {

                                    if (kloc.getBlock().getWorld().getHighestBlockAt(kloc).getType() == Material.ANVIL) {
                                        killer.sendMessage("AIR dessu");
                                        loc.getBlock().setType(Material.AIR);
                                    }
                                    if (loc.getBlock().getType() == Material.AIR) {
                                        loc.getBlock().setType(Material.ANVIL);
                                        Block bb = kloc.getWorld().getHighestBlockAt(kloc);


                                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                                            @Override
                                            public void run() {
                                                bb.setType(Material.AIR);
                                            }
                                        }, 300L);
                                    }
                                }
                            }
                        }
                    }, 20, 40);


                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                        @Override
                        public void run() {
                                Bukkit.getScheduler().cancelTask(dancestart);
                        }
                    }, 220L);
                }
            }
        }
    }*/
}
