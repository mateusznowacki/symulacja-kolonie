package com.simulaton.app.map.resources;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.position.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.simulaton.app.map.resources.ResourceTypes.*;

public class ResourcesManager {
    ArrayList<Colony> updatedColonies = new ArrayList<>();

    public ArrayList<Colony> getUpdatedColonies() {
        return updatedColonies;
    }

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


                System.out.println("Zaktualizowano surowiec w kolonii: " + colony.getName() + " " + resource + ", ilosc: " + resourceCount);
            }
        }

        return updatedColonies;
    }

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
