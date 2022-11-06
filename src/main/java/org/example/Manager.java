package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Manager {

    public static void performOption() {
        Scanner sc = new Scanner(System.in);
        int option;
        if (sc.hasNextInt()) {
            option = sc.nextInt();
            managerSwitch(option);
        } else {
            System.out.println("Niewłaściwy format numeru, wybierz jeszcze raz!");
            sc.next();
        }
    }

    static void managerSwitch(int number) {
        switch (number) {
            case 1:
                System.out.println("Dzisiejsza data to: " + LocalDate.now());
                break;
            case 2:
                ObjectFunctions.addObjectToList();
                break;
            case 3:
                ObjectFunctions.printUsers();
                break;
            case 4:
                System.out.println("PROGRAM ZAKOŃCZONY");
                System.exit(0);
                break;
            default:
                System.out.println("Niewłaściwy numer, wybierz jeszcze raz!");
        }
    }
}
