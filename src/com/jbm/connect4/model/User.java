package com.jbm.connect4.model;

<<<<<<< HEAD:src/com/jbm/connect4/model/User.java
<<<<<<< User-Player-Bot

=======
>>>>>>> User-Player-Bot:src/User.java
import java.util.ArrayList;
import java.util.Scanner;

class User extends Player {
    public User(Board board) {
        super(board);
    }

    @Override
    protected int chooseColumn() {
        ArrayList<Integer> openColumns = getOpenColumns(); // Get the list of open columns
        Scanner scanner = new Scanner(System.in);
        int chosenColumn;
        do {
            System.out.println("Choose a column between 0 and 6 to drop your token into: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number. Please enter a number between 0 and 6:");
                scanner.next();  // Discards input if non-int
            }
            chosenColumn = scanner.nextInt(); // Read int input
        } while (!openColumns.contains(chosenColumn));  // Repeats process if chosen column is not open
        scanner.close();
        return chosenColumn;
    }

    @Override
    public void dropToken(String color) {
        int column = chooseColumn();
        boolean success = board.update(column, new Token(color));
        if (!success) {
            throw new IllegalStateException("Failed to drop token in column " + column);
        }
<<<<<<< HEAD:src/com/jbm/connect4/model/User.java

        // dropToken() : drops the Player (Y) or BotOpponent (r) token into their chosen column
        public void dropToken(String color) {
         int column = chooseColumn(); // Gets the chosen column to drop the token into it
         boolean success = board.update(column, new Token(color)); // attempts to drop token into the column on game board
         if (!success) {
             throw new IllegalStateException("Failed to drop token in column " + column);
         }
        }
    }
=======
class User extends Player{

}
>>>>>>> main
=======
    }
}
>>>>>>> User-Player-Bot:src/User.java
