package com.gameboard.chutesladders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChutesAndLaddersTest {

    private GameDirectives chutesAndLadders;
    private ChutesAndLaddersDice chutesAndLaddersDice;

    @BeforeEach
    public void setUp() {
        chutesAndLaddersDice = new ChutesAndLaddersDice();
        chutesAndLadders = new ChutesAndLadders(chutesAndLaddersDice);
    }

    @Test
    public void testPlayerOrder(){
        List<Player> playerList = createPlayers();
        chutesAndLadders.decidePlayerOrder(playerList);
        playerList.forEach(player -> {
            assertTrue(player.getDiceOrder() > 0);
        });
    }

    @Test
    public void testGameTurns(){
        List<Player> playerList = createPlayers();
        playerList.forEach(player -> {
            assertThat(player.getCurrentScore(), is(0));
        });
        playerList.stream().forEach(player -> chutesAndLadders.playGameInTurns(player));
        playerList.forEach(player -> {
            assertTrue(player.getCurrentScore() > 0);
        });
    }


    private List<Player> createPlayers(){
        List<Player> playerList = new ArrayList<>();
        playerList.add(new PlayerBuilder().setName("Test 1").build());
        playerList.add(new PlayerBuilder().setName("Test 2").build());
        return playerList;
    }
}
