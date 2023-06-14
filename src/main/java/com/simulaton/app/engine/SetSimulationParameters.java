package com.simulaton.app.engine;


/**
 * Sets simulation parameters.
 */
public interface SetSimulationParameters {

    /**
     * Sets map size.
     *
     * @return the map size
     */
    int setMapSize();

    /**
     * Sets number of colonies.
     *
     * @return the number of colonies
     */
    int setNumberOfColonies();

    /**
     * Sets number of iterations.
     *
     * @return the number of iterations
     */
    int setNumberOfIterations();


}
