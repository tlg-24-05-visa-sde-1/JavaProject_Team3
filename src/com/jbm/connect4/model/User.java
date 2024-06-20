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
        int chosenColumn;

        System.out.println("Player is (Y)ellow and Bot is (R)ed ");
        System.out.println("Choose a column between 0 and 6 to drop your token into: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a number between 0 and 6:");
            scanner.next();  // Discards input if non-int
        }
        chosenColumn = scanner.nextInt(); // Read int input

        if(!openColumns.contains(chosenColumn)) {
            scanner.close();
            throw new IllegalArgumentException("The column " + chosenColumn + " you chose is full. Please select" +
                    " a new column.");
        }
        return chosenColumn;
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

