public class GameLoop implements Runnable{
    GamePanel gamePanel;
    Thread thread;
    public GameLoop(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void run() {
        double FPS = 120;
        double drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime(), currentTime;
        double delta = 0;
        while(thread != null) {
            currentTime = System.nanoTime();
            delta = (currentTime - lastTime)/drawInterval;
            if(delta >= 1) {
                update();
                delta--;
            }
            render();
        }
    }
    public void update() {
        gamePanel.update();
    }
    public void render() {
        gamePanel.render();
    }
}
