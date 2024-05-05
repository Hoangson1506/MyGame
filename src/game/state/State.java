package game.state;

import animation.SpriteLibrary;
import controller.KeyHandler;
import map.GameMap;
import math.Size;
import mechanic.Spawner;
import object.Camera;
import object.GameObject;
import object.MeleeEnemy;
import object.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class State {
    GameMap gameMap;
    protected List<GameObject> gameObjects;
    private List<GameObject> gameObjectsToRemove;
    protected KeyHandler keyHandler;
    protected SpriteLibrary spriteLibrary;
    protected Camera camera;
    Spawner spawner;
    public State(Size windowSize, KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
        spriteLibrary = new SpriteLibrary();
        gameObjects = new ArrayList<>();
        gameObjectsToRemove = new ArrayList<>();
        gameMap = new GameMap(new Size(30, 30), spriteLibrary);
        camera = new Camera(windowSize);
        spawner = new Spawner(this);
    }
    public void update() {
        spawner.update(this);
        new ArrayList<>(gameObjects).forEach(gameObject -> gameObject.update(this));
        camera.update(this);
        gameObjects.removeAll(gameObjectsToRemove);
        gameObjectsToRemove.clear();
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

    public SpriteLibrary getSpriteLibrary() {
        return spriteLibrary;
    }

    public List<GameObject> getCollidingObjects(GameObject gameObject) {
        return gameObjects.stream().filter(other -> other.collidesWith(gameObject)).collect(Collectors.toList());
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjectsToRemove.add(gameObject);
    }
}
