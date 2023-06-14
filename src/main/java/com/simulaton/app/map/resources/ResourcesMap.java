package com.simulaton.app.map.resources;

import com.simulaton.app.map.position.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

/**
 * The type Resources map.
 */
public class ResourcesMap {
    private final HashMap<Position, ResourceTypes> resourcesMap = new HashMap<>();

    /**
     * Distribute resources randomly hash map.
     *
     * @param mapSize   the map size
     * @param positions the positions
     * @return the hash map
     */
    public HashMap<Position, ResourceTypes> distributeResourcesRandomly(int mapSize, ArrayList<Position> positions) {
        Random random = new Random();
        ResourceTypes[] resources = ResourceTypes.values();
        for (int i = 0; i < Math.pow(mapSize, 2); i++) {
            resourcesMap.put(positions.get(i), resources[random.nextInt(resources.length)]);
        }
        return resourcesMap;
    }

    /**
     * Gets resources map.
     *
     * @return the resources map
     */
    public HashMap<Position, ResourceTypes> getResourcesMap() {
        return resourcesMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourcesMap that = (ResourcesMap) o;
        return Objects.equals(resourcesMap, that.resourcesMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourcesMap);
    }
}
