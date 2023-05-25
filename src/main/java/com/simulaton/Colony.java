package com.simulaton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Colony {
    private String name;
    private int attackStrength;
    private int defenseStrength;
    private int economyStrength;
    private int population;
    private int armySize;
    private int checkPoint = 0;
    private int pointsToSpend;
    private int populationPointsToSpend;

    HashMap<String,Integer> amountOfResources = new HashMap<>();

    public Colony(String name, int attackStrength, int defenseStrength, int economyStrength, int population, int armySize) {
        this.name = name;
        this.attackStrength = attackStrength;
        this.defenseStrength = defenseStrength;
        this.economyStrength = economyStrength;
        this.population = population;
        this.armySize = armySize;

    }

    public Colony() {
    }

    public void addResources(String type, Integer amount) {
        if(amountOfResources.containsKey(type)){
            Integer totalAmount = amountOfResources.get(type) + amount;
            amountOfResources.replace(type,totalAmount);
        }else{
            amountOfResources.put(type,amount);
        }
    }

    public void reciveResources(String type, Integer amount) {
        if(amountOfResources.containsKey(type)){
            Integer totalAmount = amountOfResources.get(type) + amount;
            amountOfResources.replace(type,totalAmount);
        }
    }

    public void getUserColonyData() {
        int pointsToSpend = 100;
        int populationPointsToSpend = 100;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwe dla twojej kolonii: ");
        name = scanner.nextLine();

        System.out.println("Rozdziel 100 punktow na sile ataku, obrony oraz ekonomii.");
        do {
            System.out.println("Podaj sile ataku: ");
            attackStrength = scanner.nextInt();
            if (attackStrength > pointsToSpend) {
                System.out.println("Podales za duza liczbe");
            } else if (attackStrength < 0) {
                System.out.println("Podales za mala liczbe");
            } else {
                pointsToSpend -= attackStrength;
                checkPoint = 1;
            }
        } while (checkPoint < 1);

        do {
            System.out.println("Do rozdania pozostalo ci " + pointsToSpend + " punktow");
            System.out.println("Podaj sile obrony: ");
            defenseStrength = scanner.nextInt();
            if (defenseStrength > pointsToSpend) {
                System.out.println("Podales za duza liczbe");
            } else if (defenseStrength < 0) {
                System.out.println("Podales za mala liczbe");
            } else {
                pointsToSpend -= defenseStrength;
                checkPoint = 2;
            }
        } while (checkPoint < 2);

        do {
            System.out.println("Do rozdania pozostalo ci " + pointsToSpend + " punktow");
            System.out.println("Podaj sile ekonomii: ");
            economyStrength = scanner.nextInt();
            if (economyStrength > pointsToSpend) {
                System.out.println("Podales za duza liczbe");
            } else if (economyStrength < 0) {
                System.out.println("Podales za mala liczbe");
            } else {
                pointsToSpend -= economyStrength;
                checkPoint = 3;
            }
        } while (checkPoint < 3);

        if (pointsToSpend > 0) {
            System.out.println(pointsToSpend + " to liczba punktow ktore nie zostaly przydzielone i przepadaja");
        }

        System.out.println("Rozdziel 100 punktow na wielkosc populacji pracujacej oraz armie");
        do {
            System.out.println("Do rozdania pozostalo ci " + populationPointsToSpend + " punktow");
            System.out.println("Podaj wielkosc populacji robotnikow: ");
            population = scanner.nextInt();
            if (population > populationPointsToSpend) {
                System.out.println("Podales za duza liczbe");
            } else if (population < 0) {
                System.out.println("Podales za mala liczbe");
            } else {
                populationPointsToSpend -= population;
                checkPoint = 4;
            }
        } while (checkPoint < 4);

        do {
            System.out.println("Do rozdania pozostalo ci " + populationPointsToSpend + " punktow");
            System.out.println("Podaj wielkosc armii: ");
            armySize = scanner.nextInt();
            if (armySize > populationPointsToSpend) {
                System.out.println("Podales za duza liczbe");
            } else if (armySize < 0) {
                System.out.println("Podales za mala liczbe");
            } else {
                populationPointsToSpend -= armySize;
                checkPoint = 5;
            }
        } while (checkPoint < 5);
        if (populationPointsToSpend > 0) {
            System.out.println(populationPointsToSpend + " to liczba punktow ktore nie zostaly przydzielone i przepadaja");
        }

        Colony userColony = new Colony(name, attackStrength, defenseStrength, economyStrength, population, armySize);
    }

    public String getBotColonyName() {
        try {
            File database = new File("src/main/java/com/simulaton/database.txt");
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
            System.out.println("Błąd: Plik nie został odnaleziony.");
            e.printStackTrace();
            name="BotColony";
        }
        return name;
    }
    public void getBotColony() {

        pointsToSpend = 100;
        populationPointsToSpend = 100;
        Random random = new Random();

        //random distribution of points
        attackStrength= random.nextInt(pointsToSpend);
        pointsToSpend-=attackStrength;
        defenseStrength= random.nextInt(pointsToSpend);
        pointsToSpend-=defenseStrength;
        economyStrength=pointsToSpend;
        population=random.nextInt(populationPointsToSpend);
        populationPointsToSpend-=population;
        armySize=populationPointsToSpend;
        name=getBotColonyName();
        Colony botColony1 = new Colony(name, attackStrength, defenseStrength, economyStrength, population, armySize);
        name=getBotColonyName();
        Colony botColony2 = new Colony(name, attackStrength, defenseStrength, economyStrength, population, armySize);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getDefenseStrength() {
        return defenseStrength;
    }

    public void setDefenseStrength(int defenseStrength) {
        this.defenseStrength = defenseStrength;
    }

    public int getEconomyStrength() {
        return economyStrength;
    }

    public void setEconomyStrength(int economyStrength) {
        this.economyStrength = economyStrength;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArmySize() {
        return armySize;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }



}
