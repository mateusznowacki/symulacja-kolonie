package com.simulaton.app.map.position;

import java.util.ArrayList;

/**
 * The type Position factory.
 */
public class PositionFactory {
    /**
     * Create positions array list.
     *
     * @param mapSize the map size
     * @return the array list
     */
    public ArrayList<Position> createPositions(int mapSize) {
        ArrayList<Position> positions = new ArrayList<>();

        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                Position position = new Position(x, y);
                positions.add(position);
            }
        }
        return positions;
    }
}
