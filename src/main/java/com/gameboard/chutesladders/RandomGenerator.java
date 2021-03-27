package com.gameboard.chutesladders;

/**
 * A template generic interface for random spinners, dice implementations or other implementations to
 * implement for all game variants
 */
public interface RandomGenerator<T> {

    /**
     * Returns a next implementation of the spinner implemented underneath
     * to play the game
     * @return
     */
    T randomSpinner();

}
