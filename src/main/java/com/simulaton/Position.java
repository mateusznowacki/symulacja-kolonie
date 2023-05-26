package com.simulaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Position {
    FileManager fileManager = new FileManager();
    public void drawColonyPosition(int size, String newColonyName,String bot1ColonyName,String bot2ColonyName) {
        // FileManager fileManager = new FileManager();
        Random random = new Random();
        for (int i = 0; i < (((size*size/3) + (size*size%3))); i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            while (isPositionFree(x, y) == false) {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            fileManager.saveColonyPosition(newColonyName, x, y);
        }
        for (int i = 0; i < ((size*size/3)); i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            while (isPositionFree(x, y) == false) {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            fileManager.saveColonyPosition(bot1ColonyName, x, y);
        } for (int i = 0; i < ((size*size/3)); i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            while (isPositionFree(x, y) == false) {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            fileManager.saveColonyPosition(bot2ColonyName, x, y);
        }
    }

    public void changeAlreadyTakenPosition(String newColonyName, int x, int y) {
        // FileManager fileManager = new FileManager();
        fileManager.saveColonyPosition(newColonyName, x, y);
    }


//    public boolean isAnyFreePositions() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/simulaton/positionDatabase.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length >= 3) {
//                    String colony = parts[2].trim();
//                    if (colony.isEmpty()) {
//                        return true; // Znaleziono wolną pozycję
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false; // Brak dostępnych wolnych pozycji
//    }

    public boolean isPositionFree(int x, int y) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/simulaton/positionDatabase.txt"))) {
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