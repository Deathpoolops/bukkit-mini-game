package com.travis.test.teamSetUP.teamManger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deathpoolops on 11/7/15.
 */
public class Team implements Listener {

    public static List<String> redTeam = new ArrayList<String>();
    public static List<String> blueTeam = new ArrayList<String>();

    public static void addToTeam(TeamType type, Player player) {
        if (isInTeam(player)) {
            player.sendMessage("You are already in a Team!");
            return;
        }
        switch (type) {
            case RED:
                redTeam.add(player.getName());
                break;
            case BLUE:
                blueTeam.add(player.getName());
                break;
        }
        player.sendMessage(ChatColor.RED + "Added to " + type.name() + " Team!");

    }

    public static void clearTeams() {
        redTeam.clear();
        blueTeam.clear();
    }

    public static boolean isInTeam(Player player) {
        return redTeam.contains(player.getName()) || blueTeam.contains(player.getName());
    }

    public static List<String> getRedTeam() {
        return redTeam;
    }

    public static List<String> getBlueTeam() {
        return blueTeam;
    }

    public static List<String> getAllPlayersInTeams() {
        List<String> AllLists = new ArrayList<String>();
        AllLists.addAll(redTeam);
        AllLists.addAll(blueTeam);

        return AllLists;
    }

    public static TeamType getTeamType(Player player) {
        if (!isInTeam(player))
            return null;
        return (redTeam.contains(player.getName()) ? TeamType.RED : TeamType.BLUE);

    }


    @EventHandler
    public void joinRed(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
            /*if(isInTeam(player)){
                player.sendMessage("You are already in a Team!");
                return;
            }*/

            if (event.getClickedBlock().getType() == Material.REDSTONE_BLOCK) {
                redTeam.add(player.getName());
                player.sendMessage("You are on Team" + ChatColor.RED + "Red");
                addToTeam(TeamType.RED, player);

                /*player.sendMessage(player.getName());
                player.getInventory().addItem(new ItemStack(Material.BOW, 1));
                player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
                player.getInventory().addItem(new ItemStack(Material.TNT, 64));
                player.getInventory().addItem(new ItemStack(Material.DRAGON_EGG, 64));*/
            }
        }
    }

}