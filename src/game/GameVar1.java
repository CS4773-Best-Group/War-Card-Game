package game;

import models.Deck;
import models.Player;

public class GameVar1 implements Game {
    Player player1;
    Player player2;
    Deck deck;
    int turn;
    int maxTurns;

    public GameVar1(Player player1, Player player2, int maxTurns) {
        this.player1 = player1;
        this.player2 = player2;
        this.maxTurns = maxTurns;
    }

    @Override
    public void startGame() {
        while (!isGameDone()) {
            playTurn();
        }
    }

    @Override
    public void playTurn() {
        // if (player1.playHand());
    }

    @Override
    public void declareWar() {
        // TODO
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
