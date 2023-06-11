package com.simulaton.app.simulationEngine;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.NPosition;
import com.simulaton.app.map.NResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CurrentSimulationState{
    private ArrayList<NPosition> positions;
    private HashMap<NPosition, Colony> positionsMap;
    private HashMap<NPosition, NResources> resourcesMap;

    public CurrentSimulationState(HashMap<NPosition, Colony> positionsMap, HashMap<NPosition, NResources> resourcesMap, ArrayList<NPosition> positions) {
        this.positionsMap = positionsMap;
        this.resourcesMap = resourcesMap;
        this.positions = positions;
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
