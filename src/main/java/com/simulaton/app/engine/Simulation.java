package com.simulaton.app.engine;

import com.diogonunes.jcolor.Attribute;
import com.simulaton.app.colony.Colony;

import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * The type Simulation.
 */
public class Simulation {

    /**
     * The Current simulation state.
     */
    private CurrentSimulationState currentSimulationState;
    private int numberOfIterations;

    /**
     * Sets current simulation state.
     *
     * @param currentSimulationState the current simulation state
     */
    public void setCurrentSimulationState(CurrentSimulationState currentSimulationState) {
        this.currentSimulationState = currentSimulationState;
    }


    /**
     * Run simulation.
     */
    public void runSimulation() {

        ColonyBattle colonyBattle = new ColonyBattle();
        numberOfIterations = currentSimulationState.getNumberOfIterations();

        for (int i = 0; i < numberOfIterations; i++) {
            currentSimulationState = colonyBattle.colonyBattle(currentSimulationState);
        }
        printSimulationResults(currentSimulationState, numberOfIterations);
     //   System.out.println(currentSimulationState.getNumberOfIterations());
    }

    /**
     * Print simulation results.
     *
     * @param currentState       the current state
     * @param numberOfIterations the number of iterations
     */
    public void printSimulationResults(CurrentSimulationState currentState, int numberOfIterations) {
        Colony winnerColony = null;
        int battleWins = 0;

        for (Colony colony : currentState.getColonies()) {
            if (colony.getBattleWins() > battleWins) {
                battleWins = colony.getBattleWins();
                winnerColony = colony;
            }
        }
        System.out.println("\n\nSymulacje wygrala kolonia " + colorize(winnerColony.getName(), Attribute.TEXT_COLOR(90, 225, 22))
                + " wygrywajac razem " + colorize(String.valueOf(winnerColony.getBattleWins()), Attribute.TEXT_COLOR(90, 225, 22)) + " bitw z " +
                colorize(String.valueOf(numberOfIterations), Attribute.TEXT_COLOR(90, 225, 22)));
    }


}
