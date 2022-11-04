package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class WritingObjectsToTxt {
    static void writeToTxt(String file, String text) {
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
