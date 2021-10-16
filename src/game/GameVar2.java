package game;
import models.Deck;
import models.Player;
import models.Card;
public class GameVar2 implements Game {
    Player player1;
    Player player2;
    Deck deck;
    int turn;
    int pointsCounter;

    public GameVar2(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        pointsCounter = 0;
        deck = new Deck();
        deck.shuffleDeck();
        deck.dealCards(player1, player2);
    }

    @Override
    public void startGame() {
        while (!isGameDone()){
            turn += 1;
            playTurn();
        }
        if (getWinner() == null) {
            System.out.println("Game has ended in a TIE!");
        }
        System.out.println("Player " + getWinner().getPlayerNum() + " WINS the game!!!");
    }

    @Override
    public void playTurn() {
        Card card1 = player1.playHand();
        Card card2 = player2.playHand();
        pointsCounter += 2;
        System.out.println("Player 1 plays " + card1.toString());
        System.out.println("Player 2 plays " + card2.toString());
        if(card1.getRank() == card2.getRank() && !isGameDone()){
            declareWar();
        } else if (card1.getRank().compareTo(card2.getRank()) > 0){
            player1.addPoints(pointsCounter);
            System.out.println("Player 1 wins the round");
            System.out.println("Player 1 has a score of " + player1.getPoints());
            System.out.println("Player 2 has a score of " + player2.getPoints());
            pointsCounter = 0;
        } else {
            player2.addPoints(pointsCounter);
            System.out.println("Player 2 wins the round");
            System.out.println("Player 1 has a score of " + player1.getPoints());
            System.out.println("Player 2 has a score of " + player2.getPoints());
            pointsCounter = 0;
        }
    }

    @Override
    public void declareWar() {
        System.out.println("*** WAR! ***");
        if (player1.getNumCardsInHand() > 1 || player2.getNumCardsInHand() > 1) {
            player1.playHand();
            player2.playHand();
            pointsCounter += 2;
        }
        playTurn();
    }

    @Override
    public boolean isGameDone() {
        if (player1.getNumCardsInHand() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Player getWinner() {
        if (player1.getPoints() == player2.getPoints()) {
            return null;
        }
        if (player1.getPoints() > player2.getPoints()) {
            return player1;
        }
        return player2;
    }

    @Override
    public void setTurn(int turnNum) {
        turn = turnNum;
    }

    @Override
    public int getTurn() {
        return turn;
    }
}
