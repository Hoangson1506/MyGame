package game.state;

import animation.SpriteLibrary;
import controller.KeyHandler;
import map.GameMap;
import math.Size;
import object.Camera;
import object.GameObject;
import object.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class State {
    GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected KeyHandler keyHandler;
    protected SpriteLibrary spriteLibrary;
    protected Camera camera;
    public State(Size windowSize, KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
        spriteLibrary = new SpriteLibrary();
        gameObjects = new ArrayList<>();
        gameMap = new GameMap(new Size(15, 15), spriteLibrary);
        camera = new Camera(windowSize);
    }
    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
        camera.update(this);
    }
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
    public GameMap getGameMap() {
        return gameMap;
    }

    public Camera getCamera() {
        return camera;
    }
}
