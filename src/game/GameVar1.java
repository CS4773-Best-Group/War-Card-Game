package game;

import models.Card;
import models.Deck;
import models.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class GameVar1 extends Game {
    int maxTurns;

    public GameVar1(Player player1, Player player2, int maxTurns) {
        this.player1 = player1;
        this.player2 = player2;
        this.maxTurns = maxTurns;
        winPile = new ArrayList<>();
        deck = new Deck();
        deck.shuffleDeck();
        deck.dealCards(player1, player2);
    }

    @Override
    void winTurn(Player player) {
        player.addToHand(winPile);
        winPile.clear();
        player1.setPoints(player1.getNumCardsInHand());
        player2.setPoints(player2.getNumCardsInHand());
        PrintUtil.printTurnResult(player1, player2, player);
    }

    @Override
    public boolean isGameDone() {
        if((player1.getNumCardsInHand() == 0) || (player2.getNumCardsInHand() == 0)) {
            return true;
        }
        else return turn == maxTurns;
    }
}
