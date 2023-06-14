package com.simulaton.app.colony;

import java.util.Objects;

/**
 * The type Unit.
 */
public abstract class Unit {
    private String name;
    private int population;
    private int armySize;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Gets army size.
     *
     * @return the army size
     */
    public int getArmySize() {
        return armySize;
    }

    /**
     * Instantiates a new Unit.
     *
     * @param name       the name
     * @param population the population
     * @param armySize   the army size
     */
    public Unit(String name, int population, int armySize) {
        this.name = name;
        this.population = population;
        this.armySize = armySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return population == unit.population && armySize == unit.armySize && Objects.equals(name, unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, armySize);
    }
}
