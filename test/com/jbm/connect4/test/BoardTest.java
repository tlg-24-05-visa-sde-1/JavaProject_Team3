package com.jbm.connect4.test;

import com.jbm.connect4.model.Board;
import com.jbm.connect4.model.Token;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;
    private Token redToken;
    private Token yellowToken;

    @Before
    public void setUp() {
        board = new Board();
        redToken = new Token("Red");
        yellowToken = new Token("Yellow");
    }
    @Test
    public void testValidUpdate() {
        assertTrue(board.update(3, yellowToken));
        assertTrue(board.update(4, yellowToken));
    }

    @Test (expected=IndexOutOfBoundsException.class )
    public void testInvalidUpdateLowerBound(){
        board.update(-1, redToken);
    }

    @Test (expected=IndexOutOfBoundsException.class )
    public void testInvalidUpdateUpperBound(){
        board.update(7, redToken);

    }

    @Test
    public void testHorizontalWin() {
        for (int i = 0; i < 4; i++) {
            board.update(i, redToken);
        }
        assertTrue(board.checkWin());
    }

    @Test
    public void testVerticalWin() {
        for (int i = 0; i < 4; i++) {
            board.update(0, redToken);
        }
        assertTrue(board.checkWin());
    }

    @Test
    public void testDiagonalWin() {
        board.update(0, redToken);
        board.update(1, yellowToken);
        board.update(1, redToken);
        board.update(2, yellowToken);
        board.update(2, yellowToken);
        board.update(2, redToken);
        board.update(3, yellowToken);
        board.update(3, yellowToken);
        board.update(3, yellowToken);
        board.update(3, redToken);
        assertTrue(board.checkWin());
    }

    @Test
    public void testIsFull() {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 6; row++) {
                board.update(col, redToken);
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testCanDropToken() {
        assertTrue(board.canDropToken(0));
        for (int i = 0; i < 6; i++) {
            board.update(0, redToken);
        }
        assertFalse(board.canDropToken(0));
    }


}
