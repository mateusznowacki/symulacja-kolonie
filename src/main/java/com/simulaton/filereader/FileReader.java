package com.simulaton.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class responsible for managing files
 */
public class FileReader {

    public static String getBotColonyName() {
        String name;
        try {
            File database = new File("src/main/resources/colonyNamesDatabase.txt");
            Scanner scanner = new Scanner(database);

            ArrayList<String> colonyNames = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String colonyName = scanner.nextLine();
                colonyNames.add(colonyName);
            }
            Random random = new Random();
            name = colonyNames.get(random.nextInt(colonyNames.size()));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie zostal odnaleziony.");
            e.printStackTrace();
            name = "BotColony";
        }
        return name;
    }
}
