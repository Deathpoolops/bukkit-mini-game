package com.travis.test.listeners;

import org.bukkit.*;
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

import java.util.*;

/**
 * Created by Deathpoolops on 11/13/15.
 */
public class ItemListener implements Listener {

    public List<Projectile> explosiveArrow = new ArrayList<Projectile>();

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
            //world.createExplosion(location, 3);

            world.strikeLightning(location);
            //world.spawn(location, EnderDragon.class);
        }
        //Removes arrow to help with lag
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getShooter() instanceof Player) {
                arrow.getShooter();
                arrow.remove();
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
            return;
        }
        ItemStack tnt = new ItemStack(Material.TNT, 1);
        inv.removeItem(tnt);

        if (inv.contains(Material.TNT, 1) && inv.contains(Material.NETHER_STAR, 1)) {
            explosiveArrow.add((Projectile) event.getProjectile());
            ItemStack star = new ItemStack(Material.NETHER_STAR);
            for (int a = 0; a <= 50; a++) {
                inv.remove(star);
                Location loc1 = player.getLocation();
                loc1.setPitch((loc1.getPitch() + (getRandom() * 5)));
                loc1.setYaw((loc1.getYaw() + (getRandom() * 5)));
                Arrow s = player.launchProjectile(Arrow.class);
                s.setVelocity(loc1.getDirection().multiply(3));
                explosiveArrow.add((Projectile) s);
            }
        }
        explosiveArrow.add((Projectile) event.getProjectile());

    }

    //Get random nums for shotgun
    public float getRandom() {
        Random r = new Random();
        Random r1 = new Random();
        if (r1.nextBoolean()) {
            return r.nextFloat();
        }
        return -r.nextFloat();
    }

    @EventHandler
    public void shotgun(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();

        if (!(player.isSneaking())) {
            return;
        }

        if (!inv.contains(Material.SNOW_BALL, 1)) {
            return;
        }

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                inv.remove(Material.SNOW_BALL);
                for (int a = 0; a <= 10; a++) {
                    Location loc1 = player.getLocation();
                    loc1.setPitch((loc1.getPitch() + (getRandom() * 10)));
                    loc1.setYaw((loc1.getYaw() + (getRandom() * 10)));
                    //Snowball s = player.launchProjectile(Snowball.class);
                    Snowball s = player.launchProjectile(Snowball.class);

                    s.setVelocity(loc1.getDirection().multiply(2));
                    s.getWorld().playSound(s.getLocation(), Sound.ARROW_HIT, 10.0F, 5.0F);
                }
            }
        }

    }

    @SuppressWarnings("deprecation")
    public void spawn(PlayerInteractEvent event, Block block) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            Bukkit.getLogger().info("Working");

            Location loc1 = player.getLocation();

            block.getWorld().spawnFallingBlock(loc1, Material.GLASS, (byte) 1);


        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void titanShield(PlayerInteractEvent event) {
        int i = 0;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            if (player.getItemInHand().getType() == Material.REDSTONE_BLOCK) {
                while (i <= 2) {
                    Location loc = player.getLocation();
                    //x, y, z
                    loc.add(2, 0, 1 - i);
                    Block block = loc.getBlock();
                    block.setType(Material.BEDROCK);

                    loc.add(-4, 0, 0);
                    Block block2 = loc.getBlock();
                    block2.setType(Material.BEDROCK);

                    Location loc2 = player.getLocation();

                    loc2.add(1 - i, 0, 2);
                    Block block3 = loc2.getBlock();
                    block3.setType(Material.BEDROCK);


                    loc2.add(0, 0, -4);
                    Block block4 = loc2.getBlock();
                    block4.setType(Material.BEDROCK);

                    titanShieldHelper titanShieldHelper = new titanShieldHelper();
                    titanShieldHelper.shield(event);

                    i++;
                }
            }

        }

    }

}