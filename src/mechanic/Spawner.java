package mechanic;

import game.state.State;
import math.Position;
import object.Camera;
import object.MeleeEnemy;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Spawner {
    private Random random;
    private Camera camera;
    private long spawnInterval;
    private long lastSpawnTime;

    public Spawner(State state) {
        random = new Random();
        camera = state.getCamera();
        spawnInterval = 500; // Set the spawn interval to 1 seconds
        lastSpawnTime = System.currentTimeMillis();
    }

    public void update(State state) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSpawnTime >= spawnInterval) {
            spawnEnemy(state);
            lastSpawnTime = currentTime;
        }
    }

    public void spawnEnemy(State state) {
        // Calculate spawn position
        double x = calculateSpawnX();
        double y = calculateSpawnY();

        // Create and add enemy to game objects
        state.getGameObjects().add(new MeleeEnemy(state.getSpriteLibrary(), "meleeEnemy", new Position(x, y), camera));
    }

    private double calculateSpawnX() {
        int side = random.nextInt(2);
        double x;
        switch (side) {
            case 0:
                // Left side of the camera
                x = camera.getPosition().getX() - 200 + random.nextDouble() * 1000;
                break;
            case 1:
                // Right side of the camera
                x = camera.getPosition().getX() - 200 + random.nextDouble() * 1000;
                break;
            default:
                x = 0; // Default to 0 in case of unexpected side
        }
        return x;
    }

    private double calculateSpawnY() {
        int side = random.nextInt(2);
        double y;
        switch (side) {
            case 0:
                // Top side of the camera
                y = camera.getPosition().getY() - 200 - random.nextDouble() * 200;
                break;
            case 1:
                // Bottom side of the camera
                y = camera.getPosition().getY() + camera.getHeight() + random.nextDouble() * 200;
                break;
            default:
                y = 0; // Default to 0 in case of unexpected side
        }
        return y;
    }
}
