package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static org.example.MenuSwitch.menu;

public class MainMenu {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int option = 0;
        while (option != 4) {
            System.out.println("WYBIERZ OPCJĘ:");
            for (int i = 1; i <= 4; i++) {
                System.out.println(i + " " + menu(i));
            }

            if (sc.hasNextInt()) {
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Dzisiejsza data to: " + LocalDate.now());
                } else if (option == 2) {
                    User.addUser();
                } else if (option == 3) {
                    User.printUsers();
                } else if (option == 4) {
                    System.out.println("KONIEC PROGRAMU");
                } else {
                    System.out.println(menu(option));
                }
            } else {
                System.out.println("Niewłaściwy format numeru, wybierz jeszcze raz!");
                sc.next();
            }
        }
    }
}
