import controller.KeyHandler;
import object.GameObject;
import object.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    GameWindow gameWindow;
    private List<GameObject> gameObjects;
    KeyHandler keyHandler;
    public Game(int width, int height) {
        keyHandler = new KeyHandler();
        gameWindow = new GameWindow(width, height, keyHandler);
        gameObjects = new ArrayList<>();
        gameObjects.add(new Player(keyHandler));
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
