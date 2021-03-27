package com.gameboard.chutesladders;


import java.util.Objects;

import static com.gameboard.chutesladders.ChutesAndLadders.WINNER;

public class Player {

    private String name;
    private int currentScore;
    private int diceOrder;

    public Player(String name, int currentScore, int diceOrder){
        this.name = name;
        this.currentScore = currentScore;
        this.diceOrder = diceOrder;
    }

    public Player(String name){
        this(name, 0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getDiceOrder() {
        return diceOrder;
    }

    public void setDiceOrder(int diceOrder) {
        this.diceOrder = diceOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean calcSquareIfWinning(int square){
        if(square == WINNER){
            setCurrentScore(square);
            return true;
        }
        return false;
    }

    public boolean isWinner(){
        return currentScore == WINNER;
    }
}
