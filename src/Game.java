public interface Game {
    public void startGame();
    public void playTurn();
    public void declareWar();
    public boolean isGameDone();
    public player getWinner();
    public void setTurn(int turnNum);
    public int getTurn();
}
