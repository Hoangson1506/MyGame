package game.state;

import controller.KeyHandler;
import controller.MouseInput;
import game.Game;
import math.Size;
import object.Player;

public class EndState extends State{
    public EndState(Size windowSize, KeyHandler keyHandler, MouseInput mouseInput) {
        super(windowSize, keyHandler, mouseInput);
        endGame();
        if(Player.life <= 0) {
            playSE("GameOver");
        }
        else {
            playSE("LevelUp");
        }
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
