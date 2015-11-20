package com.travis.test.teamSetUP;

import com.travis.test.teamSetUP.teamManger.TeamSetUp;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

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

        sb.registerNewTeam("red");
        sb.registerNewTeam("blue");
        final Team red = sb.getTeam("red");
        final Team blue = sb.getTeam("blue");
        red.setPrefix(ChatColor.GREEN + "");
        blue.setPrefix(ChatColor.AQUA + "");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                for (String current : TeamSetUp.redTeam) {
                    player.setScoreboard(sb);
                    red.addPlayer(Bukkit.getServer().getPlayer(current));
                    blue.removePlayer(Bukkit.getServer().getPlayer(current));
                }

                for (String current : TeamSetUp.blueTeam) {
                    player.setScoreboard(sb);
                    blue.addPlayer(Bukkit.getServer().getPlayer(current));
                    red.removePlayer(Bukkit.getServer().getPlayer(current));
                }

            }
        });
        player.setScoreboard(sb);
        executorService.shutdown();

    }

}
