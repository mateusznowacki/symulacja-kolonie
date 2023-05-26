package com.simulaton;

public class Simulation {
    private Colony userColony;
    private Colony botColony1;
    private Colony botColony2;
    private ResourcesMap resourcesMap;
    private FileManager fileManager;
    private Resources resources;
    private Position position;

    public void runSimulation() {
        resourcesMap = new ResourcesMap();
        resources = new Resources();
        resourcesMap.setMapSize();
        fileManager = new FileManager();
        fileManager.initializePosionDatabse(resourcesMap.getSize());
        fileManager.initializeMapDatabse(resourcesMap.getSize(), resources.getResourceType());
        userColony = new Colony();
        userColony.getUserColonyData();
        botColony1 = new Colony();
        botColony1.getBotColony();
        botColony2 = new Colony();
        botColony2.getBotColony();
        position = new Position();

        position.drawColonyPosition(resourcesMap.getSize(), userColony.getName(),botColony1.getName(),botColony2.getName());
        userColony.addResources(userColony.getName());
        botColony1.addResources(botColony1.getName());
        botColony2.addResources(botColony2.getName());
        //System.out.println( userColony.getResources());

    }

}
