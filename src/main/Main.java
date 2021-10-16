package main;

import game.Game;
import game.GameVar2;
import models.Player;

public class Main {
    public static void main(String[] args) {
        // TODO: create and run game based on args
        Game game = new GameVar2(new Player(1), new Player(2));
        System.out.println("starting game");
        game.startGame();
        System.out.println("game done");
    }
}
