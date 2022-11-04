package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class User extends Person {
    private String login;
    private String password;

    public User() {
        super();
    }

    public User(String name, String surname, Gender gender, String login, String password) {
        super(name, surname, gender);
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login: " + login + ", " + super.toString();
    }

    public String printUserData() {
        return (getLogin() + ";" + getPassword() + ";" + getName() + ";" + getSurname() + ";" + getGender() + ";");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void addUser() throws IOException {
        String fileName = "C:\\Java_projekty\\Projeckt_first\\users.txt";
        User newUser = new User();

        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj imię.");
        newUser.setName(sc.next());

        System.out.println("Podaj nazwisko.");
        newUser.setSurname(sc.next());

        System.out.println("Podaj płeć: K/M.");
        newUser.setGender(Gender.valueOf(sc.next()));

        System.out.println("Podaj maila.");
        newUser.setLogin(sc.next());
        while (!isEmialCorrect(newUser.getLogin())) {
            System.out.println("Zły format maila. Podaj jeszcze raz.");
            newUser.setLogin(sc.next());
        }

        System.out.println("Podaj hasło.");
        newUser.setPassword(sc.next());

        if(!Files.exists(Path.of(fileName))) {
            WritingObjectsToTxt.writeToTxt(fileName, "");
        }
        List<User> users = ImportObjectsFromTxt.getUsersFromFile(fileName);
        users.add(newUser);
        users.sort(Comparator.comparing(User::getLogin));

        String exportUsers = "";
        for (User user : users) {
            exportUsers += user.printUserData() + "\n";
        }
        WritingObjectsToTxt.writeToTxt(fileName, exportUsers);

        System.out.println("Dodano nowego użytkownika: " + newUser.getLogin());
    }

    static boolean isEmialCorrect(String login) {
        String email_pattern = "^[a-zA-Z0-9_#$%&’*+/=?^.-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return login.matches(email_pattern);
    }

    public static void printUsers() throws IOException {
        String fileName = "C:\\Java_projekty\\Projeckt_first\\users.txt";
        if(!Files.exists(Path.of(fileName))) {
            WritingObjectsToTxt.writeToTxt(fileName, "");
        }

        List<User> users = ImportObjectsFromTxt.getUsersFromFile(fileName);
        System.out.println("Użytkownicy: ");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

/*    public static void main(String[] args) {
        String fileName = "C:\\Java_projekty\\Projeckt_first\\users.txt";
        System.out.println(Files.exists(Path.of(fileName)));

    }*/
}
