package com.simulaton.app.map.position;

import com.simulaton.app.colony.Colony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

/**
 * The type Random position assinger.
 */
public class RandomPositionAssinger {
    private HashMap<Position, Colony> positionsMap = new HashMap<>();

    /**
     * Distribute positions randomly hash map.
     *
     * @param mapSize   the map size
     * @param positions the positions
     * @param colonies  the colonies
     * @return the hash map
     */
    public HashMap<Position, Colony> distributePositionsRandomly(int mapSize, ArrayList<Position> positions, ArrayList<Colony> colonies ) {
        Random random = new Random();
        for (int i = 0; i < Math.pow(mapSize, 2); i++) {
        positionsMap.put(positions.get(i),colonies.get(random.nextInt(colonies.size())));
        }
        return positionsMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomPositionAssinger that = (RandomPositionAssinger) o;
        return Objects.equals(positionsMap, that.positionsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionsMap);
    }

    /**
     * Gets positions map.
     *
     * @return the positions map
     */
    public HashMap<Position, Colony> getPositionsMap() {
        return positionsMap;
    }
}
