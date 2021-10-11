import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Deck {
    List<Card> deck = new LinkedList<>();

    public Deck() {
        for(Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(s,r));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    // TODO: not sure if we are sending in the correct information, returning a card for the hands or return a queue of cards
    public static<T> List[] dealCards(Player p1, Player p2) {
        // TODO: split deck into 2 and deal two players
        // SOMETHING LIKE THIS
        List<Card> p1Hand = new LinkedList();
        List<Card> p2Hand = new LinkedList();

        int size = deck.size();

        for (int i = 0; i < size; i++)
        {
            if (i < (size + 1)/2) {
                first.add(deck.get(i));
            }
            else {
                second.add(deck.get(i));
            }
        }
        return new List [] {p1Hand, p2Hand};
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
