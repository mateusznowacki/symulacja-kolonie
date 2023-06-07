package com.simulaton.app.simulationEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static com.simulaton.fileManager.FileManager.collectResources;

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
    private final int checkPoint = 0;
    private int pointsToSpend;
    private int populationPointsToSpend;
    private Map<String, Integer> resourceCounts;
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
     * add resources if colony won
     * subtracts resources if colony lost
     * @param isWinner boolean is winner
     */
    public void manageResources(boolean isWinner) {
        Random random = new Random();
        if (isWinner) {
            resourceCounts.put("iron", resourceCounts.get("iron") + random.nextInt(3));
            resourceCounts.put("wood", resourceCounts.get("wood") + random.nextInt(1));
            resourceCounts.put("food", resourceCounts.get("food") + random.nextInt(3));
            resourceCounts.put("stone", resourceCounts.get("stone") + random.nextInt(1));
            attackStrength += 30;
            defenseStrength += 20;
            economyStrength += 10;
        } else {
            resourceCounts.put("iron", resourceCounts.get("iron") - 1);
            resourceCounts.put("wood", resourceCounts.get("wood") - 1);
            resourceCounts.put("food", resourceCounts.get("food") - 1);
            resourceCounts.put("stone", resourceCounts.get("stone") - 1);
            attackStrength -= 50;
            defenseStrength -= 40;
            economyStrength -= 30;
        }
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
    }

    /**
     * colony empty constructor
     *
     */
    public Colony() {
    }

    /**
     * add resources to colony
     *
     * @param colonyName colony name
     */
    public void addResources(String colonyName) {
        resourceCounts = collectResources(colonyName);
    }

    /**
     *
     * @return colony's name
     */

    public String getBotColonyName() {
        try {
            File database = new File("src/main/resources/colonyNamesDatabase.txt");
            Scanner scanner = new Scanner(database);

            ArrayList<String> colonyNames = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String colonyName = scanner.nextLine();
                colonyNames.add(colonyName);
            }
            Random random = new Random();
            name = colonyNames.get(random.nextInt(colonyNames.size()));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie zostal odnaleziony.");
            e.printStackTrace();
            name = "BotColony";
        }
        return name;
    }

    /**
     *
     * @return new colony's data
     */
    public Colony getColony() {

        pointsToSpend = 100;
        populationPointsToSpend = 100;
        Random random = new Random();
        name = getBotColonyName();
        attackStrength = random.nextInt(pointsToSpend);
        pointsToSpend -= attackStrength;
        defenseStrength = random.nextInt(pointsToSpend);
        pointsToSpend -= defenseStrength;
        economyStrength = pointsToSpend;
        population = random.nextInt(populationPointsToSpend);
        populationPointsToSpend -= population;
        armySize = populationPointsToSpend;

        Colony colony = new Colony(name, attackStrength, defenseStrength, economyStrength, population, armySize);
        return colony;
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
