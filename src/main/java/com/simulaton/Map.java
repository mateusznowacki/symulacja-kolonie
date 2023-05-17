package com.simulaton;

import java.util.Scanner;

public class Map implements IMapSize {
    private int mapSize[][];   // [x][y][surowiec][ilosc surowca ]

//    public Map() { // do przemyslenia jak przechowywac to wszystko // hashmapa??
//        this.mapSize = new int[setMapSize()][setMapSize()][1][1];
//    }

//    public int[][] getMapSize() {
//        return mapSize;
//    }
//
//    public void setMapSize(int[][] mapSize) {
//        this.mapSize = mapSize;
//    }

    @Override
    public int setMapSize() {
        Scanner scanner = new Scanner(System.in);
        int size;
        boolean uncorrectSize = true;

        do {
            System.out.println("Podaj rozmiar mapy od 10 do 100: ");
            size = scanner.nextInt();
            if (size >= 10 && size <= 100) {
                uncorrectSize = false;
            }
            else {
                System.out.println("Podano nieprawidłowy rozmiar mapy!");
            }
        } while (uncorrectSize == true);

        return size;
    }
}
