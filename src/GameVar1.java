// IMPORTANT NOTE: THIS CLASS MAY NEED TO GET BROKEN UP DEPENDING ON SIZE OF FILE

public class GameVar1 implements Game {
    Player player1;
    Player player2;
    Deck deck;
    int turn;

    public GameVar1(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void startGame() {
        // TODO
    }

    @Override
    public void playTurn() {
        // TODO
    }

    @Override
    public void declareWar() {
        // TODO
    }

    @Override
    public boolean isGameDone() {
        // TODO
    }

    @Override
    public Player getWinner() {
        // TODO
    }

    @Override
    public int setTurn(int turnNum) {
        // TODO
    }

    @Override
    public void getTurn() {
        // TODO
    }
}
