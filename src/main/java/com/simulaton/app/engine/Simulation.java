package com.simulaton.app.engine;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.colony.ColonyFactory;
import com.simulaton.app.map.position.Position;
import com.simulaton.app.map.position.PositionFactory;
import com.simulaton.app.map.position.RandomPositionAssinger;
import com.simulaton.app.map.resources.ResourcesManager;
import com.simulaton.app.map.resources.ResourcesMap;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation implements SetSimulationParameters {
    CurrentSimulationState currentSimulationState = new CurrentSimulationState();
    private int mapSize = 10;
    private int numberOfColonies = 10;

    public void initializeSimulationObjects() {

        // lista pozycji
        PositionFactory factory = new PositionFactory();
        ArrayList<Position> positions = factory.createPositions(10);
        currentSimulationState.setPositions(positions);

        // surowce z przypisaniem
        ResourcesMap resourcesMap = new ResourcesMap();
        resourcesMap.distributeResourcesRandomly(mapSize, currentSimulationState.getPositions());
        currentSimulationState.setResourcesMap(resourcesMap.getResourcesMap());

        // tworzenie kolonii

        ColonyFactory colonyFactory = new ColonyFactory();
        ArrayList<Colony> colonies = new ArrayList<>();
        for (int i = 0; i < numberOfColonies; i++) {
            colonies.add(colonyFactory.createColony());
        }
        currentSimulationState.setColonies(colonies);
// przypisanie pozycji
        RandomPositionAssinger positionAssinger = new RandomPositionAssinger();
        positionAssinger.distributePositionsRandomly(mapSize,currentSimulationState.getPositions(),currentSimulationState.getColonies());
        currentSimulationState.setPositionsMap(positionAssinger.getPositionsMap());

// collectiong resources

        ResourcesManager resourcesManager = new ResourcesManager();
        resourcesManager.addResources(currentSimulationState.getResourcesMap(),currentSimulationState.getPositionsMap());
        currentSimulationState.setColonies(resourcesManager.getUpdatedColonies());




    }

    public void runSimulation(){
        ColonyBattle colonyBattle = new ColonyBattle();
        for (int i = 0; i < 500; i++) {
            currentSimulationState=colonyBattle.colonyBattle(currentSimulationState.getPositionsMap(),currentSimulationState.getColonies());
        }

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
                System.out.println("Podano nieprawidłowy rozmiar mapy!");
            }
        }
        return mapSize;
    }

    @Override
    public int setNumberOfColonies() {
        Scanner scanner = new Scanner(System.in);
        boolean uncorrectSize = true;
        while (uncorrectSize) {
            System.out.println("Wybierz liczbe kolonii w symulacji od 10 15:");
            numberOfColonies = scanner.nextInt();
            if ((numberOfColonies > 9) && (numberOfColonies < 16)) {
                uncorrectSize = false;
            } else {
                System.out.println("Podanonieprawidlowa ilosc!");
            }
        }
        return numberOfColonies;
    }

    public int getMapSize() {
        return mapSize;
    }

    public int getNumberOfColonies() {
        return numberOfColonies;
    }

}
