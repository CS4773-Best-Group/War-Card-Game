import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

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
        Queue<Card> p1Hand = null;
        Queue<Card> p2Hand = null;
        p1Hand.addAll(deck.subList(0, 25));
        p2Hand.addAll(deck.subList(26, deck.size()));
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
