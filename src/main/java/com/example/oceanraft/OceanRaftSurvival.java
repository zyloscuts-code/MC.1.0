package com.example.oceanraft;

import org.bukkit.plugin.java.JavaPlugin;

public class OceanRaftSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Ocean Raft Survival Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Ocean Raft Survival Disabled!");
    }
}
