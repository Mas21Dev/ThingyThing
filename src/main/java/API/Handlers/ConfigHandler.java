package ex.spork.core.API.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigHandler {

    private void createConfig(Plugin plugin) {
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdirs();
            }
            File file = new File(plugin.getDataFolder(), "config.yml");
            if (!file.exists()) {
                Bukkit.getLogger().info("config.yml not found, creating!");
                plugin.saveDefaultConfig();
            } else {
                Bukkit.getLogger().info("config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
