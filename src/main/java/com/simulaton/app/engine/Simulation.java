package com.simulaton.app.engine;

import com.diogonunes.jcolor.Attribute;
import com.simulaton.app.colony.Colony;
import com.simulaton.app.colony.ColonyFactory;
import com.simulaton.app.map.position.Position;
import com.simulaton.app.map.position.PositionFactory;
import com.simulaton.app.map.position.RandomPositionAssinger;
import com.simulaton.app.map.resources.ResourcesManager;
import com.simulaton.app.map.resources.ResourcesMap;

import java.util.ArrayList;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Simulation implements SetSimulationParameters {
    CurrentSimulationState currentSimulationState = new CurrentSimulationState();
    private int mapSize;
    private int numberOfColonies;
    private int numberOfIterations;

    public void initializeSimulationObjects() {

        mapSize = setMapSize();
        numberOfColonies = setNumberOfColonies();
        numberOfIterations = setNumberOfIterations();

        // lista pozycji
        PositionFactory factory = new PositionFactory();
        ArrayList<Position> positions = factory.createPositions(mapSize);
        currentSimulationState.setPositions(positions);

        // surowce z przypisaniem
        ResourcesMap resourcesMap = new ResourcesMap();
        resourcesMap.distributeResourcesRandomly(mapSize, currentSimulationState.getPositions());
        currentSimulationState.setResourcesMap(resourcesMap.getResourcesMap());

        // tworzenie kolonii
        ColonyFactory colonyFactory = new ColonyFactory();
        currentSimulationState.setColonies(colonyFactory.createColony(numberOfColonies));

        // przypisanie pozycji
        RandomPositionAssinger positionAssinger = new RandomPositionAssinger();
        positionAssinger.distributePositionsRandomly(mapSize, currentSimulationState.getPositions(), currentSimulationState.getColonies());
        currentSimulationState.setPositionsMap(positionAssinger.getPositionsMap());

// collectiong resources

        ResourcesManager resourcesManager = new ResourcesManager();
        resourcesManager.addResources(currentSimulationState.getResourcesMap(), currentSimulationState.getPositionsMap());
        currentSimulationState.setColonies(resourcesManager.getUpdatedColonies());

    }

    public void runSimulation() {
        ColonyBattle colonyBattle = new ColonyBattle();
        for (int i = 0; i < numberOfIterations; i++) {
            currentSimulationState = colonyBattle.colonyBattle(currentSimulationState.getPositionsMap(), currentSimulationState.getColonies());
        }
        printSimulationResults(currentSimulationState, numberOfIterations);
    }

    public void printSimulationResults(CurrentSimulationState currentState, int numberOfIterations) {
        Colony winnerColony = null;
        int battleWins = 0;

        for (Colony colony : currentState.getColonies()) {
            if (colony.getBattleWins() > battleWins) {
                battleWins = colony.getBattleWins();
                winnerColony = colony;
            }
        }

        System.out.println("\n\nSymulacje wygrala kolonia " + colorize(winnerColony.getName(), Attribute.TEXT_COLOR(90, 225, 22))
                + " wygrywajac razem " + colorize(String.valueOf(winnerColony.getBattleWins()), Attribute.TEXT_COLOR(90, 225, 22)) + " bitw z " +
                colorize(String.valueOf(numberOfIterations), Attribute.TEXT_COLOR(90, 225, 22)));
    }


    @Override
    public int setMapSize() {
        Scanner scanner = new Scanner(System.in);
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

    @Override
    public int setNumberOfColonies() {
        Scanner scanner = new Scanner(System.in);
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

    @Override
    public int setNumberOfIterations() {
        Scanner scanner = new Scanner(System.in);
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
