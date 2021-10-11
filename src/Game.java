public interface Game {
    public void startGame();
    public void playTurn();
    public void declareWar();
    public void isGameDone();
    public void getWinner();
    public void setTurn(int turnNum);
    public void getTurn();
}
