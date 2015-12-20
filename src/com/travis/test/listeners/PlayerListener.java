package com.travis.test.listeners;

import com.travis.test.teamSetUP.teamManger.TeamSetUp;
import com.travis.test.utilities.Commands;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

/**
 * Created by Deathpoolops on 11/7/15.
 */
public class PlayerListener implements Listener {

    public EntityPlayer npc;

    //TODO uncomment

   /* @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        TeamSetUp.blueTeam.remove(player.getName());
        TeamSetUp.redTeam.remove(player.getName());
        player.sendMessage("You have be removed");
        //player.sendMessage("You have be removed form " + teamType.name());
    }

    @EventHandler
    public void selectKit(PlayerInteractEvent player) {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.getInventory().clear();
        Commands.tpr(player);
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        //TODO Need to change to a banner on the screen
        player.sendMessage(ChatColor.GREEN + "Hello " + player.getName());

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        //TODO Need to add spawn point on death
        Player player = e.getEntity();
        Commands.tpr(player);
        player.getInventory().clear();
        Commands.tpr(player);
    }*/
}