package com.gameboard.chutesladders;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gameboard.chutesladders.ChutesAndLaddersDice.DICE_MAX;

public class ChutesAndLaddersDiceTest {

    private ChutesAndLaddersDice dice;

    @BeforeEach
    public void setUp() {
        dice = new ChutesAndLaddersDice();
    }

    @Test
    public void testDiceValue() {
        int value = dice.randomSpinner();
        assertTrue(value <= DICE_MAX);
    }

}
