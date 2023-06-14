package com.simulaton.app.engine;

import com.diogonunes.jcolor.Attribute;
import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.position.Position;
import com.simulaton.app.map.resources.ResourcesManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * The type Colony battle.
 */
public class ColonyBattle {

    Colony winningColony;
    Colony losingColony;

    /**
     * Colony battle current simulation state.
     *
     * @param positionsMap the positions map
     * @param colonies     the colonies
     * @return the current simulation state
     */
    public CurrentSimulationState colonyBattle(HashMap<Position, Colony> positionsMap, ArrayList<Colony> colonies) {
        ArrayList<Colony> fightingColonies;
        ArrayList<Position> fightingColoniesPositions;
        CurrentSimulationState currentState;

        fightingColonies = pickFightingColonies(colonies);
        fightingColoniesPositions = findFightingColoniesPositions(fightingColonies, positionsMap);

        currentState = fightBetweenColonies(fightingColonies, fightingColoniesPositions, positionsMap, colonies);
        printBattleResults(winningColony, losingColony);

        return currentState;
    }

    private ArrayList<Colony> pickFightingColonies(ArrayList<Colony> colonies) {
        ArrayList<Colony> fightingColonies = new ArrayList<>();
        Random random = new Random();
        Colony attackingColony = colonies.get(random.nextInt(colonies.size()));
        fightingColonies.add(attackingColony);
        Colony defendingColony;
        do {
            defendingColony = colonies.get(random.nextInt(colonies.size()));
        } while (attackingColony.equals(defendingColony));
        fightingColonies.add(defendingColony);
        return fightingColonies;
    }

    private ArrayList<Position> findFightingColoniesPositions(ArrayList<Colony> fightingColonies, HashMap<Position, Colony> positionsMap) {
        ArrayList<Position> positions = new ArrayList<>();
        String attackingColony = fightingColonies.get(0).getName();
        String defendingColony = fightingColonies.get(1).getName();
        Position attackingColonyPosition;
        Position defendingColonyPosition;
        for (Position position : positionsMap.keySet()) {
            if (positionsMap.get(position).getName().equals(attackingColony)) {
                attackingColonyPosition = position;
                positions.add(attackingColonyPosition);

            }
            if (positionsMap.get(position).getName().equals(defendingColony)) {
                defendingColonyPosition = position;
                positions.add(defendingColonyPosition);
            }
        }
        return positions;
    }

    private CurrentSimulationState fightBetweenColonies(ArrayList<Colony> fightingcolonies, ArrayList<Position> positions, HashMap<Position, Colony> positionsMap, ArrayList<Colony> colonies) {
        int attackingColonyPoints = 0;
        int defendingColonyPoints = 0;
        Colony attackingColony = fightingcolonies.get(0);
        Colony defendingColony = fightingcolonies.get(1);
        Position attackingColonyPosition = positions.get(0);
        Position defendingColonyPosition = positions.get(1);
        CurrentSimulationState currentState = new CurrentSimulationState();
        ResourcesManager resourcesManager = new ResourcesManager();

        if ((attackingColony.getArmySize() * attackingColony.getAttackStrength()) >= (defendingColony.getArmySize() * defendingColony.getDefenseStrength())) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        //defence
        if ((attackingColony.getArmySize() * attackingColony.getDefenseStrength()) >= (defendingColony.getArmySize() * defendingColony.getAttackStrength())) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }
        //economy
        if ((attackingColony.getEconomyStrength() * attackingColony.getPopulation()) >= (defendingColony.getEconomyStrength() * defendingColony.getPopulation())) {
            attackingColonyPoints += 1;
        } else {
            defendingColonyPoints += 1;
        }

        if (attackingColonyPoints >= defendingColonyPoints) {
            positionsMap.put(defendingColonyPosition, attackingColony);
            attackingColony.setBattleWins(attackingColony.getBattleWins() + 1);
            currentState.setColonies(resourcesManager.reciveResources(colonies,attackingColony));
            currentState.setColonies(resourcesManager.spendResources(colonies,defendingColony));
            winningColony = attackingColony;
            losingColony = defendingColony;

            for (int i = 0; i < colonies.size(); i++) {
                if (colonies.get(i).getName().equals(attackingColony.getName())) {
                    colonies.remove(i);
                    colonies.add(attackingColony);
                }
            }
            currentState.setColonies(colonies);
            currentState.setPositionsMap(positionsMap);
            return currentState;

        } else {
            positionsMap.put(attackingColonyPosition, defendingColony);
            defendingColony.setBattleWins(defendingColony.getBattleWins() + 1);
            currentState.setColonies(resourcesManager.reciveResources(colonies,defendingColony));
            currentState.setColonies(resourcesManager.spendResources(colonies,attackingColony));
            winningColony = defendingColony;
            losingColony = attackingColony;

            for (int i = 0; i < colonies.size(); i++) {
                if (colonies.get(i).getName().equals(defendingColony.getName())) {
                    colonies.remove(i);
                    colonies.add(defendingColony);
                }
            }
            currentState.setColonies(colonies);
            currentState.setPositionsMap(positionsMap);
            return currentState;
        }
    }

    private void printBattleResults(Colony winningColony, Colony losingColony) {
        System.out.println("Wygrala kolonia " + colorize(winningColony.getName(), Attribute.TEXT_COLOR(90, 225, 22)) + " z wynikiem " +
                colorize(String.valueOf(winningColony.getBattleWins()), Attribute.TEXT_COLOR(90, 225, 22)) + " zwyciestw, pokonujac kolonie " +
                colorize(losingColony.getName(), Attribute.TEXT_COLOR(218, 45, 45)));
    }

}
