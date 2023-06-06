package com.simulaton.fileManager;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;


public class FileManager {
    /**
     *
     * @param newColonyName
     * @param x
     * @param y
     */

    public void saveColonyPosition(String newColonyName, int x, int y) {
        File file = new File("src/main/resources/positionDatabase.txt");
        try {
            RandomAccessFile pointer = new RandomAccessFile(file, "rw");
            String line;
            StringBuilder updatedContent = new StringBuilder();

            while ((line = pointer.readLine()) != null) {
                String[] parts = line.split(",");
                int currentX = Integer.parseInt(parts[0]);
                int currentY = Integer.parseInt(parts[1]);

                if (currentX == x && currentY == y) {
                    // Znaleziono pasujący wpis, usuń go
                    continue;
                }
                updatedContent.append(line).append(System.lineSeparator());
            }

            updatedContent.append(x).append(",").append(y).append(",").append(newColonyName);
            pointer.seek(0);
            pointer.setLength(0);
            pointer.writeBytes(updatedContent.toString());
            pointer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param colonyName
     * @return
     */

    public static Map<String, Integer> collectResources(String colonyName) {
        String resourceDatabase = "src/main/resources/resourcesDatabase.txt";
        String positionDatabase = "src/main/resources/positionDatabase.txt";
        Map<String, Integer> resourceCounts = new HashMap<>();
        Map<String, String> positionMap = getPositionMap(positionDatabase);

        try (BufferedReader reader = new BufferedReader(new FileReader(resourceDatabase))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    String resourceType = parts[2];
                    int amount = Integer.parseInt(parts[3]);
                    String currentColonyName = positionMap.get(x + "," + y);
                    if (currentColonyName != null && currentColonyName.equals(colonyName)) {
                        String key = resourceType;
                        int currentCount = resourceCounts.getOrDefault(key, 0);
                        resourceCounts.put(key, currentCount + amount);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resourceCounts;
    }

    /**
     *
     * @return
     */
    public static boolean containOtherColonies() {
        HashSet<String> colonyNames = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/positionDatabase.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String colonyName = parts[2].trim();
                    colonyNames.add(colonyName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return colonyNames.size() > 1;
    }

    /**
     *
     * @param positionDatabase
     * @return
     */

    public static Map<String, String> getPositionMap(String positionDatabase) {
        Map<String, String> positionMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(positionDatabase))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    String colonyName = parts[2];
                    positionMap.put(x + "," + y, colonyName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return positionMap;
    }

    /**
     *
     * @param colonyName
     * @return
     */

    public static String findColonyByName(String colonyName) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/positionDatabase.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] colonyData = line.split(",");
                String name = colonyData[2].trim();

                if (name.equalsIgnoreCase(colonyName)) {
                    String position = colonyData[0] + "," + colonyData[1];
                    return position;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "null";
    }

    /**
     *
     * @param size
     */

    public void initializePosionDatabse(int size) {
        String line;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/positionDatabase.txt", false))) {
            writer.write(""); //clears file
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    line = x + "," + y + ",free";
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd: Plik nie został odnaleziony.");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param size
     * @param resourceType
     */

    public void initializeMapDatabse(int size, String[] resourceType) {
        String line;
        Random random = new Random();
        int maxAmount = 15;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/resourcesDatabase.txt", false))) {
            writer.write(""); //clears file
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    String randomResource = resourceType[random.nextInt(resourceType.length)];
                    line = x + "," + y + "," + randomResource + "," + random.nextInt(maxAmount);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd: Plik nie został odnaleziony.");
            e.printStackTrace();
        }
    }
}
