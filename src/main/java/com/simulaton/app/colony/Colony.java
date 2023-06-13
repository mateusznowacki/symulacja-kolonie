package com.simulaton.app.colony;

import com.simulaton.app.map.resources.ResourceTypes;

import java.util.HashMap;


/**
 * Represents colony's attributes, properties, methods
 */
public class Colony extends Unit {

    private int attackStrength;
    private int defenseStrength;
    private int economyStrength;
    private HashMap<ResourceTypes, Integer> resourceCounts;



    public int getBattleWins() {
        return battleWins;
    }

    public void setBattleWins(int battleWins) {
        this.battleWins = battleWins;
    }

    private int battleWins = 0;

    public HashMap<ResourceTypes, Integer> getResourceCounts() {
        return resourceCounts;
    }

    public void setResourceCounts(HashMap<ResourceTypes, Integer> resourceCounts) {
        this.resourceCounts = resourceCounts;
    }




    /**
     * colony constructor
     *
     * @param name            colony name
     * @param attackStrength  attack strenght
     * @param defenseStrength defense strenght
     * @param economyStrength economy strenght
     * @param population      population size
     * @param armySize        army size
     */
    public Colony(String name, int attackStrength, int defenseStrength, int economyStrength, int population, int armySize) {
        super(name, population, armySize);
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.economyStrength = economyStrength;

        resourceCounts = new HashMap<>();
    }


    /**
     *
     * @return colony name
     */

    //public String getName() {
    //     return name;
    // }

    /**
     * @return colony attaack strenght
     */

    public int getAttackStrength() {
        return attackStrength;
    }

    /**
     * @return colony defence strenght
     */

    public int getDefenseStrength() {
        return defenseStrength;
    }

    /**
     * @return colony defence strenght
     */

    public int getEconomyStrength() {
        return economyStrength;
    }

    /**
     *
     * @return colony population
     */
    //  public int getPopulation() {
    //    return population;
    //  }

    /**
     *
     * @return army size
     */
    // public int getArmySize() {
    //      return armySize;
    // }
}
