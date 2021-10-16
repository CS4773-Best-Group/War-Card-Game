package game;

import models.Player;

public interface Game {
    public void startGame();
    public void playTurn();
    public void declareWar();
    public boolean isGameDone();
    public Player getWinner();
}
