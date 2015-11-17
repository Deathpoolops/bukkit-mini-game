package com.travis.test.core;

import com.travis.test.Main;
import com.travis.test.core.GameState;
import com.travis.test.teamSetUP.teamManger.Team;
import com.travis.test.utilities.Commands;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class StartTime extends BukkitRunnable {

    public static int startTime;
    Main plugin;
    PlayerInteractEvent event;
    PlayerEvent playerEvent;

    public StartTime(Main pl) {
        plugin = pl;
    }

    /*public StartTime() {
        Main main = null;
        plugin = main;
    }*/

    @Override
    public void run() {
        if (startTime == 0) {
            if (Team.getAllPlayersInTeams().size() <= 1) {
                Commands.assign();
                plugin.restartCountdown();
                return;
            }

            Commands.assign();
            Bukkit.broadcast("Time " + startTime, "server.basics");
            plugin.stopCountdown();
            GameState.StartGame(playerEvent.getPlayer());

        }

        if (startTime % 10 == 0 || startTime < 10) {
            Bukkit.broadcast("Time " + startTime, "server.basics");
        }

        startTime -= 1;
    }

}