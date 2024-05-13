package mechanic;

import game.state.State;
import math.Position;
import object.Camera;
import object.GameObject;
import object.MeleeEnemy;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Spawner {
    private Random random;
    private Camera camera;
    public static long spawnInterval;
    private long lastSpawnTime;
    private boolean isSpawning;

    public Spawner(State state) {
        random = new Random();
        camera = state.getCamera();
        spawnInterval = 1000;
        lastSpawnTime = System.currentTimeMillis();
        isSpawning = true;
    }

    public void update(State state) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSpawnTime >= spawnInterval && isSpawning) {
            spawnEnemy(state);
            lastSpawnTime = currentTime;
        }
    }

    public void spawnEnemy(State state) {
        // Calculate spawn position
        double x = calculateSpawnX();
        double y = calculateSpawnY();
        GameObject meleeEnemy = new MeleeEnemy(state.getSpriteLibrary(), "meleeEnemy", new Position(x, y), camera);
        state.getGameObjects().add(meleeEnemy);
    }

    private double calculateSpawnX() {
        int side = random.nextInt(2);
        double x;
        switch (side) {
            case 0:
                x = camera.getPosition().getX() - 200 + random.nextDouble() * 1000;
                break;
            case 1:
                x = camera.getPosition().getX() - 200 + random.nextDouble() * 1000;
                break;
            default:
                x = 0;
        }
        return x;
    }

    private double calculateSpawnY() {
        int side = random.nextInt(2);
        double y;
        switch (side) {
            case 0:
                y = camera.getPosition().getY() - 200 - random.nextDouble() * 200;
                break;
            case 1:
                y = camera.getPosition().getY() + camera.getHeight() + random.nextDouble() * 200;
                break;
            default:
                y = 0;
        }
        return y;
    }
    public void stop() {
        isSpawning = false;
    }
    public void start() {
        isSpawning = true;
    }
}
