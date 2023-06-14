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
    ArrayList<Colony> updatedColonies = new ArrayList<>();

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

                // Sprawdź, czy surowiec jest już obecny w kolonii
                Integer currentCount = colony.getResourceCounts().get(resource);
                if (currentCount != null) {
                    // Surowiec jest już obecny, pobierz jego aktualną ilość
                    int currentResourceCount = currentCount.intValue();

                    // Dodaj aktualną ilość do nowej ilości surowca
                    resourceCount += currentResourceCount;
                }

                // Aktualizacja surowca i ilości w kolonii
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
                colonies.get(i).getResourceCounts().put(WOOD, colonies.get(i).getResourceCounts().get(WOOD) + 10);
                colonies.get(i).getResourceCounts().put(FOOD, colonies.get(i).getResourceCounts().get(FOOD) + 5);
                colonies.get(i).getResourceCounts().put(IRON, colonies.get(i).getResourceCounts().get(IRON) + 5);
                colonies.get(i).getResourceCounts().put(STONE, colonies.get(i).getResourceCounts().get(STONE) + 10);
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
                colonies.get(i).getResourceCounts().put(WOOD, colonies.get(i).getResourceCounts().get(WOOD) - 10);
                colonies.get(i).getResourceCounts().put(FOOD, colonies.get(i).getResourceCounts().get(FOOD) - 5);
                colonies.get(i).getResourceCounts().put(IRON, colonies.get(i).getResourceCounts().get(IRON) - 5);
                colonies.get(i).getResourceCounts().put(STONE, colonies.get(i).getResourceCounts().get(STONE) - 10);
            }
        }
        return colonies;
    }

}
