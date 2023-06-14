package com.simulaton.app.engine;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.initializeSimulationObjects();
        simulation.runSimulation();

    }
}