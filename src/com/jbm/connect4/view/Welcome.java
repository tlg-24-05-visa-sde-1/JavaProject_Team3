package com.jbm.connect4.view;

import static com.apps.util.Console.blankLines;
import static com.apps.util.Console.pause;

public class Welcome {
    private final String message;

    public Welcome(String message) {
        this.message = message;
    }

    public void show() {
        blankLines(2);
        System.out.print("Loading, please wait...");
        System.out.println();
        pause(2000);
        System.out.print("Done!");
        pause(2000);
    }
}