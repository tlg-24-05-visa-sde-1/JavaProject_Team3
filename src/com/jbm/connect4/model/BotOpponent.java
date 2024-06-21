package com.jbm.connect4.model;

import java.util.ArrayList;
import java.util.Random;

public class BotOpponent extends Player {
    // Ctor that initializes BotOpponent with a Board object
    public BotOpponent(Board board) {
        super(board);
    }

    @Override
    public int chooseColumn() {
        // Gets list of open columns using the method from the Player class
        ArrayList<Integer> openColumns = getOpenColumns();

        // Randomly select an index from the list of open columns
        return openColumns.get(new Random().nextInt(openColumns.size()));
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