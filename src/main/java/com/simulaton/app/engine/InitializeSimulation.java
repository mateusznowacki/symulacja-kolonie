package com.simulaton.app.engine;

import com.simulaton.app.colony.ColonyFactory;
import com.simulaton.app.map.position.Position;
import com.simulaton.app.map.position.PositionFactory;
import com.simulaton.app.map.position.RandomPositionAssinger;
import com.simulaton.app.map.resources.ResourcesManager;
import com.simulaton.app.map.resources.ResourcesMap;

import java.util.ArrayList;
import java.util.Scanner;

public class InitializeSimulation {

    /**
     * Initialize simulation objects.
     */
    public CurrentSimulationState initializeSimulationObjects() {
        CurrentSimulationState currentSimulationState = new CurrentSimulationState();

        currentSimulationState.setMapSize(chooseMapSize());
        currentSimulationState.setNumberOfColonies(chooseNumberOfColonies());
        currentSimulationState.setNumberOfIterations(chooseNumberOfIterations());

        PositionFactory factory = new PositionFactory();
        ArrayList<Position> positions = factory.createPositions(currentSimulationState.getMapSize());
        currentSimulationState.setPositions(positions);

        ResourcesMap resourcesMap = new ResourcesMap();
        resourcesMap.distributeResourcesRandomly(currentSimulationState.getMapSize(), currentSimulationState.getPositions());
        currentSimulationState.setResourcesMap(resourcesMap.getResourcesMap());

        ColonyFactory colonyFactory = new ColonyFactory();
        currentSimulationState.setColonies(colonyFactory.createColony(currentSimulationState.getNumberOfColonies()));

        RandomPositionAssinger positionAssinger = new RandomPositionAssinger();
        positionAssinger.distributePositionsRandomly(currentSimulationState.getMapSize(), currentSimulationState.getPositions(), currentSimulationState.getColonies());
        currentSimulationState.setPositionsMap(positionAssinger.getPositionsMap());

        ResourcesManager resourcesManager = new ResourcesManager();
        resourcesManager.addResources(currentSimulationState.getResourcesMap(), currentSimulationState.getPositionsMap());
        currentSimulationState.setColonies(resourcesManager.getUpdatedColonies());

        return currentSimulationState;
    }

    private int chooseMapSize() {
        Scanner scanner = new Scanner(System.in);
        int mapSize = 10;
        boolean uncorrectSize = true;
        while (uncorrectSize) {
            System.out.println("Podaj rozmiar mapy od 10 do 15: ");
            mapSize = scanner.nextInt();
            if ((mapSize > 9) && (mapSize < 16)) {
                uncorrectSize = false;
            } else {
                System.out.println("Podano nieprawidlowy rozmiar mapy!");
            }
        }
        return mapSize;
    }

    private int chooseNumberOfColonies() {
        Scanner scanner = new Scanner(System.in);
        int numberOfColonies = 10;
        boolean uncorrectSize = true;
        while (uncorrectSize) {
            System.out.println("Wybierz liczbe kolonii w symulacji od 2 do 10:");
            numberOfColonies = scanner.nextInt();
            if ((numberOfColonies > 1) && (numberOfColonies < 11)) {
                uncorrectSize = false;
            } else {
                System.out.println("Podano nieprawidlowa ilosc!");
            }
        }
        return numberOfColonies;
    }

    private int chooseNumberOfIterations() {
        Scanner scanner = new Scanner(System.in);
        int numberOfIterations = 10;
        boolean uncorrectSize = true;
        while (uncorrectSize) {
            System.out.println("Wybierz liczbe iteracji w symulacji od 100 do 5000 :");
            numberOfIterations = scanner.nextInt();
            if ((numberOfIterations > 99) && (numberOfIterations < 5001)) {
                uncorrectSize = false;
            } else {
                System.out.println("Podano nieprawidlowa ilosc!");
            }
        }
        return numberOfIterations;
    }
}
