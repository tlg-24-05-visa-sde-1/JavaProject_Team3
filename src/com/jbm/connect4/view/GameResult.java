package com.jbm.connect4.view;

import com.jbm.connect4.model.Board;

import static com.apps.util.Console.clear;

public class GameResult {
    private final Board board;

    public GameResult(Board board) {
        this.board = board;
    }

    public void show() {
        clear();
        System.out.println("----- -------\nFINAL RESULTS\n----- -------\n");
        board.show();
    }

}