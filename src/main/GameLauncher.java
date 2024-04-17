package main;

import main.Game;

public class GameLauncher {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(800, 650))).start();
    }
}
