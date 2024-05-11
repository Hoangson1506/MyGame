package game;

import controller.KeyHandler;
import controller.MouseInput;
import game.state.EndState;
import game.state.MenuState;
import game.state.PlayState;
import game.state.State;
import main.GameWindow;
import math.Size;

public class Game {
    public static int SPRITE_SIZE = 32;
    private GameWindow gameWindow;
    private static KeyHandler keyHandler;
    private static MouseInput mouseInput;
    private static State state;
    public static int width, height;
    public Game(int width, int height) {
        keyHandler = new KeyHandler();
        mouseInput = new MouseInput();
        gameWindow = new GameWindow(width, height, keyHandler, mouseInput);
        state = new MenuState(new Size(width, height), keyHandler, mouseInput);
        this.width = width;
        this.height = height;
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
    public static void endGame() {
        state = new EndState(new Size(width, height), keyHandler, mouseInput);
    }
    public static void startGame() {
        state = new PlayState(new Size(width, height), keyHandler, mouseInput);
    }
}
