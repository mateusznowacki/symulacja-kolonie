package com.simulaton.app.map;

import java.util.Scanner;


public class ResourcesMap implements IMapSize {
    /**
     *
     */

    private  int size;

    public int getSize() {
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public int setMapSize () {
        Scanner scanner = new Scanner(System.in);
        boolean uncorrectSize = true;

        while (uncorrectSize) {
            System.out.println("Podaj rozmiar mapy od 10 do 15: ");
            size = scanner.nextInt();
            if ((size > 9) && (size < 16)) {
                uncorrectSize = false;
            } else {
                System.out.println("Podano nieprawidłowy rozmiar mapy!");
            }
        }
        return size;
    }
}

