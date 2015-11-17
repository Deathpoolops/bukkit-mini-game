package com.travis.test.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Deathpoolops on 11/13/15.
 */
public class ItemListener implements Listener {

    public List<Projectile> explosiveArrow = new ArrayList<Projectile>();

    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        World world = projectile.getWorld();
        Location location = projectile.getLocation();
        EntityType type = projectile.getType();

        if (type != EntityType.ARROW) {
            return;
        }

        if (explosiveArrow.contains(projectile)) {
            explosiveArrow.remove(projectile);
            world.createExplosion(location, 3);

            world.strikeLightning(location);

        }
    }

    @EventHandler
    public void sword(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();

        if (!inv.contains(Material.SNOW_BALL, 1)) {
            //player.sendMessage(ChatColor.RED + "Snow Ball");
            return;
        }

        if (player.getItemInHand().getType() == Material.BAKED_POTATO && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {

            Action action = event.getAction();
            //Arrow arrow = player.launchProjectile(Arrow.class);
            Snowball snowball = player.getWorld().spawn(player.getEyeLocation(), Snowball.class);
            ItemStack tnt = new ItemStack(Material.SNOW_BALL, 1);
            inv.removeItem(tnt);

            snowball.setShooter(player);
            snowball.setVelocity(player.getLocation().getDirection().multiply(1.5));
        }

    }

    @EventHandler
    public void lightning(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getItemInHand().getType() == Material.BLAZE_ROD) {
                Set<Material> transparent = new HashSet<Material>();
                transparent.add(Material.AIR);
                Block block = player.getTargetBlock(transparent, 300);
                player.getWorld().strikeLightning(block.getLocation());
            }
        }
    }

    @EventHandler
    public void onArrowShoot(EntityShootBowEvent event) {
        LivingEntity shooter = event.getEntity();
        Player player = (Player) shooter;
        Inventory inv = player.getInventory();

        if (!(shooter instanceof Player)) {
            return;
        }

        if (!(player.isSneaking())) {
            return;
        }

        if (!inv.contains(Material.TNT, 1)) {
            player.sendMessage(ChatColor.RED + "You do not have TNT");
            return;
        }

        ItemStack tnt = new ItemStack(Material.TNT, 1);
        inv.removeItem(tnt);

        explosiveArrow.add((Projectile) event.getProjectile());

    }
}
