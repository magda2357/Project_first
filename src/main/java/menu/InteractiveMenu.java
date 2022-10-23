package menu;

import java.time.LocalDate;
import java.util.Scanner;

public class InteractiveMenu {

    static String options(int numer) {
        switch (numer) {
            case 1:
                return ("Podaj dzisiejszą datę");
            case 2:
                return "Podaj swoje imię.";
            case 3:
                return "Wypisz swoje imię.";
            case 4:
                return "Koniec programu";
            default:
                return "Niewłaściwy numer, wybierz jeszcze raz!";
        }
    }

    public static void main(String[] args) {
        int option = 0;
        String name = "Jeszcze nie podałaś/eś imienia";
        Scanner sc = new Scanner(System.in);

        while (option != 4) {

            System.out.println("WYBIERZ OPCJĘ:");
            for (int i = 1; i <= 4; i++) {
                System.out.println(i + " " + options(i));
            }

            if (sc.hasNextInt()) {
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Dzisiejsza data to: " + LocalDate.now());
                } else if (option == 2) {
                    name = sc.next();
                } else if (option == 3) {
                    System.out.println("Masz na imię: " + name);
                } else if (option == 4) {
                    System.out.println("KONIEC PROGRAMU");
                } else {
                    System.out.println(options(option));
                }
            } else {
                System.out.println("Niewłaściwy format numeru, wybierz jeszcze raz!");
                sc.next();
            }
        }
    }
}
