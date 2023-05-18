package com.simulaton;

public class Simulation {

    public void runSimulation() {
        GetColony userColony = new GetColony();
        //userColony.getUserColonyData();
        Map mapa = new Map();

        System.out.println(mapa.getResourceAmount(1,1));

    }
}
