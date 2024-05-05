package game;

import controller.KeyHandler;
import game.state.PlayState;
import game.state.State;
import main.GameWindow;
import math.Size;

public class Game {
    public static int SPRITE_SIZE = 32;
    private GameWindow gameWindow;
    private KeyHandler keyHandler;
    private static State state;

    public Game(int width, int height) {
        keyHandler = new KeyHandler();
        gameWindow = new GameWindow(width, height, keyHandler);
        state = new PlayState(new Size(width, height), keyHandler);
    }
    public static State getCurrentState() {
        return state;
    }
    public void update() {
        state.update();
    }
    public void render() {
        gameWindow.render(state);
    }

}
