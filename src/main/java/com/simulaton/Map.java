package com.simulaton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;



public class Map implements IMapSize {

    private int size;
    HashMap <int[],Resources> mapResources = new HashMap<>();

    public void fillResources(int x, int y, String nazwa, int ilosc){ // gotowa metoda do wypełniania mapy zasobami
        int [] coordinates = {x,y};
        Resources resources = new Resources(nazwa, ilosc);
        mapResources.put(coordinates, resources);
        }

    public void showResourcesOnMap() {
        for (int[] key : mapResources.keySet()) {
            //if (Arrays.equals(key, coordinates)) {
                System.out.println("Znaleziono zasoby na pozycji: " + key[0] + " " + key[1]);
                System.out.println("Nazwa zasobu: " + mapResources.get(key).getResourceType());
                System.out.println("Ilosc zasobu: " + mapResources.get(key).getResourceAmount());
        }
//            Object[] keys = mapResources.keySet().toArray(); // 2 wersja tej samej funkcji
//            for (int i = 0; i < keys.length; i++) {
//                int[] key = (int[]) keys[i];
//                System.out.println("Znaleziono zasoby na pozycji: " + key[0] + " " + key[1]);
//                Resources resources = mapResources.get(key);
//                System.out.println("Nazwa zasobu: " + resources.getResourceType());
//                System.out.println("Ilosc zasobu: " + resources.getResourceAmount());
//            }
    }
    public int getResourceAmount(int x, int y) {
        int[] coordinates = mapResources.keySet().iterator().next();
        if (coordinates[0] == x && coordinates[1] == y) {
            Resources resources = mapResources.get(coordinates);
                if (resources != null) {
                return resources.getResourceAmount();
                }
        }
        return 0;
    }
    public String getResourceType(int x, int y) {
        int[] coordinates = mapResources.keySet().iterator().next();
        if (coordinates[0] == x && coordinates[1] == y) {
            Resources resources = mapResources.get(coordinates);
                if (resources != null) {
                return resources.getResourceType();
                }
        }
        return "Brak surowcow na tej pozycji";
    }

    public void removeResources(int x, int y){
        int[] coordinates = mapResources.keySet().iterator().next();
        if (coordinates[0] == x && coordinates[1] == y) {
            Resources resources = mapResources.get(coordinates);
            mapResources.replace(coordinates,resources.setResourceAmount(0));
        }

    }

    @Override
        public int setMapSize () {
            Scanner scanner = new Scanner(System.in);
            boolean uncorrectSize = true;

            while (uncorrectSize) {
                System.out.println("Podaj rozmiar mapy od 10 do 100: ");
                size = scanner.nextInt();
                if ((size > 9) && (size < 101)) {
                    uncorrectSize = false;
                } else {
                    System.out.println("Podano nieprawidłowy rozmiar mapy!");
                }
            }
            return size;
        }
    }

