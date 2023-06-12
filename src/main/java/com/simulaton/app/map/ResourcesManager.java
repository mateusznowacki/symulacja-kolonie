package com.simulaton.app.map;

import com.simulaton.app.colony.Colony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResourcesManager {
    public ArrayList<Colony> addResources(HashMap<NPosition, NResources> resourcesMap, HashMap<NPosition, Colony> positionsMap) {
        ArrayList<Colony> updatedColonies = new ArrayList<>();

        for (Map.Entry<NPosition, NResources> resourceEntry : resourcesMap.entrySet()) {
            NPosition resourcePosition = resourceEntry.getKey();

            if (positionsMap.containsKey(resourcePosition)) {
                Colony colony = positionsMap.get(resourcePosition);
                NResources resource = resourcesMap.get(resourcePosition);
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

}
