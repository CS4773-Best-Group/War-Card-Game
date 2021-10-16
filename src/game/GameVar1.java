package game;

import models.Card;
import models.Deck;
import models.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class GameVar1 implements Game {
    Player player1;
    Player player2;
    Deck deck;
    ArrayList<Card> winPile;
    int turn;
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
    public void startGame() {
        while (!isGameDone()){
            turn += 1;
            playTurn();
        }
        PrintUtil.printGameResult(getWinner());
    }

    @Override
    public void playTurn() {
        Card card1 = player1.playHand();
        Card card2 = player2.playHand();
        winPile.addAll(Arrays.asList(card1, card2));
        PrintUtil.printPlay(card1, card2);
        if(card1.getRank() == card2.getRank() && !isGameDone()){
            declareWar();
        } else if (card1.getRank().compareTo(card2.getRank()) > 0){
            player1.addToHand(winPile);
            winPile.clear();
            player1.setPoints(player1.getNumCardsInHand());
            player2.setPoints(player2.getNumCardsInHand());
            PrintUtil.printTurnResult(player1, player2, player1);
        } else {
            player2.addToHand(winPile);
            winPile.clear();
            player1.setPoints(player1.getNumCardsInHand());
            player2.setPoints(player2.getNumCardsInHand());
            PrintUtil.printTurnResult(player1, player2, player2);
        }
    }

    @Override
    public void declareWar() {
        PrintUtil.printWar();
        if (player1.getNumCardsInHand() > 1 || player2.getNumCardsInHand() > 1) {
            winPile.addAll(Arrays.asList(player1.playHand(), player2.playHand()));
        }
        playTurn();
    }

    @Override
    public boolean isGameDone() {
        if((player1.getNumCardsInHand() == 0) || (player2.getNumCardsInHand() == 0)) {
            return true;
        }
        else return turn == maxTurns;
    }

    @Override
    public Player getWinner() {
        if (player1.getPoints() == player2.getPoints()) {
            return null;
        }
        if (player1.getPoints() > player2.getPoints()) {
            return player1;
        }
        return player2;
    }
}
