package com.simulaton.app.map.resources;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.position.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.simulaton.app.map.resources.ResourceTypes.*;

/**
 * The type Resources manager.
 */
public class ResourcesManager {
    /**
     * The Updated colonies.
     */
    private ArrayList<Colony> updatedColonies = new ArrayList<>();

    /**
     * Gets updated colonies.
     *
     * @return the updated colonies
     */
    public ArrayList<Colony> getUpdatedColonies() {
        return updatedColonies;
    }

    /**
     * Add resources array list.
     *
     * @param resourcesMap the resources map
     * @param positionsMap the positions map
     * @return the array list
     */
    public ArrayList<Colony> addResources(HashMap<Position, ResourceTypes> resourcesMap, HashMap<Position, Colony> positionsMap) {

        for (Map.Entry<Position, ResourceTypes> resourceEntry : resourcesMap.entrySet()) {
            Position resourcePosition = resourceEntry.getKey();
            if (positionsMap.containsKey(resourcePosition)) {
                Colony colony = positionsMap.get(resourcePosition);
                ResourceTypes resource = resourcesMap.get(resourcePosition);
                int resourceCount;
                switch (resource) {
                    case FOOD, IRON -> resourceCount = 5;
                    case STONE, WOOD -> resourceCount = 10;
                    default -> resourceCount = 5;
                }
                Integer currentCount = colony.getResourceCounts().get(resource);
                if (currentCount != null) {
                    int currentResourceCount = currentCount.intValue();
                    resourceCount += currentResourceCount;
                }
                colony.getResourceCounts().put(resource, resourceCount);
                updatedColonies.add(colony);
            }
        }
        return updatedColonies;
    }

    /**
     * Recive resources array list.
     *
     * @param colonies the colonies
     * @param colony   the colony
     * @return the array list
     */
    public static ArrayList<Colony> reciveResources(ArrayList<Colony> colonies, Colony colony) {
        for (int i = 0; i < colonies.size(); i++) {
            if (colonies.get(i).getName().equals(colony.getName())) {
                HashMap<ResourceTypes, Integer> resourceCounts = colonies.get(i).getResourceCounts();
                Integer woodCount = resourceCounts.get(WOOD);
                Integer foodCount = resourceCounts.get(FOOD);
                Integer ironCount = resourceCounts.get(IRON);
                Integer stoneCount = resourceCounts.get(STONE);

                if (woodCount != null) {
                    resourceCounts.put(WOOD, woodCount + 10);
                }
                if (foodCount != null) {
                    resourceCounts.put(FOOD, foodCount + 5);
                }
                if (ironCount != null) {
                    resourceCounts.put(IRON, ironCount + 5);
                }
                if (stoneCount != null) {
                    resourceCounts.put(STONE, stoneCount + 10);
                }
            }
        }
        return colonies;
    }

    /**
     * Spend resources array list.
     *
     * @param colonies the colonies
     * @param colony   the colony
     * @return the array list
     */
    public static ArrayList<Colony> spendResources(ArrayList<Colony> colonies, Colony colony) {
        for (int i = 0; i < colonies.size(); i++) {
            if (colonies.get(i).getName().equals(colony.getName())) {
                HashMap<ResourceTypes, Integer> resourceCounts = colonies.get(i).getResourceCounts();
                Integer woodCount = resourceCounts.get(WOOD);
                Integer stoneCount = resourceCounts.get(STONE);
                Integer foodCount = resourceCounts.get(FOOD);
                Integer ironCount = resourceCounts.get(IRON);

                if (woodCount != null) {
                    resourceCounts.put(WOOD, woodCount - 10);
                }

                if (stoneCount != null) {
                    resourceCounts.put(STONE, stoneCount - 10);
                }

                if (foodCount != null) {
                    resourceCounts.put(FOOD, foodCount - 5);
                }

                if (ironCount != null) {
                    resourceCounts.put(IRON, ironCount - 5);
                }
            }
        }
        return colonies;
    }

}
