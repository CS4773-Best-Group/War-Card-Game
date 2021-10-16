package main;

import game.Game;
import game.GameVar1;
import game.GameVar2;
import models.Player;

public class Main {
    public static void main(String[] args) {
        int gameVariation = Integer.parseInt(args[0]);
        int maxRounds = Integer.parseInt(args[1]);
        Game game;
        if (gameVariation == 1){
            game = new GameVar1(new Player(1), new Player(2), maxRounds);
        }
        else {
            game = new GameVar2(new Player(1), new Player(2));
        }
        game.startGame();
    }
}