package game;

import models.Card;
import models.Player;

public class PrintUtil {
    public static void printPlay(Card card1, Card card2) {
        System.out.println("Player 1 plays " + card1.toString());
        System.out.println("Player 2 plays " + card2.toString());
    }

    public static void printGameResult(Player winner) {
        if (winner == null) {
            System.out.println("Game has ended in a TIE!");
        } else {
            System.out.println("Player " + winner.getPlayerNum() + " WINS the game!!!");
        }
    }

    public static void printTurnResult(Player player1, Player player2, Player winner) {
        System.out.println("Player " + winner.getPlayerNum() + " wins the round");
        System.out.println("Player 1 has a score of " + player1.getPoints());
        System.out.println("Player 2 has a score of " + player2.getPoints());
    }

    public static void printWar() {
        System.out.println("*** WAR! ***");
    }
}
