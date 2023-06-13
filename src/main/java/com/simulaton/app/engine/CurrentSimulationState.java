package com.simulaton.app.engine;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.position.Position;
import com.simulaton.app.map.resources.ResourceTypes;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrentSimulationState {

    private HashMap<Position, Colony> positionsMap;
    private HashMap<Position, ResourceTypes> resourcesMap;
    private ArrayList<Colony> colonies;
    private ArrayList<Position> positions;

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public CurrentSimulationState() {
    }

    public ArrayList<Colony> getColonies() {
        return colonies;
    }

    public void setColonies(ArrayList<Colony> colonies) {
        this.colonies = colonies;
    }

    public CurrentSimulationState(HashMap<Position, Colony> positionsMap, HashMap<Position, ResourceTypes> resourcesMap, ArrayList<Colony> colonies) {
        this.positionsMap = positionsMap;
        this.resourcesMap = resourcesMap;
        this.colonies = colonies;
    }

    public HashMap<Position, Colony> getPositionsMap() {
        return positionsMap;
    }

    public void setPositionsMap(HashMap<Position, Colony> positionsMap) {
        this.positionsMap = positionsMap;
    }

    public HashMap<Position, ResourceTypes> getResourcesMap() {
        return resourcesMap;
    }

    public void setResourcesMap(HashMap<Position, ResourceTypes> resourcesMap) {
        this.resourcesMap = resourcesMap;
    }


}
