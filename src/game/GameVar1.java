package game;

import models.Card;
import models.Deck;
import models.Player;



public class GameVar1 implements Game {
    Player player1;
    Player player2;
    int turn;
    int maxTurns;
    private static final int TOTAL_NUM_CARDS = 52;

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
//        int totPoints = 6;
//        while(card1.getRank() == card2.getRank()){
//            totPoints = totPoints + 4;
//        }
//        if(card1.getRank().compareTo(card2.getRank()) > 0){
//            player1.addToHand(card1);
//            player1.addToHand(card2);
//            player1.addPoints(totPoints);
//        } else {
//            player2.addToHand(card1);
//            player2.addToHand(card2);
//            player2.addPoints(totPoints);
//        }
    }

    @Override
    public boolean isGameDone() {
        //a) one player has won all of the cards
        if((player1.getNumCardsInHand() == TOTAL_NUM_CARDS) || (player2.getNumCardsInHand() == TOTAL_NUM_CARDS)) {
            return true;
        }
        // 2) a predetermined number of rounds has been played. The winner is the player with the most cards at the end of the game.
        else if(turn == maxTurns) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Player getWinner() {
        if(player1.getPoints() > player2.getPoints()){
            return player1;
        } else {
            return player2;
        }
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
