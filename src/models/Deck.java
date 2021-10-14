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

    // TODO: not sure if we are sending in the correct information, returning a card for the hands or return a queue of cards
    public void dealCards(Player p1, Player p2) {
        // TODO: split deck into 2 and deal two players
        Queue<Card> p1Hand = new LinkedList<>(deck.subList(0, 26));
        Queue<Card> p2Hand = new LinkedList<>(deck.subList(26, deck.size()));
        p1.setHand(p1Hand);
        p2.setHand(p2Hand);
    }

    /**
     * @return number of cards left in the deck
     */
    public int getCardsCount() {
        return this.deck.size();
    }

    boolean isEmpty() {
        // TODO: ret true if all cards have been dealt (deck is empty)
        if (getCardsCount() == 0) {
            return true;
        }
        return false;
    }
}
