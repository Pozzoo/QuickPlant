package com.github.pozzoo.quickplant.listeners;

import com.github.pozzoo.quickplant.QuickPlant;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class PlayerListener implements Listener {
    public PlayerListener(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockRightClick(PlayerInteractEvent event) {
        if (!(event.getAction().isRightClick())) return;
        if (!(event.hasBlock())) return;
        if (!(QuickPlant.getInstance().getCropManager().isCrop(event.getClickedBlock().getType()))) return;

        Ageable ageable = (Ageable) event.getClickedBlock().getState().getBlockData();

        if (ageable.getAge() != ageable.getMaximumAge()) return;

        Material type = event.getClickedBlock().getType();

        Location location = event.getClickedBlock().getLocation();
        event.getClickedBlock().breakNaturally(false);

        location.getBlock().setType(type);
    }
}
