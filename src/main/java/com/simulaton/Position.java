package com.simulaton;

import java.util.HashMap;
import java.util.Map;

public class Position {

    HashMap<int[], String> mapPosition = new HashMap<>();


    public void setColonyPosition(int x, int y, String colonyName) {
        int[] coordinates = {x, y};
        mapPosition.put(coordinates, colonyName);
    }

    public void fillPosition() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                int[] coordinates = {x, y};
                mapPosition.put(coordinates, "0");
            }
        }
    }

    public void changeAlreadyTakenPosition(int x, int y, String nextColonyName) {
        int[] coordinates = mapPosition.keySet().iterator().next();
        if (coordinates[0] == x && coordinates[1] == y) {
            mapPosition.replace(coordinates, nextColonyName);
        }
    }

    public String getColonyPosition(int x, int y) {
        int[] coordinates = {x, y};
        return mapPosition.get(coordinates);
    }

    public boolean isPositionFree(int x, int y) {
        int[] coordinates = {x, y};
            if (coordinates[0] == x && coordinates[1] == y) {
                String colonyName = mapPosition.get(coordinates);
                if (colonyName.equals("0")) {
                    return true;
                }
            }

        return false;
    }


    public void displayOccupiedPositions() {
        for (Map.Entry<int[], String> entry : mapPosition.entrySet()) {
            int[] coordinates = entry.getKey();
            String colonyName = entry.getValue();
            int x = coordinates[0];
            int y = coordinates[1];
            System.out.println("Position (" + x + ", " + y + ") is occupied by colony: " + colonyName);
        }
    }


}