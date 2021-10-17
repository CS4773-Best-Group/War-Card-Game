package game;

import models.Card;
import models.Deck;
import models.Player;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Game {
    Player player1;
    Player player2;
    Deck deck;
    ArrayList<Card> winPile;
    int turn;

    public final void startGame() {
        while (!isGameDone()){
            turn += 1;
            playTurn();
        }
        PrintUtil.printGameResult(getWinner());
    }

    public void playTurn() {
        Card card1 = player1.playHand();
        Card card2 = player2.playHand();
        winPile.addAll(Arrays.asList(card1, card2));
        PrintUtil.printPlay(card1, card2);
        if(card1.getRank() == card2.getRank() && !isGameDone()) {
            declareWar();
        } else if (card1.getRank().compareTo(card2.getRank()) > 0) {
            winTurn(player1);
        } else {
            winTurn(player2);
        }
    }

    public void declareWar() {
        PrintUtil.printWar();
        if (player1.getNumCardsInHand() > 1 || player2.getNumCardsInHand() > 1) {
            winPile.addAll(Arrays.asList(player1.playHand(), player2.playHand()));
        }
        playTurn();
    }

    public Player getWinner() {
        if (player1.getPoints() == player2.getPoints()) {
            return null;
        }
        if (player1.getPoints() > player2.getPoints()) {
            return player1;
        }
        return player2;
    }

    abstract void winTurn(Player player);

    abstract boolean isGameDone();
}
