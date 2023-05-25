package com.simulaton;

import java.util.Random;

public class Simulation {

    private Colony userColony;
    private Colony botColony1;
    private Colony botColony2;
    private Position position;
    private ColonyMap map;

    public void runSimulation() {
         map = new ColonyMap();
     //   map.setMapSize(); // Ustalenie rozmiaru mapy

         position = new Position();
       // position.fillPosition(); // Wypełnienie pozycji na mapie

         userColony = new Colony();
         botColony1 = new Colony();
         botColony2 = new Colony();

        userColony.getUserColonyData();
        botColony1.getBotColony();
        botColony2.getBotColony();

        drawFirstColonyPosion();
        position.displayOccupiedPositions();


    }

    public void drawFirstColonyPosion() {
        Random random = new Random();
//        for(int i = 0; i < 10; i++) {
//            int x = random.nextInt(10);
//            int y = random.nextInt(10);
//            System.out.println( position.isPositionFree(x, y));
//
//                position.setColonyPosition(x, y, userColony.getName());
//                x = random.nextInt(10);
//                y = random.nextInt(10);
//                position.setColonyPosition(x, y, botColony1.getName());
//            x = random.nextInt(10);
//            y = random.nextInt(10);
//                position.setColonyPosition(x, y, botColony2.getName());
//            }
//        }
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            while (!position.isPositionFree(x, y)) {
                x = random.nextInt(10);
                y = random.nextInt(10);
            }
            if (position.isPositionFree(x, y)) {
                position.setColonyPosition(x, y, userColony.getName());
            }
        }
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            while (!position.isPositionFree(x, y)) {
                x = random.nextInt(10);
                y = random.nextInt(10);
            }
            if (position.isPositionFree(x, y)) {
                position.setColonyPosition(x, y, botColony1.getName());
            }
        }
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            while (!position.isPositionFree(x, y)) {
                x = random.nextInt(10);
                y = random.nextInt(10);
            }
            if (position.isPositionFree(x, y)) {
                position.setColonyPosition(x, y, botColony2.getName());
            }
        }

    }
}
