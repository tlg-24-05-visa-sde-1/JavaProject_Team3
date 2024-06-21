package com.jbm.connect4.test;

import com.jbm.connect4.model.Board;
import com.jbm.connect4.model.BotOpponent;
import com.jbm.connect4.model.Token;
import com.jbm.connect4.model.User;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.columns;
import static org.junit.Assert.*;


public class BotOpponentTest {

    private Board board;
    private BotOpponent botOpponent;
    private Token redToken;


    @Before
    public void setUp() {
        board = new Board();
        botOpponent = new BotOpponent(board);
        redToken = new Token("Red");
    }

    @Test
    public void testBotProperlyDropsToken() {
        botOpponent.dropToken(redToken);

        boolean tokenAdded = false;
        for (int i = 0; i < 7; i++) {
            if (board.canDropToken(i)) {
                tokenAdded = true;
                break;
            }
        }

        assertTrue(tokenAdded);
    }


}

