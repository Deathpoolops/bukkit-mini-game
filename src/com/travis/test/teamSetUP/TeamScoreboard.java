package com.travis.test.teamSetUP;

import com.travis.test.teamSetUP.teamManger.TeamSetUp;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Deathpoolops on 11/19/15.
 */
public class TeamScoreboard {
    @SuppressWarnings("deprecation")
    public void scoreboard(Player player) {
        final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective ob = sb.registerNewObjective("Prefixs", "dummy");
        ob.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        ob.setDisplayName("Teams");

        sb.registerNewTeam("red");
        sb.registerNewTeam("blue");
        Team red = sb.getTeam("red");
        Team blue = sb.getTeam("blue");
        red.setPrefix(ChatColor.RED + "");
        blue.setPrefix(ChatColor.BLUE + "");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (Player online : Bukkit.getOnlinePlayers()) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (String current : TeamSetUp.redTeam) {
                        online.setScoreboard(sb);
                        red.addPlayer(Bukkit.getServer().getPlayer(current));
                        blue.removePlayer(Bukkit.getServer().getPlayer(current));
                        red.setNameTagVisibility(NameTagVisibility.ALWAYS);

                    }

                    for (String current : TeamSetUp.blueTeam) {
                        online.setScoreboard(sb);
                        blue.addPlayer(Bukkit.getServer().getPlayer(current));
                        red.removePlayer(Bukkit.getServer().getPlayer(current));
                        blue.setNameTagVisibility(NameTagVisibility.ALWAYS);

                    }

                }
            });
        }
        player.setScoreboard(sb);
        executorService.shutdown();
    }

}