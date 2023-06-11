package com.simulaton.app.map;


import java.util.ArrayList;

public class NPositionFactory {
    public ArrayList<NPosition> createPositions(int mapSize) {
        ArrayList<NPosition> positions = new ArrayList<>();

        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                NPosition position = new NPosition(x, y);
                positions.add(position);
            }
        }
        return positions;
    }
}
