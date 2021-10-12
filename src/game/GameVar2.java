package game;// IMPORTANT NOTE: THIS CLASS MAY NEED TO GET BROKEN UP DEPENDING ON SIZE OF FILE
import models.Deck;
import models.Player;
import models.Card;
public class GameVar2 implements Game {
    Player player1;
    Player player2;
    Deck deck;
    int turn;

    public GameVar2(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        //deck split

    }

    @Override
    public void startGame() {
        // TODO
        while (!isGameDone()){
            playTurn();
        }
    }

    @Override
    public void playTurn() {
        // TODO
        Card card1 = player1.playHand();
        Card card2 = player2.playHand();
        if(card1.getRank() == card2.getRank()){
            declareWar(card1, card2);
        } else if (card1.getRank().compareTo(card2.getRank()) > 0){
            player1.addPoints(2);
        } else {
            player2.addPoints(2);
        }


    }

    @Override
    public void declareWar(Card card1, Card card2) {
        // TODO

        if (card1.getRank().compareTo(card2.getRank()) > 0){
            player1.addPoints(6);
        } else {
            player2.addPoints(6);
        }
    }

    @Override
    public boolean isGameDone() {
        // TODO

        return false;
    }

    @Override
    public Player getWinner() {
        // TODO
        return null;
    }

    @Override
    public void setTurn(int turnNum) {
        // TODO
    }

    @Override
    public int getTurn() {
        // TODO
        return 0;
    }
}
