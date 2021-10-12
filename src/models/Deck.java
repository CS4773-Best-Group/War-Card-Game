package models;

import java.util.Queue;

public class Deck {
    Queue<Card> deck;

    public Deck() {
        // TODO: initialize a deck of shuffled cards
        // in a function, you can iterate through the enum suit and rank values to get all 52 cards
        // then maybe have a function to shuffle the cards
        deck = null;
    }
    
    Card dealCards(Player p1, Player p2) {
        // TODO: split deck into 2 and deal two players
        return null;
    }

    boolean isEmpty() {
        // TODO: ret true if all card have been dealt (deck is empty)
        return false;
    }
}
