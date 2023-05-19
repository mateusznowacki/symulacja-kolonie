package com.simulaton;

import java.util.HashMap;

public class Colony {
    private String name;
    private int attackStrength;
    private int defenseStrength;
    private int economyStrength;
    private int population;
    private int armySize;

    HashMap<String,Integer> amountOfResources = new HashMap<>();
 //   private int[][] amountOfResources;   //[unitType][unitAmount] zloto drzewo kamien metal jedzenie

    public Colony(String name, int attackStrength, int defenseStrength, int economyStrength, int population, int armySize) {
        this.name = name;
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.economyStrength = economyStrength;
        this.population = population;
        this.armySize = armySize;

    }

    public void reciveResources(String type, Integer amount) {
        if(amountOfResources.containsKey(type)){
            Integer totalAmount = amountOfResources.get(type) + amount;
            amountOfResources.replace(type,totalAmount);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getDefenseStrength() {
        return defenseStrength;
    }

    public void setDefenseStrength(int defenseStrength) {
        this.defenseStrength = defenseStrength;
    }

    public int getEconomyStrength() {
        return economyStrength;
    }

    public void setEconomyStrength(int economyStrength) {
        this.economyStrength = economyStrength;
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

//    public int[][] getAmountOfResources() {
//        return amountOfResources;
//    }
//
//    public void setAmountOfResources(int[][] amountOfResources) {
//        this.amountOfResources = amountOfResources;
//    }
}
