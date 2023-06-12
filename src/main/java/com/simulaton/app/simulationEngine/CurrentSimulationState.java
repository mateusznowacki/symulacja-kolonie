package com.simulaton.app.simulationEngine;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.NPosition;
import com.simulaton.app.map.NResources;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrentSimulationState {

    private HashMap<NPosition, Colony> positionsMap;
    private HashMap<NPosition, NResources> resourcesMap;
    private ArrayList<Colony> colonies;
    public ArrayList<Colony> getColonies() {
        return colonies;
    }

    public void updateColonies(ArrayList<Colony> colonies) {
        this.colonies = colonies;
    }

    public CurrentSimulationState(HashMap<NPosition, Colony> positionsMap, HashMap<NPosition, NResources> resourcesMap, ArrayList<Colony> colonies) {
        this.positionsMap = positionsMap;
        this.resourcesMap = resourcesMap;
        this.colonies = colonies;
    }

    public HashMap<NPosition, Colony> getPositionsMap() {
        return positionsMap;
    }

    public void setPositionsMap(HashMap<NPosition, Colony> positionsMap) {
        this.positionsMap = positionsMap;
    }

    public HashMap<NPosition, NResources> getResourcesMap() {
        return resourcesMap;
    }

    public void setResourcesMap(HashMap<NPosition, NResources> resourcesMap) {
        this.resourcesMap = resourcesMap;
    }


}
