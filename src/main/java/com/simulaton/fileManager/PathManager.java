package com.simulaton.fileManager;

/**
 * Class is responsible for managing paths to files
 */
public abstract class PathManager {
    /**
     * Get position db path
     *
     * @return positionDatabase path
     */
    public static String getPositionDBPath(){
        return "src/main/resources/positionDatabase.txt";
    }

    /**
     * Get resources db path
     *
     * @return resourcesDatabase path
     */
    public static String getResourcesDBPath(){
        return "src/main/resources/resourcesDatabase.txt";
    }

    /**
     * Get colony names db path 
     *
     * @return colonyNamesDatabase path
     */
    public static String getColonyNamesDBPath(){
        return "src/main/resources/colonyNamesDatabase.txt";
    }

}
