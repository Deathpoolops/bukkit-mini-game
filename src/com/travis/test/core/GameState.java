package com.travis.test.core;

import com.travis.test.teamSetUP.teamManger.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by travisws on 11/8/15.
 */
public class GameState {
    public static void StartGame(Player player) {
        SpawnBlue(player);
        SpawnRed(player);
    }

    public static void SpawnRed(Player player){
        double a = 100.5, b = 100.5, c = 100.5;

        for (String current : Team.redTeam) {
            Location locationRed = new Location(player.getWorld(), a, b, c);
            Bukkit.getServer().getPlayer(current).teleport(locationRed);
            a++;
            b++;
            c++;
        }

    }

    public static void SpawnBlue(Player player){
        double x = 110.5, y = 110.5, z = 110.5;

        for (String current : Team.blueTeam) {
            Location locationBlue;
            locationBlue = new Location(player.getWorld(), x, y, z);
            Bukkit.getServer().getPlayer(current).teleport(locationBlue);
            x++;
            y++;
            z++;
        }

    }

}