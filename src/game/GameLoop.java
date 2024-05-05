package game;

import game.Game;

public class GameLoop implements Runnable {
    private static final int TARGET_FPS = 60;
    private static final long TARGET_TIME = 1000000000 / TARGET_FPS;
    private Game game;
    private boolean running;
    public GameLoop(Game game) {
        this.game = game;
    }
    @Override
    public void run() {
        running = true;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            long elapsedTime = now - lastTime;
            delta += (double) elapsedTime / TARGET_TIME;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            render();
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
            }
        }
    }

    private void update() {
        game.update();
    }
    private void render() {
        game.render();
    }
}