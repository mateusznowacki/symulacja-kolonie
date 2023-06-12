package com.simulaton.app.colony;

import com.simulaton.app.map.NPosition;
import com.simulaton.app.map.NResources;

import java.util.HashMap;
import java.util.Map;




/**
 * Represents colony's attributes, properties, methods
 */
public class Colony {

    private String name;
    private int attackStrength;
    private int defenseStrength;
    private int economyStrength;
    private int population;
    private int armySize;

    public HashMap<NResources, Integer> getResourceCounts() {
        return resourceCounts;
    }

    public void setResourceCounts(HashMap<NResources, Integer> resourceCounts) {
        this.resourceCounts = resourceCounts;
    }

    private HashMap<NResources,Integer> resourceCounts;
    private int numOccupiedPositions = 0;

    /**
     *
     * @return the number of occupied positions
     */
    public int getNumOccupiedPositions() {
        return numOccupiedPositions;
    }

    /**
     *
     * @param numOccupiedPositions number of occupied positions
     */

    public void setNumOccupiedPositions(int numOccupiedPositions) {
        this.numOccupiedPositions += numOccupiedPositions;
    }





    /**
     * colony constructor
     * @param name colony name
     * @param attackStrength attack strenght
     * @param defenseStrength defense strenght
     * @param economyStrength economy strenght
     * @param population population size
     * @param armySize army size
     */
    public Colony(String name, int attackStrength, int defenseStrength, int economyStrength, int population, int armySize) {
        this.name = name;
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.economyStrength = economyStrength;
        this.population = population;
        this.armySize = armySize;
        resourceCounts = new HashMap<>();
    }


    /**
     *
     * @return colony name
     */

    public String getName() {
        return name;
    }

    /**
     *
     * @return colony attaack strenght
     */

    public int getAttackStrength() {
        return attackStrength;
    }

    /**
     *
     * @return colony defence strenght
     */

    public int getDefenseStrength() {
        return defenseStrength;
    }

    /**
     *
     * @return colony defence strenght
     */

    public int getEconomyStrength() {
        return economyStrength;
    }

    /**
     *
     * @return colony population
     */
    public int getPopulation() {
        return population;
    }

    /**
     *
     * @return army size
     */
    public int getArmySize() {
        return armySize;
    }
}
