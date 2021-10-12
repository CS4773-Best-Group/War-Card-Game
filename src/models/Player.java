package models;

import models.Card;

import java.util.Queue;

public class Player {
    Queue<Card> hand;
    int points;

    public void addToHand(Card card) {
        hand.add(card);
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
