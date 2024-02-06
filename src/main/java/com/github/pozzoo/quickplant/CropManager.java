package com.github.pozzoo.quickplant;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class CropManager {
    private final List<Material> cropList;

    public CropManager() {
        cropList = new ArrayList<>();
        warmupCrops();
    }

    private void warmupCrops() {
        this.cropList.add(Material.WHEAT);
        this.cropList.add(Material.CARROTS);
        this.cropList.add(Material.POTATOES);
        this.cropList.add(Material.BEETROOTS);
        this.cropList.add(Material.TORCHFLOWER_CROP);
    }

    public boolean isCrop(Material material) {
        return this.cropList.contains(material);
    }
}
