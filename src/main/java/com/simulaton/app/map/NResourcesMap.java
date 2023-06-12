package com.simulaton.app.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class NResourcesMap {
    private HashMap<NPosition, NResources> resourcesMap = new HashMap<>();

    public HashMap<NPosition, NResources> distributeResourcesRandomly(int mapSize, ArrayList<NPosition> positions) {
        Random random = new Random();
        NResources[] resources = NResources.values();
        for (int i = 0; i < Math.pow(mapSize, 2); i++) {
            resourcesMap.put(positions.get(i), resources[random.nextInt(resources.length)]);
        }
        return resourcesMap;
    }

    public void setResourcesMap(HashMap<NPosition, NResources> resourcesMap) {
        this.resourcesMap = resourcesMap;
    }

    public HashMap<NPosition, NResources> getResourcesMap() {
        return resourcesMap;
    }

    @Override
    public String toString() {
        return "NResourcesMap{" +
                "resourcesMap=" + resourcesMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NResourcesMap that = (NResourcesMap) o;
        return Objects.equals(resourcesMap, that.resourcesMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourcesMap);
    }
}
