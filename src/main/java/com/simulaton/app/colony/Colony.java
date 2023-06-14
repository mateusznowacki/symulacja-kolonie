package com.simulaton.app.colony;

import com.simulaton.app.map.resources.ResourceTypes;

import java.util.HashMap;


/**
 * The type Colony.
 */
public class Colony extends Unit {

    private int attackStrength;
    private int defenseStrength;
    private int economyStrength;
    private HashMap<ResourceTypes, Integer> resourceCounts;


    /**
     * Gets battle wins.
     *
     * @return the battle wins
     */
    public int getBattleWins() {
        return battleWins;
    }

    /**
     * Sets battle wins.
     *
     * @param battleWins the battle wins
     */
    public void setBattleWins(int battleWins) {
        this.battleWins = battleWins;
    }

    private int battleWins = 0;

    /**
     * Gets resource counts.
     *
     * @return the resource counts
     */
    public HashMap<ResourceTypes, Integer> getResourceCounts() {
        return resourceCounts;
    }


    /**
     * Instantiates a new Colony.
     *
     * @param name            the name
     * @param attackStrength  the attack strength
     * @param defenseStrength the defense strength
     * @param economyStrength the economy strength
     * @param population      the population
     * @param armySize        the army size
     */
    public Colony(String name, int attackStrength, int defenseStrength, int economyStrength, int population, int armySize) {
        super(name, population, armySize);
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.economyStrength = economyStrength;

        resourceCounts = new HashMap<>();
    }

    /**
     * Gets attack strength.
     *
     * @return colony name
     */
    public int getAttackStrength() {
        return attackStrength;
    }

    /**
     * Gets defense strength.
     *
     * @return the defense strength
     */
    public int getDefenseStrength() {
        return defenseStrength;
    }

    /**
     * Gets economy strength.
     *
     * @return the economy strength
     */
    public int getEconomyStrength() {
        return economyStrength;
    }

}
