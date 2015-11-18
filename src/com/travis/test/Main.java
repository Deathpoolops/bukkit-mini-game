package com.travis.test;

import com.travis.test.blocks.EntityExplode;
import com.travis.test.core.GameState;
import com.travis.test.core.StartTime;
import com.travis.test.listeners.ItemListener;
import com.travis.test.listeners.PlayerListener;
import com.travis.test.teamSetUP.Kits;
import com.travis.test.teamSetUP.teamManger.Team;
import com.travis.test.utilities.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Deathpoolops on 11/6/15.
 */
public class Main extends JavaPlugin {

    public static int startTimeID;

    public void onEnable() {
        Team.clearTeams();
        registerListeners();
        this.getLogger().info("Main is started");
        //startCountdown();

    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EntityExplode(), this);
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new Team(), this);
        pm.registerEvents(new ItemListener(), this);

    }

    @SuppressWarnings("deprecation")
    public void startCountdown() {
        //TODO Need to change from bukkit runable to java runable.
        BukkitRunnable bukkitRunnable = new StartTime(this);
        StartTime.startTime = 20;
        startTimeID = getServer().getScheduler().scheduleSyncRepeatingTask(this, bukkitRunnable, 10, 10);
    }

    public void stopCountdown() {
        getServer().getScheduler().cancelTask(startTimeID);
    }

    public void restartCountdown() {
        stopCountdown();
        startCountdown();
    }

    public void onDisable() {
        Team.clearTeams();
        this.getLogger().info("Main is disable");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //TODO Need to remove 95%  of all the command on this method
        if (label.equalsIgnoreCase("assign")) {
            Player player = (Player) sender;
            Commands.assign();
            //startCountdown();
        }

        if (command.getName().equalsIgnoreCase("startGame")) {
            GameState gameState = new GameState();
            Player player = (Player) sender;
            stopCountdown();
            gameState.StartGame(player);
        }

        if (command.getName().equalsIgnoreCase("removePlayer")) {
            Player player = (Player) sender;
            String test = player.getName();
            PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(player, test);
            PlayerListener.onPlayerQuit(playerQuitEvent);
        }

        if (command.getName().equalsIgnoreCase("tpr")) {
            Player player = (Player) sender;
            Commands.tpr(player);
        }

        if (command.getName().equalsIgnoreCase("Name")) {
        }


        if (command.getName().equalsIgnoreCase("startTime")) {
            startCountdown();
        }

        if (command.getName().equalsIgnoreCase("StopTime")) {
            stopCountdown();
        }

        if (command.getName().equalsIgnoreCase("kit")) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.DARK_GREEN + "usage: /kit knight; Spy; Tank; Chemist");
            }
            for (int i = 0; i < args.length; i++) {
                String value = args[i];
                if (value.equalsIgnoreCase("knight")) {
                    System.out.println("Setting Knight");
                    Kits.setKnight(value, player);
                } else if (value.equalsIgnoreCase("Spy")) {
                    System.out.println("Setting Spy");
                    Kits.setSpy(value, player);
                } else if (value.equalsIgnoreCase("Tank")) {
                    System.out.println("Setting Tank");
                    Kits.setTank(value, player);
                } else if (value.equalsIgnoreCase("Chemist")) {
                    System.out.println("Setting Chemist");
                    Kits.setChemist(value, player);
                }
            }
        }

        return false;
    }

}
