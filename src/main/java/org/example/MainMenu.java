package org.example;

import static org.example.Manager.performOption;
import static org.example.Menu.showMenu;

public class MainMenu {

    public static String FILE_NAME = "C:\\Java_projekty\\Projeckt_first\\users.txt";

    public static void main(String[] args) {

        for (; ; ) {
            showMenu();
            performOption();
        }
    }
}
