package com.simulaton.app.simulationEngine;

import com.simulaton.app.map.Position;
import com.simulaton.app.map.Resources;
import com.simulaton.app.map.ResourcesMap;
import com.simulaton.fileManager.FileManager;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import static com.simulaton.fileManager.FileManager.findColonyByName;

/**
 * Class responsible for colonies battle
 */
public class Simulation {

    private Colony firstColony;
    private Colony secondColony;
    private Colony thirdColony;
    private ResourcesMap resourcesMap;
    private FileManager fileManager;
    private Resources resources;
    private Position position;

    /**
     * runs simulation
     */
    public void runSimulation() {
        resourcesMap = new ResourcesMap();
        resources = new Resources();
        resourcesMap.setMapSize();

        fileManager = new FileManager();
        fileManager.initializePosionDatabse(resourcesMap.getSize());
        fileManager.initializeMapDatabse(resourcesMap.getSize(), resources.getResourceType());

        Colony instanceColony = new Colony();
        Colony firstColony = instanceColony.getColony();
        Colony secondColony = instanceColony.getColony();
        Colony thirdColony = instanceColony.getColony();

        System.out.println(colorize("Pierwsza kolonia to: " + firstColony.getName(),BLUE_TEXT()));
        System.out.println(colorize("Druga kolonia to: " + secondColony.getName(),GREEN_TEXT()));
        System.out.println(colorize("Trzecia kolonia to: " + thirdColony.getName(),RED_TEXT()));

        position = new Position();
        position.drawColonyPosition(resourcesMap.getSize(), firstColony.getName(), secondColony.getName(), thirdColony.getName());

        firstColony.addResources(firstColony.getName());
        secondColony.addResources(secondColony.getName());
        thirdColony.addResources(thirdColony.getName());

        do {
            colonyBattle(firstColony, secondColony, thirdColony);
            colonyBattle(secondColony, firstColony, thirdColony);
            colonyBattle(thirdColony, secondColony, firstColony);
        } while (firstColony.getNumOccupiedPositions() < Math.pow(resourcesMap.getSize(), 2) &&
                secondColony.getNumOccupiedPositions() < Math.pow(resourcesMap.getSize(), 2) &&
                thirdColony.getNumOccupiedPositions() < Math.pow(resourcesMap.getSize(), 2)
        );

        System.out.println(colorize("\nKoniec gry",BLUE_TEXT()));
        System.out.println(colorize(printReults(firstColony, secondColony, thirdColony),BLUE_TEXT()));
    }

    /**
     * Print battle result
     *
     * @param firstColony  the first colony
     * @param secondColony the second colony
     * @param thirdColony  the third colony
     * @return battle result
     */
    public String printReults(Colony firstColony, Colony secondColony, Colony thirdColony) {
        if (firstColony.getNumOccupiedPositions() > secondColony.getNumOccupiedPositions() &&
                firstColony.getNumOccupiedPositions() > thirdColony.getNumOccupiedPositions()) {
            return "Wygrala kolonia pierwsza " + firstColony.getName() + " pierwsza wygrywajac " + (int) Math.pow(resourcesMap.getSize(), 2) + " bitew";
        } else if (secondColony.getNumOccupiedPositions() > firstColony.getNumOccupiedPositions() &&
                secondColony.getNumOccupiedPositions() > thirdColony.getNumOccupiedPositions()) {
            return "Wygrala kolonia druga " + secondColony.getName() + " pierwsza wygrywajac " + (int) Math.pow(resourcesMap.getSize(), 2) + " bitew";
        } else if (thirdColony.getNumOccupiedPositions() > firstColony.getNumOccupiedPositions() &&
                thirdColony.getNumOccupiedPositions() > secondColony.getNumOccupiedPositions()) {
            return "Wygrala kolonia trzecia " + thirdColony.getName() + " pierwsza wygrywajac " + (int) Math.pow(resourcesMap.getSize(), 2) + " bitew";
        }
        return "Remis";
    }

    /**
     * launches a colony battle
     *
     * @param attackingColony   attacking colony
     * @param defendingColony1  defending colony 1
     * @param defendingColony2  defending colony 2
     */
    public void colonyBattle(Colony attackingColony, Colony defendingColony1, Colony defendingColony2) {

        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;
        Random random = new Random();
        Colony defendingColony = random.nextBoolean() ? defendingColony1 : defendingColony2;
        String attackingColonyPosition = findColonyByName(attackingColony.getName());
        String defendingColonyPosition = findColonyByName(defendingColony.getName());

        if (attackingColonyPosition != "null" && defendingColonyPosition != "null") {
            // attack
            if ((attackingColony.getArmySize() * attackingColony.getAttackStrength()) > (defendingColony.getArmySize() * defendingColony.getDefenseStrength())) {
                attackingColonyPoints += 1;
            } else {
                defendingColonyPoints += 1;
            }
            //defence
            if ((attackingColony.getArmySize() * attackingColony.getDefenseStrength()) > (defendingColony.getArmySize() * defendingColony.getAttackStrength())) {
                attackingColonyPoints += 1;
            } else {
                defendingColonyPoints += 1;
            }
            //economy
            if ((attackingColony.getEconomyStrength() * attackingColony.getPopulation()) > (defendingColony.getEconomyStrength() * defendingColony.getPopulation())) {
                attackingColonyPoints += 1;
            } else {
                defendingColonyPoints += 1;
            }
            if (attackingColonyPoints >= defendingColonyPoints) {
                System.out.println("Kolonia " + colorize(attackingColony.getName(),GREEN_TEXT()) + " wygrala i zajela pozycje " + attackingColonyPosition);
                String[] parts = attackingColonyPosition.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                fileManager.saveColonyPosition(attackingColony.getName(), x, y);
                attackingColony.manageResources(true);
                defendingColony.manageResources(false);
                attackingColony.setNumOccupiedPositions(1);
            } else {
                System.out.println("Kolonia " + colorize(defendingColony.getName(),GREEN_TEXT()) + " wygrala i zajela pozycje " + defendingColonyPosition);
                String[] parts = defendingColonyPosition.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                fileManager.saveColonyPosition(defendingColony.getName(), x, y);
                defendingColony.manageResources(true);
                attackingColony.manageResources(false);
                defendingColony.setNumOccupiedPositions(1);
            }
        }
    }
}
