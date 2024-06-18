import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class User {
    // Protected field(s)/instance variable(s)
    protected Board board;

    // Constructor initializing User with Board object
    public User(Board board) {
        this.board = board;
    }

    /*
     * chooseColumn() : 1. Calls isFull() from Board class before allowing
     * the User to choose a column and dropToken().
     *
     *
     */
     protected int chooseColumn() {
         if(board.isFull()) {
                throw new IllegalStateException("The board is full, no open slots to place a token.");
            }

         // List to keep track of columns that are not full
         ArrayList<Integer> openColumns = new ArrayList<>();
         // Loops through all open columns (0-6)
         for (int i = 0; i < 7; i++) {
             // Checks if token can be dropped in a column
             if (board.canDropToken(i)) {
                 // If yes, adds the column
                 openColumns.add(i);
             }
         }

         // If no columns are open, throw an exception
         if (openColumns.isEmpty()) {
             throw new IllegalStateException("The board is full, no open slots to place token.");
         }

         // Checks if current instance is Player
         if (this instanceof Player) {
             // Scanner object created to read in User Player input
             Scanner scanner = new Scanner(System.in);
             int chosenColumn;
             do {
                 // Prompts the User Player to choose a column
                 System.out.println("Choose a column between 0 and 6 to drop your token into: ");
                 // Checks that User input is an integer
                 while (!scanner.hasNextInt()) {
                     System.out.println("That's not a number. Please enter a number between 0 and 6:");
                     scanner.next(); // Discards non-integer input
                 }
                 chosenColumn = scanner.nextInt(); // Reads the integer input
             } while (!openColumns.contains(chosenColumn)); // Repeats if the chosen column is not open
             scanner.close();
             return chosenColumn; // Returns the chosen column index
         } else if (this instanceof BotOpponent) {
             // If the instance is BotOpponent, choose a random column from the open columns
             return openColumns.get(new Random().nextInt(openColumns.size()));
         } else {
             // If the instance is neither Player nor BotOpponent, throw an exception
             throw new IllegalStateException("Unknown user type");
            }
        }

        // dropToken() : drops the Player (Y) or BotOpponent (r) token into their chosen column
        public void dropToken(String color) {
         int column = chooseColumn(); // Gets the chosen column to drop the token into it
         boolean success = board.update(column, new Token(color)); // attempts to drop token into the column on game board
         if (!success) {
             throw new IllegalStateException("Failed to drop token in column " + column);
         }
        }
    }