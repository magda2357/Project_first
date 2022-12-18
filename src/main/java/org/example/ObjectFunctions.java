package org.example;

import java.util.List;
import java.util.Scanner;

public class ObjectFunctions {

    public static void addObjectToList() {

        List<User> users = FileManager.getUsersFromFile(MainMenu.FILE_NAME, ";");
        users.add(getUserData());
        FileManager.sortList(users, "Asc");

        saveObjectsToTxt(MainMenu.FILE_NAME, users);

        System.out.println("Dodano nowego użytkownika.");
    }


    public static boolean isEmailCorrect(String login) {
        String email_pattern = "^[a-zA-Z0-9_#$%&’*+/=?^.-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return login.matches(email_pattern);
    }

    public static void printUsers() {

        List<User> users = FileManager.getUsersFromFile(MainMenu.FILE_NAME, ";");
        FileManager.sortList(users, "Asc");

        System.out.println("Użytkownicy: ");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    private static void saveObjectsToTxt(String fileName, List<User> users) {

        String inputToTxt = "";
        for (User user : users) {
            inputToTxt += user.getName() + ";" + user.getSurname() + ";" + user.getGender() + ";"
                    + user.getLogin() + ";" + user.getPassword() + ";" + "\n";
        }

        FileManager.writeToTxt(fileName, inputToTxt);
    }

    private static User getUserData() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj imię.");
        String firstName = sc.next();

        System.out.println("Podaj nazwisko.");
        String lastName = sc.next();

        System.out.println("Podaj płeć: K/M.");
        String gen = sc.next();
        while (!gen.equals("K") && !gen.equals("M")) {
            System.out.println("Zły format. Podaj jeszcze raz: K/M?");
            gen = sc.next();
        }
        Gender gender = Gender.valueOf(gen);

        System.out.println("Podaj maila.");
        String login = sc.next();
        while (!isEmailCorrect(login)) {
            System.out.println("Zły format maila. Podaj jeszcze raz.");
            login = sc.next();
        }

        System.out.println("Podaj hasło.");
        String password = sc.next();

        return new User(firstName, lastName, gender, login, password);
    }

}
