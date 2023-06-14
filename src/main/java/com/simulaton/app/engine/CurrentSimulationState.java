package com.simulaton.app.engine;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.position.Position;
import com.simulaton.app.map.resources.ResourceTypes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Current simulation state.
 */
public class CurrentSimulationState {

    private HashMap<Position, Colony> positionsMap;
    private HashMap<Position, ResourceTypes> resourcesMap;
    private ArrayList<Colony> colonies;
    private ArrayList<Position> positions;

    /**
     * Gets positions.
     *
     * @return the positions
     */
    public ArrayList<Position> getPositions() {
        return positions;
    }

    /**
     * Sets positions.
     *
     * @param positions the positions
     */
    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    /**
     * Instantiates a new Current simulation state.
     */
    public CurrentSimulationState() {
    }

    /**
     * Gets colonies.
     *
     * @return the colonies
     */
    public ArrayList<Colony> getColonies() {
        return colonies;
    }

    /**
     * Sets colonies.
     *
     * @param colonies the colonies
     */
    public void setColonies(ArrayList<Colony> colonies) {
        this.colonies = colonies;
    }

    /**
     * Instantiates a new Current simulation state.
     *
     * @param positionsMap the positions map
     * @param resourcesMap the resources map
     * @param colonies     the colonies
     */
    public CurrentSimulationState(HashMap<Position, Colony> positionsMap, HashMap<Position, ResourceTypes> resourcesMap, ArrayList<Colony> colonies) {
        this.positionsMap = positionsMap;
        this.resourcesMap = resourcesMap;
        this.colonies = colonies;
    }

    /**
     * Gets positions map.
     *
     * @return the positions map
     */
    public HashMap<Position, Colony> getPositionsMap() {
        return positionsMap;
    }

    /**
     * Sets positions map.
     *
     * @param positionsMap the positions map
     */
    public void setPositionsMap(HashMap<Position, Colony> positionsMap) {
        this.positionsMap = positionsMap;
    }

    /**
     * Gets resources map.
     *
     * @return the resources map
     */
    public HashMap<Position, ResourceTypes> getResourcesMap() {
        return resourcesMap;
    }

    /**
     * Sets resources map.
     *
     * @param resourcesMap the resources map
     */
    public void setResourcesMap(HashMap<Position, ResourceTypes> resourcesMap) {
        this.resourcesMap = resourcesMap;
    }


}
