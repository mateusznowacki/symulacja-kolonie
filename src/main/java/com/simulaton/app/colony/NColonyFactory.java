package com.simulaton.app.colony;

import java.util.Map;
import java.util.Random;

import static com.simulaton.fileManager.FileManager.getBotColonyName;

public class NColonyFactory {
    public Colony createColony() {
         String name;
         int attackStrength;
         int defenseStrength;
         int economyStrength;
         int population;
         int armySize;
//         final int checkPoint = 0;
         int pointsToSpend;
         int populationPointsToSpend;
//         Map<String, Integer> resourceCounts;
//         int numOccupiedPositions = 0;

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
