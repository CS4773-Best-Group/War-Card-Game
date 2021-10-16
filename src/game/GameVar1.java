package game;

import models.Card;
import models.Deck;
import models.Player;

import java.util.ArrayList;


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
        winPile = new ArrayList<Card>();
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
        if (getWinner() == null) {
            System.out.println("Game has ended in a TIE!");
        } else {
            System.out.println("Player " + getWinner().getPlayerNum() + " WINS the game!!!");
        }
    }

    @Override
    public void playTurn() {
        Card card1 = player1.playHand();
        Card card2 = player2.playHand();
        winPile.add(card1);
        winPile.add(card2);
        System.out.println("Player 1 plays " + card1.toString());
        System.out.println("Player 2 plays " + card2.toString());
        if(card1.getRank() == card2.getRank() && !isGameDone()){
            declareWar();
        } else if (card1.getRank().compareTo(card2.getRank()) > 0){
            player1.addToHand(winPile);
            winPile.clear();
            player1.setPoints(player1.getNumCardsInHand());
            player2.setPoints(player2.getNumCardsInHand());
            System.out.println("Player 1 wins the round");
            System.out.println("Player 1 has a score of " + player1.getPoints());
            System.out.println("Player 2 has a score of " + player2.getPoints());
        } else {
            player2.addToHand(winPile);
            winPile.clear();
            player1.setPoints(player1.getNumCardsInHand());
            player2.setPoints(player2.getNumCardsInHand());
            System.out.println("Player 2 wins the round");
            System.out.println("Player 1 has a score of " + player1.getPoints());
            System.out.println("Player 2 has a score of " + player2.getPoints());
        }
    }

    @Override
    public void declareWar() {
        System.out.println("*** WAR! ***");
        if (player1.getNumCardsInHand() > 1 || player2.getNumCardsInHand() > 1) {
            winPile.add(player1.playHand());
            winPile.add(player2.playHand());
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

    @Override
    public void setTurn(int turnNum) {
        this.turn = turnNum;
    }

    @Override
    public int getTurn() {
        return turn;
    }

}
