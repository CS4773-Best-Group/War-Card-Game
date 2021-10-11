import java.util.Queue;

public class Player {
    Queue<Card> hand;
    int points;

    public void addToHand(Card c) {
        // TODO: add card to end of hand queue
        hand.add(0, c);
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
