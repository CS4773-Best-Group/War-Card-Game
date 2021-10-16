package game;
import models.Deck;
import models.Player;
import models.Card;

import java.util.ArrayList;
import java.util.Arrays;

public class GameVar2 implements Game {
    Player player1;
    Player player2;
    Deck deck;
    ArrayList<Card> winPile;
    int turn;

    public GameVar2(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
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
            player1.addPoints(winPile.size());
            winPile.clear();
            PrintUtil.printTurnResult(player1, player2, player1);
        } else {
            player2.addPoints(winPile.size());
            winPile.clear();
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
        return player1.getNumCardsInHand() == 0;
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
