package ex.spork.core.API.Methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Teleport {

    public static void teleLoc(Player p, Location loc) {

        p.teleport(loc);

    }

    public static void teleServer(Player p, String server) {

        

    }

    public static void teleAlltoLoc(Location loc) {

        for (Player p : Bukkit.getOnlinePlayers()) {

            p.teleport(loc);

        }

    }

    public static void teleportAlltoServer(String server) {



    }

}
