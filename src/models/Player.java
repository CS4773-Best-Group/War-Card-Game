package models;

import java.util.ArrayList;
import java.util.Queue;

public class Player {
    Queue<Card> hand;
    int playerNum;
    int points;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        points = 0;
    }

    public void addToHand(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    public Card playHand(){
        return hand.remove();
    }

    public void setHand(Queue<Card> hand) {
        this.hand = hand;
    }

    public int getNumCardsInHand() {
        return hand.size();
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void addPoints(int points) {
        setPoints(getPoints() + points);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
