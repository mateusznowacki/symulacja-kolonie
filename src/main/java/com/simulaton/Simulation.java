package com.simulaton;

public class Simulation {

    public void runSimulation() {
        GetColony userColony = new GetColony();
        userColony.getUserColonyData();
        Map map = new Map();
        map.setMapSize();

    }
}
