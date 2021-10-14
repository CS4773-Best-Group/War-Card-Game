package main;

import game.Game;
import game.GameVar1;
import game.GameVar2;
import models.Player;

public class Main {
    public static void main(String[] args) {
        // TODO: create and run game based on args
        if (args.length < 1 || args.length > 2){
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        int gameVariation = Integer.parseInt(args[0]);
        int maxRounds = Integer.parseInt(args[1]);
        if (gameVariation == 1){
            Game game = new GameVar1(new Player(1), new Player(2), maxRounds);
        }
        Game game = new GameVar2(new Player(1), new Player(2));
        System.out.println("starting game");
        game.startGame();
        System.out.println("game done");
    }
}
