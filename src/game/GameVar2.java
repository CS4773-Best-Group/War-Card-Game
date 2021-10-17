package game;
import models.Deck;
import models.Player;
import models.Card;

import java.util.ArrayList;
import java.util.Arrays;

public class GameVar2 extends Game {
    public GameVar2(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        winPile = new ArrayList<>();
        deck = new Deck();
        deck.shuffleDeck();
        deck.dealCards(player1, player2);
    }

    @Override
    void winTurn(Player player) {
        player.addPoints(winPile.size());
        winPile.clear();
        PrintUtil.printTurnResult(player1, player2, player);
    }

    @Override
    public boolean isGameDone() {
        return player1.getNumCardsInHand() == 0;
    }
}
