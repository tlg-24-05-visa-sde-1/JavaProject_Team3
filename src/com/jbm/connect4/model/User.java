package com.jbm.connect4.model;
import java.util.ArrayList;
import java.util.Scanner;


public class User extends Player {

    public User(Board board) {
        super(board);
    }

    @Override
    protected int chooseColumn() {
        ArrayList<Integer> openColumns = getOpenColumns(); // Get the list of open columns
        Scanner scanner = new Scanner(System.in);
        int chosenColumn = -1; // Initialize with an invalid value

        while (true) {
            System.out.println("Player is (Y)ellow and Bot is (R)ed ");
            System.out.println("Choose a column from 0 to 6 to drop your token into: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number. Please enter a number from 0 to 6.");
                scanner.next();  // Discards input if non-int
            }
            chosenColumn = scanner.nextInt(); // Read int input

            if (chosenColumn >= 0 && chosenColumn <= 6 && !openColumns.contains(chosenColumn)) {
                System.out.println("The column " + chosenColumn + " you selected is full. Please choose another column.");
            } else if (chosenColumn < 0 || chosenColumn > 6) {
                System.out.println("Invalid column. Please choose a column from 0 to 6.");
            }
            while(!openColumns.contains(chosenColumn))
                return chosenColumn;
        }
    }

        @Override
        public void dropToken(Token token) {
            int column = chooseColumn();
            boolean success = board.update(column, token);
            if (!success) {
                throw new IllegalStateException("Failed to drop token in column " + column);
            }
        }


}
