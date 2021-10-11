import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Deck {
    Queue<Card> deck = new LinkedList<>();

    public Deck() {
        // TODO: initialize a deck of shuffled cards
        // in a function, you can iterate through the enum suit and rank values to get all 52 cards
        for(Suit s : Suit.values()) {
            for (Rank e : Rank.values()) {
                deck.add(new Card(r,s));
            }
        }
        // then maybe have a function to shuffle the cards
        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }
    
    Card dealCards(Player p1, Player p2) {
        // TODO: split deck into 2 and deal two players
        return null;
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
            return true
        }
        return false;
    }
}
