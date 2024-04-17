package main;

import animation.SpriteLibrary;
import controller.KeyHandler;
import object.GameObject;
import object.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int SPRITE_SIZE = 32;
    private GameWindow gameWindow;
    private List<GameObject> gameObjects;
    KeyHandler keyHandler;
    SpriteLibrary spriteLibrary;
    public Game(int width, int height) {
        keyHandler = new KeyHandler();
        spriteLibrary = new SpriteLibrary();
        gameWindow = new GameWindow(width, height, keyHandler);
        gameObjects = new ArrayList<>();
        gameObjects.add(new Player(spriteLibrary, keyHandler));
    }
    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
    }
    public void render() {
        gameWindow.render(this);
    }
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
