package com.simulaton.app.engine;

/**
 * Main class
 */
public class Main {
    /**
     * @param args starting arguments
     * initializes simulation objects and runs the simulation
     */
    public static void main(String[] args) {


        Simulation simulation = new Simulation();
        simulation.initializeSimulationObjects();
        simulation.runSimulation();

    }
}