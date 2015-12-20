package com.travis.test.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Deathpoolops on 12/20/15.
 */
public class titanShieldHelper {

    //This is some bad code... It needs a lot of fixing
    //// TODO: 12/20/15 fix code... A lot of fixing.
    public void shield(PlayerInteractEvent event) {
        int i = 0;
        Player player = event.getPlayer();

        while (i <= 2) {
            Location loc = player.getLocation();
            //x, y, z
            loc.add(2, 1, 1 - i);
            Block block = loc.getBlock();
            block.setType(Material.BEDROCK);

            loc.add(-4, 0, 0);
            Block block2 = loc.getBlock();
            block2.setType(Material.BEDROCK);

            Location loc2 = player.getLocation();

            loc2.add(1 - i, 1, 2);
            Block block3 = loc2.getBlock();
            block3.setType(Material.BEDROCK);


            loc2.add(0, 0, -4);
            Block block4 = loc2.getBlock();
            block4.setType(Material.BEDROCK);


            Location loc3 = player.getLocation();
            //x, y, z
            loc3.add(2, 2, 1 - i);
            Block block5 = loc3.getBlock();
            block5.setType(Material.BEDROCK);

            loc3.add(-4, 0, 0);
            Block block6 = loc3.getBlock();
            block6.setType(Material.BEDROCK);

            Location loc4 = player.getLocation();

            loc4.add(1 - i, 2, 2);
            Block block7 = loc4.getBlock();
            block7.setType(Material.BEDROCK);


            loc4.add(0, 0, -4);
            Block block8 = loc4.getBlock();
            block8.setType(Material.BEDROCK);

            i++;
        }
    }
}