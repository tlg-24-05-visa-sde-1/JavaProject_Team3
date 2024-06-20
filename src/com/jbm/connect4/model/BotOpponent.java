package com.jbm.connect4.model;
<<<<<<< HEAD:src/com/jbm/connect4/model/BotOpponent.java

class BotOpponent extends User {
=======
>>>>>>> User-Player-Bot:src/BotOpponent.java

import java.util.ArrayList;
import java.util.Random;

class BotOpponent extends Player {
    // Ctor that initializes BotOpponent with a Board object
    public BotOpponent(Board board) {
        super(board);
    }

    @Override
    protected int chooseColumn() {
        // Gets list of open columns using the method from the Player class
        ArrayList<Integer> openColumns = getOpenColumns();

        // Randomly select an index from the list of open columns
        return openColumns.get(new Random().nextInt(openColumns.size()));
    }

    @Override
    public void dropToken(String color) {
        // Choose a column to drop the token
        int column = chooseColumn();
        // Attempts to place the token in the chosen column
        boolean success = board.update(column, new Token(color));
        if (!success) {
            // If not successful, throw exception
            throw new IllegalStateException("Failed to drop token in column " + column);
        }
    }
}