package fun.brou.VictoryDance.Dance;

import fun.brou.VictoryDance.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.HashMap;

public class Guardians implements Listener {

    /**
     Guardianを回す処理がわからないです
     アイディアがある方はdiscordに送ってください (難しい処理は理解できないかもしれないです)
     **/

    /*
    boolean dance = false;

    @EventHandler
    public void KillEvent(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        World w = killer.getWorld();
        Location loc = killer.getLocation();


        NPCRegistry registry = CitizensAPI.getNPCRegistry();

        NPC npc = registry.createNPC(EntityType.GUARDIAN, "");
        npc.setFlyable(true);
        npc.setProtected(true);
        npc.faceLocation(killer.getLocation().add(0, 1.2, 0));

        NPC npc2 = registry.createNPC(EntityType.GUARDIAN, "");
        npc2.setFlyable(true);
        npc2.setProtected(true);
        npc2.faceLocation(killer.getLocation().add(0,1.2,0));

        NPC npc3 = registry.createNPC(EntityType.GUARDIAN, "");
        npc3.setFlyable(true);
        npc3.setProtected(true);
        npc3.faceLocation(killer.getLocation().add(0,1.2,0));

        if (event.getEntity().getKiller() instanceof Player) {
            if (Main.plugin.getConfig().getString(killer.getUniqueId().toString() + ".DANCE").equalsIgnoreCase("GUARDIANS")) {

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                    @Override
                    public void run() {
                        Location loc2 = killer.getLocation();
                        Location loc3 = killer.getLocation();
                        npc.spawn(loc.add(1.7, 1.2, 1.7));
                        npc2.spawn(loc2.add(-1.7, -1.2, -1.7));
                        npc3.spawn(loc3.add(-1.7, -1.2, 1.7));
                        npc.faceLocation(killer.getLocation().add(0, 1.0, 0));
                        npc2.faceLocation(killer.getLocation().add(0, 1.0, 0));
                        npc3.faceLocation(killer.getLocation().add(0, 1.0, 0));
                        dance = true;
                    }
                }, 10L);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

                    @Override
                    public void run() {

                        npc.despawn();
                        npc2.despawn();
                        npc3.despawn();
                    }
                }, 220L);
            }
        }
    }*/
}
