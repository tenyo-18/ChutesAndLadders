package com.gameboard.chutesladders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ChutesAndLadders implements GameDirectives {

    private ChutesAndLaddersDice dice;
    public static final int WINNER = 100;
    private static final Map<Integer, Integer> CHUTES_AND_LADDERS = new HashMap<>();

    public ChutesAndLadders(ChutesAndLaddersDice dice){
        this.dice = dice;
        initChutesAndLadders();
    }

    private void initChutesAndLadders() {
        //Ladders
        CHUTES_AND_LADDERS.put(4, 14);
        CHUTES_AND_LADDERS.put(9, 31);
        CHUTES_AND_LADDERS.put(28, 84);
        CHUTES_AND_LADDERS.put(1, 38);
        CHUTES_AND_LADDERS.put(21, 42);
        CHUTES_AND_LADDERS.put(80, 100);
        CHUTES_AND_LADDERS.put(51, 67);
        CHUTES_AND_LADDERS.put(36, 44);
        CHUTES_AND_LADDERS.put(71, 91);

        //Chutes
        CHUTES_AND_LADDERS.put(16, 6);
        CHUTES_AND_LADDERS.put(47, 26);
        CHUTES_AND_LADDERS.put(49, 11);
        CHUTES_AND_LADDERS.put(62, 9);
        CHUTES_AND_LADDERS.put(98, 78);
        CHUTES_AND_LADDERS.put(95, 75);
        CHUTES_AND_LADDERS.put(93, 73);
        CHUTES_AND_LADDERS.put(56, 53);
        CHUTES_AND_LADDERS.put(87, 24);
        CHUTES_AND_LADDERS.put(64, 60);
    }

    @Override
    public List<Player> decidePlayerOrder(List<Player> playerList) {
        playerList.forEach(player -> player.setDiceOrder(dice.randomSpinner()));
        return  playerList.stream()
                .sorted(Comparator.comparingInt(Player::getDiceOrder).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void playGameInTurns(Player player) {
        int square = player.getCurrentScore();
        while(true){
            int roll = dice.randomSpinner();
            System.out.printf("\n%s: %d --> %d ", player.getName(), square, (square + roll));
            if (square + roll > 100) {
                System.out.printf("%s can't proceed, too hign a roll", player.getName());
                return;
            } else {
                square += roll;
                if (player.calcSquareIfWinning(square)) break;
                Integer newSquare = CHUTES_AND_LADDERS.getOrDefault(square, square);
                if(square < newSquare){
                    System.out.printf(" --LADDER--> %d.", newSquare);
                    square = newSquare;
                    if (player.calcSquareIfWinning(square)) break;
                } else if (square > newSquare) {
                    System.out.printf(" --CHUTE--> %d.", newSquare);
                    square = newSquare;
                }
                player.setCurrentScore(square);
                break;
            }
        }
    }

    public static void main(String s[]){
        ChutesAndLadders chutesAndLadders = new ChutesAndLadders(new ChutesAndLaddersDice());
        List<Player> playerList = initPlayers(Arrays.asList("Eric", "Paul"));
        playerList = chutesAndLadders.decidePlayerOrder(playerList);
        while (true) {
            for(Player player: playerList) {
                chutesAndLadders.playGameInTurns(player);
                if(player.isWinner()){
                    System.out.println("\nThe winner is "+ player.getName()+ " ! ");
                    System.exit(0);
                }
            }
        }
    }

    public static List<Player> initPlayers(List<String> playerNames){
        List<Player> playerList = new ArrayList();
        playerNames.forEach(s -> {
            playerList.add(new PlayerBuilder().setName(s).build());
        });
        return playerList;
    }
}
