package com.simulaton.app.engine;

import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.position.Position;
import com.simulaton.app.map.resources.ResourceTypes;

import java.util.ArrayList;
import java.util.HashMap;

public interface BattleResolver {

    default ArrayList<Colony> compareResources(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;

        if (attackingColony.getResourceCounts().get(ResourceTypes.FOOD) >= defendingColony.getResourceCounts().get(ResourceTypes.FOOD)) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getResourceCounts().get(ResourceTypes.WOOD) >= defendingColony.getResourceCounts().get(ResourceTypes.WOOD)) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColony.getResourceCounts().get(ResourceTypes.IRON) >= defendingColony.getResourceCounts().get(ResourceTypes.IRON)) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColony.getResourceCounts().get(ResourceTypes.STONE) >= defendingColony.getResourceCounts().get(ResourceTypes.STONE)) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColonyPoints > defendingColonyPoints) {
            // first colony has won battle
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }

        return colonies;
    }

    default ArrayList<Colony> compareStrenghtPoints(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;
        if (attackingColony.getAttackStrength() >= defendingColony.getAttackStrength()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getDefenseStrength() >= defendingColony.getDefenseStrength()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getEconomyStrength() >= defendingColony.getEconomyStrength()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColonyPoints > defendingColonyPoints) {
            // first colony has won battle
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }
        return colonies;
    }

    default ArrayList<Colony> compareAllStats(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;

        if (attackingColony.getAttackStrength() >= defendingColony.getAttackStrength()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getDefenseStrength() >= defendingColony.getDefenseStrength()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getEconomyStrength() >= defendingColony.getEconomyStrength()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getArmySize() >= defendingColony.getArmySize()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getPopulation() >= defendingColony.getPopulation()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColonyPoints > defendingColonyPoints) {
            // first colony has won battle
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }
        return colonies;

    }

    default ArrayList<Colony> compareArmySize(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        if (attackingColony.getArmySize() >= defendingColony.getArmySize()) {
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }
        return colonies;

    }

    default ArrayList<Colony> comparePopulation(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        if (attackingColony.getPopulation() >= defendingColony.getPopulation()) {
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }
        return colonies;
    }

    default ArrayList<Colony> compareAttackPower(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;

        if (attackingColony.getAttackStrength() >= defendingColony.getAttackStrength()) {
            attackingColonyPoints +=1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getArmySize() >= defendingColony.getArmySize()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColonyPoints > defendingColonyPoints) {
            // first colony has won battle
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }
        return colonies;
    }

    default ArrayList<Colony> compareDefencePower(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;

        if (attackingColony.getDefenseStrength() >= defendingColony.getDefenseStrength()) {
            attackingColonyPoints +=1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getArmySize() >= defendingColony.getArmySize()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColonyPoints > defendingColonyPoints) {
            // first colony has won battle
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }
        return colonies;
    }

    default ArrayList<Colony> compareEconomyLargeness(Colony attackingColony, Colony defendingColony) {
        ArrayList<Colony> colonies = new ArrayList<>();
        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;

        if (attackingColony.getEconomyStrength() >= defendingColony.getEconomyStrength()) {
            attackingColonyPoints +=1;
        } else {
            defendingColonyPoints += 1;
        }
        if (attackingColony.getPopulation() >= defendingColony.getPopulation()) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColonyPoints > defendingColonyPoints) {
            // first colony has won battle
            colonies.add(attackingColony);
            colonies.add(defendingColony);
        } else {
            colonies.add(defendingColony);
            colonies.add(attackingColony);
        }
        return colonies;
    }

}
