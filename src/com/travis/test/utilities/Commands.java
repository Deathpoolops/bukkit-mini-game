package com.travis.test.utilities;

import com.travis.test.teamSetUP.teamManger.Team;
import com.travis.test.teamSetUP.teamManger.TeamType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/**
 * Created by travisws on 11/8/15.
 */
public class Commands {

    public static void assign() {
        int i = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (i < Bukkit.getOnlinePlayers().size() / 2) {
                Team.addToTeam(TeamType.RED, player);
            } else {
                Team.addToTeam(TeamType.BLUE, player);
            }
            i++;
        }
    }

    public static void tpr(Player player) {
        int x = 0, z = 0, y = 0;
        Location location = new Location(player.getWorld(), x, y, z);

        location.setX(67);
        location.setY(122);
        location.setZ(340);
        player.teleport(location);
    }

    public static void removePotion(Player player) {
        // player.getActivePotionEffects().clear();

        for (PotionEffect effect : player.getActivePotionEffects())
            player.removePotionEffect(effect.getType());
    }

}