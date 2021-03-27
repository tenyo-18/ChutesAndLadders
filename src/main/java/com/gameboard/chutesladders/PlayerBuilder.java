package com.gameboard.chutesladders;

public class PlayerBuilder {
    private String name;
    private int currentScore = 0;
    private int diceOrder = 0;

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        return this;
    }

    public PlayerBuilder setDiceOrder(int diceOrder) {
        this.diceOrder = diceOrder;
        return this;
    }

    public Player build() {
        return new Player(name, currentScore, diceOrder);
    }
}