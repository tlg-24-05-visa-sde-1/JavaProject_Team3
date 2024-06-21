package com.jbm.connect4.controller;

import com.apps.util.Prompter;
import com.jbm.connect4.model.*;
import com.jbm.connect4.view.GameResult;
import com.jbm.connect4.view.Welcome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;

public class Controller {
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final Board board = new Board();
    private final User user = new User(board);
    private final BotOpponent bot = new BotOpponent(board);
    private boolean gameOver = false;

    private final Map<String, OptionHandler> handlers = Map.of(
            "1", new Option1Handler(),
            "X", new OptionXHandler()
    );

    public void execute() {
        clear();
        new Welcome("WELCOME TO CONNECT FOUR").show();

        displayAsciiArtWithPause("menus/jbmbanner2.txt", 3);
        displayAsciiArtWithPause("menus/connect4artofficial2.txt", 3);

        MainMenu mainMenu = new MainMenu();

        while (!gameOver) {
            String choice = mainMenu.show();

            OptionHandler handler = handlers.get(choice);
            if (handler != null) {
                handler.execute();
            } else {
                System.out.println("Invalid option. Please try again.");
                enterToContinue();
            }
        }
        new GameResult(board).show();
    }

    private void enterToContinue() {
        prompter.prompt("Press [Enter] to continue: ");
    }


    private void displayAsciiArtWithPause(String filePath, int seconds) {
        try {
            String art = Files.readString(Path.of(filePath));
            System.out.println(art);
            TimeUnit.SECONDS.sleep(seconds);
            clear();
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted");
            e.printStackTrace();
        }
    }


    private class MainMenu {
        private static final String regex = "(\\s*1\\s*)|(\\s*2\\s*)|(\\s*X\\s*)|(\\s*x\\s*)";
        private final String menuFilePath = "menus/" + getClass().getSimpleName() + ".txt";
        private String menuText;

        public MainMenu() {
            try {
                menuText = Files.readString(Path.of(menuFilePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String show() {
            clear();
            System.out.println(menuText);
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            while (!choice.matches(regex)) {
                System.out.println("That is not a valid choice, please try again.");
                System.out.print("> ");
                choice = scanner.nextLine();
            }
            return choice.trim().toUpperCase();
        }
    }

    private class Option1Handler implements OptionHandler {
        @Override
        public void execute() {
            while (!gameOver) {
                clear();
                board.show();
                user.dropToken(new Token("Yellow"));
                clear();
                board.show();
                if (board.checkWin()) {
                    System.out.println("User wins!");
                    gameOver = true;
                } else if (board.isFull()) {
                    System.out.println("Game over! It's a draw!");
                    gameOver = true;
                } else {
                    bot.dropToken(new Token("Red"));
                    clear();
                    board.show();
                    if (board.checkWin()) {
                        System.out.println("Bot wins!");
                        gameOver = true;
                    } else if (board.isFull()) {
                        System.out.println("Game over! It's a draw!");
                        gameOver = true;
                    }
                }
            }
            enterToContinue();
        }
    }

    private class OptionXHandler implements OptionHandler {

        @Override
        public void execute() {
            System.out.println("\nThanks for playing!");
            pause(2000);
            gameOver = true;
        }
    }


}