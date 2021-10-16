package main;

import game.Game;
import game.GameVar1;
import game.GameVar2;
import models.Player;

public class Main {
    public static void main(String[] args) {
        // TODO: create and run game based on args
        Game game = new GameVar1(new Player(1), new Player(2), 1000);
        game.startGame();
    }
}
