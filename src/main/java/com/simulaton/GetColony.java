package com.simulaton;

import java.util.Scanner;

public class GetColony {
    public void getUserColonyData() {

         String name;
         int attackStrength;
         int defenseStrength;
         int economyStrength;
         int population;
         int armySize;
         int checkPoint=0;
         int pointsToSpend = 100;
         int populationPointsToSpend = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwe dla twojej kolonii: ");
        name = scanner.nextLine();

        System.out.println("Rozdziel 100 punktow na sile ataku, obrony oraz ekonomii.");
            do{
                System.out.println("Podaj sile ataku: ");
                attackStrength = scanner.nextInt();
                if(attackStrength > pointsToSpend ) {
                    System.out.println("Podales za duza liczbe");
                }else if (attackStrength<0){
                    System.out.println("Podales za mala liczbe");
                }else {
                    pointsToSpend-=attackStrength;
                    checkPoint=1;
                }
            }while (checkPoint<1);

            do {
                System.out.println("Do rozdania pozostalo ci " + pointsToSpend + " punktow");
                System.out.println("Podaj sile obrony: ");
                defenseStrength = scanner.nextInt();
                if(defenseStrength > pointsToSpend ) {
                    System.out.println("Podales za duza liczbe");
                }else if (defenseStrength<0){
                    System.out.println("Podales za mala liczbe");
                }else {
                    pointsToSpend-=defenseStrength;
                    checkPoint=2;
                }
            }while (checkPoint<2);

            do {
                System.out.println("Do rozdania pozostalo ci " + pointsToSpend + " punktow");
                System.out.println("Podaj sile ekonomii: ");
                economyStrength = scanner.nextInt();
                if(economyStrength > pointsToSpend ) {
                    System.out.println("Podales za duza liczbe");
                }else if (economyStrength<0){
                    System.out.println("Podales za mala liczbe");
                }else {
                    pointsToSpend-=economyStrength;
                    checkPoint=3;
                }
            }while (checkPoint<3);

            if(pointsToSpend>0){
                System.out.println(pointsToSpend + " to liczba punktow ktore nie zostaly przydzielone i przepadaja");
            }

        System.out.println("Rozdziel 100 punktow na wielkosc populacji pracujacej oraz armie");
            do {
                System.out.println("Do rozdania pozostalo ci " + populationPointsToSpend + " punktow");
                System.out.println("Podaj wielkosc populacji robotnikow: ");
                population = scanner.nextInt();
                if(population > populationPointsToSpend ) {
                    System.out.println("Podales za duza liczbe");
                }else if (population<0){
                    System.out.println("Podales za mala liczbe");
                }else {
                    populationPointsToSpend-=population;
                    checkPoint=4;
                }
            }while(checkPoint<4);

            do {
                System.out.println("Do rozdania pozostalo ci " + populationPointsToSpend + " punktow");
                System.out.println("Podaj wielkosc armii: ");
                armySize = scanner.nextInt();
                if(armySize > populationPointsToSpend ) {
                    System.out.println("Podales za duza liczbe");
                }else if (armySize<0){
                    System.out.println("Podales za mala liczbe");
                }else {
                    populationPointsToSpend-=armySize;
                    checkPoint=5;
                }
            }while(checkPoint<5);
            if(populationPointsToSpend>0){
                System.out.println(populationPointsToSpend + " to liczba punktow ktore nie zostaly przydzielone i przepadaja");
            }

        Colony userColony = new Colony(name, attackStrength, defenseStrength, economyStrength, population, armySize);

    }
}
