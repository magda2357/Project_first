package org.example;

public class MenuSwitch {
    static String menu(int number) {
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
