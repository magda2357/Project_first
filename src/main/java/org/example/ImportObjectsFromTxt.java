package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ImportObjectsFromTxt {

    public static List<User> getUsersFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<User> users = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(";");

            User oneUser = new User();
            oneUser.setLogin(details[0]);
            oneUser.setPassword(details[1]);
            oneUser.setName(details[2]);
            oneUser.setSurname(details[3]);
            oneUser.setGender(Gender.valueOf(details[4]));

            users.add(oneUser);
        }
        users.sort(Comparator.comparing(User::getLogin));
        return users;
    }

}


