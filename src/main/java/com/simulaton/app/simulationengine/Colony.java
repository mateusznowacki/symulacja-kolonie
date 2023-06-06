package com.simulaton.app.simulationengine;

import com.simulaton.fileManager.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static com.simulaton.fileManager.FileManager.collectResources;

public class Colony {
    private String name;
    private int attackStrength;
    private int defenseStrength;
    private int economyStrength;
    private int population;
    private int armySize;
    private int checkPoint = 0;
    private int pointsToSpend;
    private int populationPointsToSpend;
    private Map<String, Integer> resourceCounts;
    private int numOccupiedPositions = 0;

    public int getNumOccupiedPositions() {
        return numOccupiedPositions;
    }
    public void setNumOccupiedPositions(int numOccupiedPositions) {
        this.numOccupiedPositions += numOccupiedPositions;
    }

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

    public Colony(String name, int attackStrength, int defenseStrength, int economyStrength, int population, int armySize) {
        this.name = name;
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.economyStrength = economyStrength;
        this.population = population;
        this.armySize = armySize;

    }

    public Colony() {
    }

    public void addResources(String colonyName) {
        resourceCounts = collectResources(colonyName);
    }

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
            System.out.println("Plik nie został odnaleziony.");
            e.printStackTrace();
            name = "BotColony";
        }
        return name;
    }

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


    public String getName() {
        return name;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public int getDefenseStrength() {
        return defenseStrength;
    }

    public int getEconomyStrength() {
        return economyStrength;
    }

    public int getPopulation() {
        return population;
    }

    public int getArmySize() {
        return armySize;
    }

}
