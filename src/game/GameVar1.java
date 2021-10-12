package game;

import models.Card;
import models.Deck;
import models.Player;

public class GameVar1 implements Game {
    Player player1;
    Player player2;
    int turn;
    int maxTurns;

    public GameVar1(Player player1, Player player2, int maxTurns) {
        this.player1 = player1;
        this.player2 = player2;
        this.maxTurns = maxTurns;
    }

    @Override
    public void startGame() {
        Deck deck = new Deck();
        deck.shuffleDeck();
        deck.dealCards(player1, player2);
        while (!isGameDone()) {
            playTurn();
        }
    }

    @Override
    public void playTurn() {
        Card card1 = player1.playHand();
        Card card2 = player2.playHand();

        if (card1.getRank() == card2.getRank()) {
            declareWar();
        } else if (card1.getRank().compareTo(card2.getRank()) > 0) { // player 1 wins
            player1.addToHand(card1);
            player1.addToHand(card2);
            player1.addPoints(2);
        } else { // player 2 wins
            player2.addToHand(card1);
            player2.addToHand(card2);
            player2.addPoints(2);
        }
    }

    @Override
    public void declareWar() {
        // TODO
    }

    @Override
    public boolean isGameDone() {
        // TODO
        return false;
    }

    @Override
    public Player getWinner() {
        // TODO
        return null;
    }

    @Override
    public void setTurn(int turnNum) {
        this.turn = turnNum;
    }

    @Override
    public int getTurn() {
        return turn;
    }
}
