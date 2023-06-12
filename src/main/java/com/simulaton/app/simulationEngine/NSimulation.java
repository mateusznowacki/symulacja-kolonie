package com.simulaton.app.simulationEngine;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.colony.NColonyFactory;
import com.simulaton.app.map.*;

import java.util.ArrayList;
import java.util.Scanner;

public class NSimulation implements NSetSimulationParameters {

    private int mapSize = 10;
    private int numberOfColonies = 3;

    public void initializeSimulationObjects() {
// lista pozycji
        NPositionFactory factory = new NPositionFactory();
        ArrayList<NPosition> positions = factory.createPositions(10);

        // surowce z przypisaniem
        NResourcesMap nResourcesMap = new NResourcesMap();
        nResourcesMap.distributeResourcesRandomly(mapSize, positions);

        // tworzenie kolonii z przypisaniem

        NColonyFactory nColonyFactory = new NColonyFactory();
        ArrayList<Colony> colonies = new ArrayList<>();
        for (int i = 0; i < numberOfColonies; i++) {
            colonies.add(nColonyFactory.createColony());
        }
        RandomPositionAssinger positionAssinger = new RandomPositionAssinger();
        positionAssinger.distributePositionsRandomly(mapSize, positions, colonies);
// przekazanie do klasy ktora zarzadza obecnym stanem symulacji
        CurrentSimulationState currentSimulationState = new CurrentSimulationState(positionAssinger.getPositionsMap(), nResourcesMap.getResourcesMap(),colonies);

        ResourcesManager resourcesManager = new ResourcesManager();

        currentSimulationState.updateColonies(resourcesManager.addResources(currentSimulationState.getResourcesMap(),currentSimulationState.getPositionsMap()));


        System.out.println(currentSimulationState.getColonies().get(1).getResourceCounts() + currentSimulationState.getColonies().get(1).getName());
        System.out.println(currentSimulationState.getColonies().get(2).getResourceCounts()+currentSimulationState.getColonies().get(2).getName());
        System.out.println(currentSimulationState.getColonies().get(3).getResourceCounts()+currentSimulationState.getColonies().get(3).getName());


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
