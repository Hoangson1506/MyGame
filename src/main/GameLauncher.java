package main;

import game.Game;
import game.GameLoop;

public class GameLauncher {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(800, 650))).start();
    }
}
