package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for(Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit,rank));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void dealCards(Player p1, Player p2) {
        Queue<Card> p1Hand = new LinkedList<>(deck.subList(0, 26));
        Queue<Card> p2Hand = new LinkedList<>(deck.subList(26, deck.size()));
        p1.setHand(p1Hand);
        p2.setHand(p2Hand);
    }

    public int getCardsCount() {
        return this.deck.size();
    }

    boolean isEmpty() { return getCardsCount() == 0; }
}