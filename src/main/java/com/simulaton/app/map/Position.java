package com.simulaton.app.map;

import com.simulaton.fileManager.FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Position {
    FileManager fileManager = new FileManager();
    public void drawColonyPosition(int size, String firstColony,String secondColony,String thirdColony) {

        Random random = new Random();
        for (int i = 0; i < (((size*size/3) + (size*size%3))); i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            while (isPositionFree(x, y) == false) {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            fileManager.saveColonyPosition(firstColony, x, y);
        }
        for (int i = 0; i < ((size*size/3)); i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            while (isPositionFree(x, y) == false) {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            fileManager.saveColonyPosition(secondColony, x, y);
        } for (int i = 0; i < ((size*size/3)); i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            while (isPositionFree(x, y) == false) {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            fileManager.saveColonyPosition(thirdColony, x, y);
        }
    }

       public boolean isPositionFree(int x, int y) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/positionDatabase.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int posX = Integer.parseInt(parts[0]);
                int posY = Integer.parseInt(parts[1]);
                if (posX == x && posY == y) {
                    String colony = parts[2];
                    return colony.equals("free");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}