public class GameVar2 implements Game {
    Player player1;
    Player player2;
    Deck deck;
    int turn;
    int maxTurns;

    public GameVar2(Player player1, Player player2, int maxTurns) {
        this.player1 = player1;
        this.player2 = player2;
        this.maxTurns = maxTurns;
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
    public void isGameDone() {
        // TODO
    }

    @Override
    public void getWinner() {
        // TODO
    }

    @Override
    public void setTurn(int turnNum) {
        // TODO
    }

    @Override
    public void getTurn() {
        // TODO
    }
}
