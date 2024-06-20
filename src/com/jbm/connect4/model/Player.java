package com.jbm.connect4.model;

import java.util.ArrayList;

public abstract class Player {

    protected Board board;

    // Ctor to initialize Player with Board object
    public Player(Board board) {
        this.board = board;
    }

    /*
     * getOpenColumns() : contains the common logic for User and BotOpponent.
     * Checks if the board is full, so that User and BotOpponent canDropToken().
     */
    protected ArrayList<Integer> getOpenColumns() {
        if (board.isFull()) {
            throw new IllegalStateException("The board is full, no open slots to place a token.");
        }

        ArrayList<Integer> openColumns = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (board.canDropToken(i)) {
                openColumns.add(i);
            }
        }
        return openColumns;
    }


    protected abstract int chooseColumn();  // Implemented by subclasses: BotOpponent & User

    public abstract void dropToken(Token token); // Implemented by subclasses: BotOpponent & User
    // Implemented by subclasses: BotOpponent & User
}