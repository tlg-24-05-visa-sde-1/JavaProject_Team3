package com.jbm.connect4.test;

import com.jbm.connect4.model.Board;
import com.jbm.connect4.model.Token;
import com.jbm.connect4.model.User;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.columns;
import static org.junit.Assert.*;


public class UserTest {

    private Board board;
    private User user;


    @Before
    public void setUp() {
        board = new Board();
        user = new User(board);
    }

    @Test
    public void testChooseColumnWithValidInput() {
        System.setIn(new ByteArrayInputStream("3\n" .getBytes()));
        int column = user.chooseColumn();
        assertEquals(3,column);
    }


    @Test
    public void testChooseColumnWithInvalidInput() {
        System.setIn(new ByteArrayInputStream("8\n0\n" .getBytes()));
        int column = user.chooseColumn();
        assertEquals(0,column);
    }




    @Test
    public void testChooseColumnWithFullColumn() {
        for (int i = 0; i < 6; i++) {
            board.update(3, new Token("Red"));
        }

        String input = "3\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = user.chooseColumn();
        assertEquals(4, result);
    }

    }

