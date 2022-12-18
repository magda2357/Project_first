package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class FileManager {

    static void writeToTxt(String fileName, String text) {
        try (FileWriter fr = new FileWriter(fileName)) {
            fr.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getUsersFromFile(String fileName, String separator) {

        if (!Files.exists(Path.of(fileName))) {
            FileManager.writeToTxt(fileName, "");
        }

        List<User> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(separator);
                User object = new User(details[0], details[1], Gender.valueOf(details[2]), details[3], details[4]);
                list.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<User> sortList(List<User> list, String order) {
        if (order.equals("Asc")) {
            list.sort(naturalOrder());
        } else if (order.equals("Desc")) {
            list.sort(naturalOrder());
        }
        return list;
    }

}
