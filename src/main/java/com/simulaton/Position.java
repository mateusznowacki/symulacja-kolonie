package com.simulaton;

import java.util.HashMap;
import java.util.Map;

public class Position {

    HashMap <int[],String> mapPosition = new HashMap<>();

      public void setColonyPosition(int x, int y, String colonyName){
        int [] coordinates = {x,y};
        mapPosition.put(coordinates,colonyName);
    }

       public void changeAlreadyTakenPosition(int x, int y , String nextColonyName){
        int[] coordinates = mapPosition.keySet().iterator().next();
        if (coordinates[0] == x && coordinates[1] == y) {
            mapPosition.replace(coordinates,nextColonyName);
            }
    }

    public String getColonyPosition(int x, int y){
        int [] coordinates = {x,y};
        return mapPosition.get(coordinates);
    }



}