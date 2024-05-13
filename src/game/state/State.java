package game.state;

import animation.SpriteLibrary;
import controller.KeyHandler;
import controller.MouseInput;
import map.GameMap;
import math.Size;
import mechanic.Spawner;
import object.Camera;
import object.GameObject;
import sound.Sound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class State {
    private GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected KeyHandler keyHandler;
    protected MouseInput mouseInput;
    public static SpriteLibrary spriteLibrary;
    protected Camera camera;
    protected Spawner spawner;
    protected Sound sound;
    public State(Size windowSize, KeyHandler keyHandler, MouseInput mouseInput) {
        this.keyHandler = keyHandler;
        this.mouseInput = mouseInput;
        spriteLibrary = new SpriteLibrary();
        gameObjects = new ArrayList<>();
        gameMap = new GameMap(new Size(30, 30), spriteLibrary);
        camera = new Camera(windowSize);
        spawner = new Spawner(this);
        sound = new Sound();
    }
    public void update() {
        spawner.update(this);
        new ArrayList<>(gameObjects).forEach(gameObject -> gameObject.update(this));
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
    public void playMusic(String name) {
        sound.setSound(name);
        sound.play();
        sound.loop();
    };
    public void stopMusic() {
        sound.stop();
    }
    public void playSE(String name) {
        sound.setSound(name);
        sound.play();
    }
}
