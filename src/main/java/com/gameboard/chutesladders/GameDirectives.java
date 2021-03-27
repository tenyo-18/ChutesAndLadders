package com.gameboard.chutesladders;

import java.util.List;

public interface GameDirectives {

    List<Player> decidePlayerOrder(List<Player> playerList);

    void playGameInTurns(Player player);
}
