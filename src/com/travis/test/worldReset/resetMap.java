package com.travis.test.worldReset;

/**
 * Created by travisws on 11/11/15.
 */
public class resetMap {

    /*public static void resetMap(){
        World w = Bukkit.getWorld("world");
        for(Player p : Bukkit.getOnlinePlayers()) {
            //PodzolAPI.connect(p, "lobby");
        }

        String test = "test";

        Main.main(test).getServer().unloadWorld(Bukkit.getServer().getWorld(w.getName()), true);
        System.out.println("resetting map...");

        try {
            System.out.println("trying to reset map...");
            final File oldWorld = new File(Bukkit.getServer().getWorldContainer(), w.getName());
            final File newWorld = new File(Main.that.getDataFolder(), w.getName());
            if(oldWorld.exists() && newWorld.exists()) {
                File region = new File(Bukkit.getWorldContainer() + File.separator + w.getName() + File.separator + "region");
                File players = new File(Bukkit.getWorldContainer() + File.separator + w.getName() + File.separator + "players");
                File data = new File(Bukkit.getWorldContainer() + File.separator + w.getName() + File.separator + "data");
                File DIM = new File(Bukkit.getWorldContainer() + File.separator + w.getName() + File.separator + "DIM-1");
                File main = new File(Bukkit.getWorldContainer() + File.separator + w.getName());
                region.delete();
                players.delete();
                data.delete();
                DIM.delete();
                main.delete();
                FileUtils.copyDirectory(newWorld, new File(Bukkit.getWorldContainer() + File.separator + w.getName()));
                System.out.println("map reset sucessfully!");
            }
            else{
                System.out.println("map could not be reset. Exists - oldWorld: " + oldWorld.exists() + " newWorld: " + newWorld.exists());
            }
        } catch (Exception e) {
            System.out.println("map reset failed!");
            e.printStackTrace();
        }
        Bukkit.getServer().createWorld(new WorldCreator(w.getName()));
    }*/
}
