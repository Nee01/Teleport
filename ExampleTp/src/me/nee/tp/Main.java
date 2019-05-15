package me.nee.tp;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin=this;
        this.getCommand("Teleport").setExecutor(new Commands(this));
    }
}
