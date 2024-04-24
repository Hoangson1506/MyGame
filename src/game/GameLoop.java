package game;

import game.Game;

public class GameLoop implements Runnable{
    Game game;
    boolean running;
    public GameLoop(Game game) {
        this.game = game;
    }
    @Override
    public void run() {
        running = true;
        double FPS = 120;
        double drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        double delta = 0;
        long currentTime;
        while(running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/ drawInterval;
            lastTime = System.nanoTime();
            if (delta >= 1) {
                update();
                render();
                delta--;
            }
        }
    }
    public void update() {
        game.update();
    }
    public void render() {
        game.render();
    }
}
