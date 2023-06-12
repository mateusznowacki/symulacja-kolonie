package com.simulaton.app.colony;

import java.util.Random;

import static com.simulaton.fileManager.FileManager.getBotColonyName;

public class ColonyFactory {
    public Colony createColony() {
         String name;
         int attackStrength;
         int defenseStrength;
         int economyStrength;
         int population;
         int armySize;
         int pointsToSpend;
         int populationPointsToSpend;

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
}
