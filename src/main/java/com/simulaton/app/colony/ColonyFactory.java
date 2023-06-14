package com.simulaton.app.colony;

import java.util.ArrayList;
import java.util.Random;

import static com.simulaton.filereader.FileReader.getBotColonyName;


/**
 * The type Colony factory.
 */
public class ColonyFactory {
    /**
     * Create colony array list.
     *
     * @param numberofColonies the numberof colonies
     * @return the array list
     */
    public ArrayList<Colony> createColony(int numberofColonies) {
        String name;
        int attackStrength;
        int defenseStrength;
        int economyStrength;
        int population;
        int armySize;
        int pointsToSpend;
        int populationPointsToSpend;
        ArrayList<Colony> colonies = new ArrayList<>();

        for (int i = 0; i < numberofColonies; i++) {
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
            colonies.add(colony);
        }
        return colonies;
    }
}
