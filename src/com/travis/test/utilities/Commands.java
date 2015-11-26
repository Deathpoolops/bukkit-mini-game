package com.travis.test.utilities;

import com.travis.test.teamSetUP.teamManger.TeamSetUp;
import com.travis.test.teamSetUP.teamManger.TeamType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/**
 * Created by Deathpoolops on 11/8/15.
 */
public class Commands {
    public static Player playerEvent;

    public static void assign() {
        int i = 0;
        Commands sc = new Commands();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (i < Bukkit.getOnlinePlayers().size() / 2) {
                TeamSetUp.addToTeam(TeamType.RED, player);
               // sc.redScoreboard(playerEvent);
            } else {
                TeamSetUp.addToTeam(TeamType.BLUE, player);
               // sc.blueScoreboard(playerEvent);
            }
            i++;
        }
    }
    //TODO change from tpr to lobby
    public static void tpr(Player player) {
        int x = 0, z = 0, y = 0;
        Location location = new Location(player.getWorld(), x, y, z);

        location.setX(146.5);
        location.setY(75.5);
        location.setZ(530.5);
        player.teleport(location);
    }

    public static void removePotion(Player player) {
        // player.getActivePotionEffects().clear();

        for (PotionEffect effect : player.getActivePotionEffects())
            player.removePotionEffect(effect.getType());
    }

   /* @SuppressWarnings("deprecation")
   public void blueScoreboard(Player player){
       ScoreboardManager sb = Bukkit.getScoreboardManager();
       Scoreboard board = sb.getNewScoreboard();
       Objective RedTeam = board.registerNewObjective("Red", "dummy");

       RedTeam.setDisplayName("Team Red");
       RedTeam.setDisplaySlot(DisplaySlot.SIDEBAR);

       board.registerNewTeam("Red");
       Team red = board.getTeam("Red");

       red.setPrefix(ChatColor.RED + "");

       red.addPlayer(player);


       player.setScoreboard(board);


   }
    @SuppressWarnings("deprecation")
    public void redScoreboard(Player player){
        ScoreboardManager sb = Bukkit.getScoreboardManager();
        Scoreboard board = sb.getNewScoreboard();
        Objective BlueTeam = board.registerNewObjective("Blue", "dummy");

        BlueTeam.setDisplayName("Team Blue");
        BlueTeam.setDisplaySlot(DisplaySlot.SIDEBAR);

        board.registerNewTeam("Blue");
        Team blue = board.getTeam("Blue");

        blue.setPrefix(ChatColor.BLUE + "");

        blue.addPlayer(player);

        player.setScoreboard(board);

    }*/

    /*public void scoreboard(Player player) {
        //int kills = 1000, deaths = 2;
        ScoreboardManager sb = Bukkit.getScoreboardManager();
        Scoreboard board = sb.getNewScoreboard();
        Objective RedTeam = board.registerNewObjective("Red", "dummy");
        Objective BlueTeam = board.registerNewObjective("Blue", "dummy");

        RedTeam.setDisplayName("Team Red");
        RedTeam.setDisplaySlot(DisplaySlot.SIDEBAR);

        BlueTeam.setDisplayName("Team Blue");
        BlueTeam.setDisplaySlot(DisplaySlot.SIDEBAR);

        board.registerNewTeam("Red");
        Team red = board.getTeam("Red");

        board.registerNewTeam("Blue");
        Team blue = board.getTeam("Blue");

        //red.addPlayer(player);

        //blue.addPlayer(player);

        for(Player player2: Bukkit.getOnlinePlayers()){
            player.setScoreboard(board);
            if (player2 == TeamSetUp.getRedTeam()){
                red.setPrefix(ChatColor.RED + "");

                red.addPlayer(player2);
                player.setScoreboard(board);
            }else if (player2 == TeamSetUp.getBlueTeam()){
                blue.setPrefix(ChatColor.BLUE + "");

                blue.addPlayer(player2);
                player.setScoreboard(board);
            }

        }


        player.setScoreboard(board);

    }*/

}