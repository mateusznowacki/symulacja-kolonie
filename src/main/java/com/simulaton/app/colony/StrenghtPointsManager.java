package com.simulaton.app.colony;

import java.util.ArrayList;

/**
 * The type Strenght points manager.
 */
public class StrenghtPointsManager {
    /**
     * Recive strenght points array list.
     *
     * @param colonies the colonies
     * @param colony   the colony
     * @return the array list
     */
    public static ArrayList<Colony> reciveStrenghtPoints(ArrayList<Colony> colonies, Colony colony) {
        for (int i = 0; i < colonies.size(); i++) {
            if (colonies.get(i).getName().equals(colony.getName())) {
                colonies.get(i).setAttackStrength(colony.getAttackStrength() + 5);
                colonies.get(i).setDefenseStrength(colony.getDefenseStrength() + 5);
                colonies.get(i).setEconomyStrength(colony.getEconomyStrength() + 5);
            }
        }
        return colonies;
    }

    /**
     * Lose strenght points array list.
     *
     * @param colonies the colonies
     * @param colony   the colony
     * @return the array list
     */
    public static ArrayList<Colony> loseStrenghtPoints(ArrayList<Colony> colonies, Colony colony) {
        for (int i = 0; i < colonies.size(); i++) {
            if (colonies.get(i).getName().equals(colony.getName())) {
                colonies.get(i).setAttackStrength(colony.getAttackStrength() - 5);
                colonies.get(i).setDefenseStrength(colony.getDefenseStrength() - 5);
                colonies.get(i).setEconomyStrength(colony.getEconomyStrength() - 5);
            }
        }
        return colonies;
    }
}
