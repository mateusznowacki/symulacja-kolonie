package com.simulaton.app.colony;

public abstract class Unit {
    private String name;
    private int population;
    private int armySize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArmySize() {
        return armySize;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }

    public Unit(String name, int population, int armySize) {
        this.name = name;
        this.population = population;
        this.armySize = armySize;
    }
}
