package com.gameboard.chutesladders;


import java.util.Random;

public class ChutesAndLaddersDice implements RandomGenerator<Integer> {

    private Random random = new Random();
    public static final int DICE_MAX = 6;

    @Override
    public Integer randomSpinner() {
        // the upper bound is exclusive
        return random.nextInt(DICE_MAX) + 1;
    }
}
