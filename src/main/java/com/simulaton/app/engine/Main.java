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

        InitializeSimulation initSimulation = new InitializeSimulation();
        Simulation simulation = new Simulation();

        simulation.setCurrentSimulationState(initSimulation.initializeSimulationObjects());
        simulation.runSimulation();


    }
}