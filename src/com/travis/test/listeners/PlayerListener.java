package com.travis.test.listeners;

import com.mojang.authlib.GameProfile;
import com.travis.test.Main;
import com.travis.test.teamSetUP.teamManger.TeamSetUp;
import com.travis.test.utilities.Commands;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

import java.util.UUID;

/**
 * Created by Deathpoolops on 11/7/15.
 */
public class PlayerListener implements Listener {

    public EntityPlayer npc;


    @EventHandler
    public void selectKit(PlayerInteractEvent player){

    }

    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        TeamSetUp.blueTeam.remove(player.getName());
        TeamSetUp.redTeam.remove(player.getName());
        player.sendMessage("You have be removed");
        //player.sendMessage("You have be removed form " + teamType.name());
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

      /*  MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer worldServer = ((CraftWorld) Bukkit.getServer().getWorlds().get(0)).getHandle();
        npc = new EntityPlayer(server, worldServer, new GameProfile(UUID.randomUUID(), "NPC"), new PlayerInteractManager(worldServer));


        npc.teleportTo(e.getPlayer().getLocation(), false);

        PlayerConnection connection = ((CraftPlayer) e.getPlayer()).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));*/
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        //TODO Need to add spawn point on death
        Player player = e.getEntity();
        Commands.tpr(player);
        player.getInventory().clear();
        Commands.tpr(player);
    }
}