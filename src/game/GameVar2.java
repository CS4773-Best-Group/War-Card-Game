package game;// IMPORTANT NOTE: THIS CLASS MAY NEED TO GET BROKEN UP DEPENDING ON SIZE OF FILE
import models.Deck;
import models.Player;

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
        

    }

    @Override
    public void playHand(){
        //TODO
    }

    @Override
    public void declareWar() {
        // TODO
    }

    @Override
    public boolean isGameDone() {
        // TODO
        if (deck.)
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
