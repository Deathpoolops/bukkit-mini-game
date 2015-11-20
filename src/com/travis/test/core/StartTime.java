package com.travis.test.core;

import com.travis.test.Main;
import com.travis.test.teamSetUP.teamManger.TeamSetUp;
import com.travis.test.utilities.Commands;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class StartTime extends BukkitRunnable {
    //Need to change to java runable
    public static int startTime;
    Main plugin;
    PlayerEvent playerEvent;

    public StartTime(Main pl) {
        plugin = pl;
    }

    public StartTime() {

    }

    @Override
    public void run() {
        if (startTime == 0) {
            if (TeamSetUp.getAllPlayersInTeams().size() <= 1) {
                Commands.assign();
                plugin.restartCountdown();
                return;
            }
            GameState gameState = new GameState();
            Commands.assign();
            Bukkit.broadcast("Time " + startTime, "server.basics");
            plugin.stopCountdown();
            gameState.StartGame(playerEvent.getPlayer());

        }

        if (startTime % 10 == 0 || startTime < 10) {
            Bukkit.broadcast("Time " + startTime, "server.basics");
        }

        startTime -= 1;
    }

}