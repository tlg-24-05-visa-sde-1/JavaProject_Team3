package com.jbm.connect4.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Column> columns;

    public Board() {
        columns = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            columns.add(new Column());
        }
    }

    public boolean update(int column, Token token) {
        return columns.get(column).addToken(token);
    }

    public void show () {
        for (int row = 5; row >= 0; row--) {
            for (int col = 0; col < 7; col++) {
                Token token = columns.get(col).getTokenAt(row);
                if (token != null) {
                    System.out.println("| " + token.getColor() + " ");
                }else {
                    System.out.println("| _ ");
                }
            }
            System.out.println("|");
        }
    }

    public boolean checkWin () {
        return checkHorizantalWin() || checkVertical() || checkDiagnoalWin();
    }

    private boolean checkHorizantalWin() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                Token token = columns.get(col).getTokenAt(row);
                if (token != null &&
                    token.equals(columns.get(col+1).getTokenAt(row)) &&
                    token.equals(columns.get(col+2).getTokenAt(row)) &&
                    token.equals(columns.get(col+3).getTokenAt(row)) ) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical() {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 3; row++) {
                Token token = columns.get(col).getTokenAt(row);
                if (token != null &&
                token.equals(columns.get(col).getTokenAt(row+1)) &&
                token.equals(columns.get(col).getTokenAt(row+2)) &&
                token.equals(columns.get(col).getTokenAt(row+3)) ) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagnoalWin() {
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 3; row++) {
                Token token = columns.get(col).getTokenAt(row);
                if (token != null &&
                        token.equals(columns.get(col+1).getTokenAt(row+1)) &&
                        token.equals(columns.get(col+2).getTokenAt(row+2)) &&
                        token.equals(columns.get(col+3).getTokenAt(row+3))) {
                    return true;
                }
            }
        }

        for (int col = 0; col < 4; col++) {
            for (int row = 3; row < 6; row++) {
                Token token = columns.get(col).getTokenAt(row);
                if (token != null &&
                        token.equals(columns.get(col+1).getTokenAt(row-1)) &&
                        token.equals(columns.get(col+2).getTokenAt(row-2)) &&
                        token.equals(columns.get(col+3).getTokenAt(row-3))) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean isFull(){
        for (Column column : columns) {
            if (column.size() < 6) {
                return false;
            }
        }
        return true;
    }
    public boolean canDropToken(int column) {
        return columns.get(column).size() < 6;
    }

}