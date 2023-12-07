package com.example.planetsapp;

// This class acts as Model Class for our ListView
public class Planet {
    // Attributes
    private String planetName;
    private int moonCount;
    private int planetImage;

    //Constructor
    public Planet(String planetName, int moonCount, int planetImage) {
        this.planetImage = planetImage;
        this.planetName = planetName;
        this.moonCount = moonCount;
    }

    //Getters and Setters
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }

    public void setMoonCount(int moonCount) {
        this.moonCount = moonCount;
    }

    public int getMoonCount() {
        return moonCount;
    }
}
