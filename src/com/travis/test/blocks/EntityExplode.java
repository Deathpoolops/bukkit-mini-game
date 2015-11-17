package com.travis.test.blocks;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Created by travisws on 11/7/15.
 */
public class EntityExplode implements Listener {


//    @SuppressWarnings("deprecation")
   /* @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if(action.equals(Action.LEFT_CLICK_AIR)){
            if (player.getItemInHand().getType() == Material.BLAZE_ROD) {

                Location block = PlayerList
                player.getWorld().spawnEntity(block, EntityType.CREEPER);
            }
        }

    }*/

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
            return;
        }

        event.getBlock().getWorld().spawnFallingBlock(event.getBlock().getLocation(), event.getBlock().getType(), event.getBlock().getData());
        event.getBlock().setType(Material.AIR);
    }

}