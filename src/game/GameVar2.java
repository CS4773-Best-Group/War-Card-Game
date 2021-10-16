package game;// IMPORTANT NOTE: THIS CLASS MAY NEED TO GET BROKEN UP DEPENDING ON SIZE OF FILE
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
        System.out.println("DEALING CARDS ========");
        deck.dealCards(player1, player2);
//        System.out.println("p1: " + player1.getNumCardsInHand());
//        System.out.println("p2: " + player2.getNumCardsInHand());
    }

    @Override
    public void startGame() {
        while (!isGameDone()){
            turn += 1;
            System.out.println("turn " + getTurn() + " =====================");
            playTurn();
        }
        System.out.println("WINNER: " + getWinner().getPlayerNum());
    }

    @Override
    public void playTurn() {
        Card card1 = player1.playHand();
        Card card2 = player2.playHand();
        pointsCounter += 2;
        System.out.println("P1 PLAYED: " + card1);
        System.out.println("P2 PLAYED: " + card2);
        if(card1.getRank() == card2.getRank() && !isGameDone()){
            declareWar();
        } else if (card1.getRank().compareTo(card2.getRank()) > 0){
            player1.addPoints(pointsCounter);
            System.out.println("player 1 wins | " + player1.getPoints() + "-" + player2.getPoints());
            pointsCounter = 0;
        } else {
            player2.addPoints(pointsCounter);
            System.out.println("player 2 wins | " + player1.getPoints() + "-" + player2.getPoints());
            pointsCounter = 0;
        }
    }

    @Override
    public void declareWar() {
        System.out.println("WAR");
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
