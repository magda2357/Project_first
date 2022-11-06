package org.example;

public class Menu {

    public static void showMenu() {
        System.out.println("WYBIERZ OPCJĘ:");

        for (int i = 1; i <= 4; i++) {
            System.out.println(i + " " + menuSwitch(i));
        }
    }
    static String menuSwitch(int number) {
        switch (number) {
            case 1:
                return ("Podaj dzisiejszą datę");
            case 2:
                return "Zarejestruj się.";
            case 3:
                return "Wypisz użytkowników.";
            case 4:
                return "Koniec programu";
            default:
                return "Niewłaściwy numer, wybierz jeszcze raz!";
        }
    }

}
