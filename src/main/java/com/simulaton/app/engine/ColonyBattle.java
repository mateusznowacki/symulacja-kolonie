package com.simulaton.app.engine;

import com.diogonunes.jcolor.Attribute;
import com.simulaton.app.colony.Colony;
import com.simulaton.app.map.position.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.simulaton.app.colony.StrenghtPointsManager.loseStrenghtPoints;
import static com.simulaton.app.colony.StrenghtPointsManager.reciveStrenghtPoints;
import static com.simulaton.app.map.resources.ResourcesManager.reciveResources;
import static com.simulaton.app.map.resources.ResourcesManager.spendResources;

/**
 * The type Colony battle.
 */
public class ColonyBattle implements BattleResolver {

    /**
     * The Winning colony.
     */
    private Colony winningColony;
    /**
     * The Losing colony.
     */
    private Colony losingColony;


    /**
     * Colony battle current simulation state.
     *
     * @param colonies     the colonies
     * @param positionsMap the positions map
     * @return the current simulation state
     */
    public CurrentSimulationState colonyBattle(ArrayList<Colony> colonies, HashMap<Position, Colony> positionsMap) {
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
        ArrayList<Colony> fightingColonies = new ArrayList<>();
        Colony attackingColony = fightingcolonies.get(0);
        Colony defendingColony = fightingcolonies.get(1);
        Position losingColonyPosition;
        CurrentSimulationState currentState = new CurrentSimulationState();
        Random random = new Random();

        switch (random.nextInt(8)) {
            case 1: {
                fightingColonies = compareResources(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);

            }
            break;
            case 2: {
                fightingColonies = compareStrenghtPoints(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);
            }
            break;
            case 3: {
                fightingColonies = compareAllStats(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);
            }
            break;
            case 4: {
                fightingColonies = compareArmySize(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);
            }
            break;
            case 5: {
                fightingColonies = compareEconomyLargeness(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);
            }
            break;
            case 6: {
                fightingColonies = compareDefencePower(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);

            }
            break;
            case 7: {
                fightingColonies = comparePopulation(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);
            }
            break;
            case 8: {
                fightingColonies = compareAttackPower(attackingColony, defendingColony);
                winningColony = fightingColonies.get(0);
                losingColony = fightingColonies.get(1);
            }
            break;
        }
        losingColonyPosition = getLosingColonyPosition(positionsMap, positions, losingColony);


        positionsMap.put(losingColonyPosition, winningColony);//////////////////////////////////////
        winningColony.setBattleWins(winningColony.getBattleWins() + 1);
        currentState.setColonies(reciveResources(colonies, winningColony));
        currentState.setColonies(spendResources(colonies, losingColony));
        currentState.setColonies(reciveStrenghtPoints(colonies, winningColony));
        currentState.setColonies(loseStrenghtPoints(colonies, losingColony));

        for (int i = 0; i < colonies.size(); i++) {
            if (colonies.get(i).getName().equals(winningColony.getName())) {
                colonies.remove(i);
                colonies.add(winningColony);
            }
        }
        currentState.setColonies(colonies);
        currentState.setPositionsMap(positionsMap);
        return currentState;

    }

    private Position getLosingColonyPosition(HashMap<Position, Colony> positionsMap, ArrayList<Position> positions, Colony losingColony) {
        Position losingColonyPosition = null ;

        for (int i = 0; i < positions.size(); i++) {
            if (positionsMap.containsKey(positions.get(i)) && positionsMap.get(positions.get(i)).equals(losingColony.getName())) {
                losingColonyPosition = positions.get(i);
            }
        }
        return losingColonyPosition;
    }


    private void printBattleResults(Colony winningColony, Colony losingColony) {
        System.out.println("Wygrala kolonia " + colorize(winningColony.getName(), Attribute.TEXT_COLOR(90, 225, 22)) + " z wynikiem " +
                colorize(String.valueOf(winningColony.getBattleWins()), Attribute.TEXT_COLOR(90, 225, 22)) + " zwyciestw, pokonujac kolonie " +
                colorize(losingColony.getName(), Attribute.TEXT_COLOR(218, 45, 45)));
    }

}