package com.travis.test.teamSetUP;

import com.travis.test.utilities.Commands;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

/**
 * Created by Deathpoolops on 11/7/15.
 */
public class Kits {

    public static ArrayList<String> knight = new ArrayList<String>();
    public static ArrayList<String> Spy = new ArrayList<String>();
    public static ArrayList<String> Tank = new ArrayList<String>();
    public static ArrayList<String> Chemist = new ArrayList<String>();

    public static ArrayList<String> hasAkit = new ArrayList<String>();
    public static ArrayList<String> potionList = new ArrayList<String>();


    public Kits() {
    }

    public static boolean setKnight(String value, Player player) {
        /*if(hasAkit.contains(player.getName())){
            player.sendMessage(ChatColor.GOLD + "do not do it agean");
            return true;
        }*/

        hasAkit.add(player.getName());
        player.getInventory().clear();
        Commands.removePotion(player);

        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
        player.getInventory().setItem(1, new ItemStack(Material.BOW));
        player.getInventory().setItem(6, new ItemStack(Material.WOOD, 64));
        player.getInventory().setItem(7, new ItemStack(Material.APPLE, 5));
        player.getInventory().setItem(8, new ItemStack(Material.ARROW, 5));
        player.setMaxHealth(20);
        player.setHealth(20);

        return true;
    }

    public static boolean setSpy(String value, Player player) {
        /*if(hasAkit.contains(p.getName())){
            p.sendMessage(ChatColor.GOLD + "do not do it agean");
            return true;
        }*/

        hasAkit.add(player.getName());
        player.getInventory().clear();
        Commands.removePotion(player);

        PotionType potionType = PotionType.INVISIBILITY;

        player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
        player.getInventory().setItem(6, new ItemStack(Material.WOOD, 64));
        player.getInventory().setItem(7, new ItemStack(Material.APPLE, 5));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 1));
        player.setMaxHealth(20);
        player.setHealth(20);

        return true;
    }

    public static boolean setTank(String value, Player player) {
        /*if(hasAkit.contains(p.getName())){
            p.sendMessage(ChatColor.GOLD + "do not do it agean");
            return true;
        }*/

        hasAkit.add(player.getName());
        player.getInventory().clear();
        Commands.removePotion(player);

        player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        player.getInventory().setItem(7, new ItemStack(Material.WOOD, 64));
        player.getInventory().setItem(8, new ItemStack(Material.APPLE, 5));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 2));
        player.setMaxHealth(40);
        player.setHealth(40);


        return true;
    }
    //TODO Need to potions
    public static boolean setChemist(String value, Player player) {
       /* if(hasAkit.contains(p.getName())){
            p.sendMessage(ChatColor.GOLD + "do not do it agean");
            return true;
        }*/

        hasAkit.add(player.getName());
        player.getInventory().clear();
        Commands.removePotion(player);

        ItemStack helm = new ItemStack(Material.GOLD_HELMET);
        ItemStack chest = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemStack pants = new ItemStack(Material.GOLD_LEGGINGS);
        ItemStack boots = new ItemStack(Material.GOLD_BOOTS);

        helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        pants.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
        player.getInventory().setItem(1, new ItemStack(Material.BOW));
        player.getInventory().setItem(6, new ItemStack(Material.WOOD, 64));
        player.getInventory().setItem(7, new ItemStack(Material.APPLE, 5));
        player.getInventory().setItem(8, new ItemStack(Material.ARROW, 5));
        player.setMaxHealth(20);
        player.setHealth(20);

        return true;
    }

}