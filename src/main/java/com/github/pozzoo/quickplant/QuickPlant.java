package com.github.pozzoo.quickplant;

import com.github.pozzoo.quickplant.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuickPlant extends JavaPlugin {

    private CropManager cropManager;
    private static QuickPlant instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        cropManager = new CropManager();
        new PlayerListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static QuickPlant getInstance() {
        return instance;
    }

    public CropManager getCropManager() {
        return cropManager;
    }
}
