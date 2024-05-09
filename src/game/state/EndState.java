package game.state;

import controller.KeyHandler;
import controller.MouseInput;
import game.Game;
import math.Size;

public class EndState extends State{
    public EndState(Size windowSize, KeyHandler keyHandler, MouseInput mouseInput) {
        super(windowSize, keyHandler, mouseInput);
        endGame();
    }
    @Override
    public void update() {
        super.update();
        if (keyHandler.restart) {
            gameObjects.clear();
            Game.startGame();
        }
    }
    private void endGame() {
        spawner.stop();
    }
}
