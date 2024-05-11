package object;

import animation.AnimationManager;
import animation.SpriteLibrary;
import controller.KeyHandler;
import controller.MouseInput;
import game.Game;
import game.state.State;
import math.Position;
import math.Size;
import math.Vector2D;
import mechanic.CollisionBox;
import mechanic.Direction;
import mechanic.Movement;
import object.projectile.Arrow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    //Input handler
    private KeyHandler keyHandler;
    private MouseInput mouseInput;
    private Movement movement;
    private Arrow arrow;
    // Player's stats
    private double speed;
    private static int maxLife;
    public static int life;
    private int arrowSpeed;
    private long lastShootTime;
    private long shootCooldown;
    public Player(SpriteLibrary spriteLibrary, KeyHandler keyHandler, MouseInput mouseInput) {
        super(spriteLibrary, "player");
        size = new Size(Game.SPRITE_SIZE , Game.SPRITE_SIZE );
        position = new Position(50, 50);
        speed = 2;
        this.keyHandler = keyHandler;
        this.mouseInput = mouseInput;
        this.movement = new Movement(speed);
        this.direction = Direction.DOWN;
        maxLife = 100;
        life = maxLife;
        arrowSpeed = 6;
        shootCooldown = 800; // in milisecs
        lastShootTime = System.currentTimeMillis();
    }
    @Override
    public void update(State state) {
        handleCollisions(state);
        movement.update(keyHandler);
        position.apply(movement);
        handleShooting(state);
        manageDirection();
        animationManager.update(direction);
        if(life <= 0) {
            Game.endGame();
        }
    }
    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox(
                new Rectangle(
                        position.intX() - Game.SPRITE_SIZE/2,
                        position.intY() - Game.SPRITE_SIZE/2,
                        24,
                        24
                )
        );
    }
    private void handleCollisions(State state) {
        state.getCollidingObjects(this).forEach(this::handleCollision);
    }
    @Override
    public boolean collidesWith(GameObject other) {
        if(other == null || other.getCollisionBox() == null) {
            return false;
        }
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    @Override
    public void handleCollision(GameObject other) {
        // do nothing
    }
    private void manageDirection() {
        if(movement.isMoving()) {
            direction = Direction.getDirection(movement);
        }
    }
    private Vector2D calculateProjectileSpeed(State state) {
        double mouseX = mouseInput.getMousePosition().getX() + state.getCamera().getPosition().getX();
        double mouseY = mouseInput.getMousePosition().getY() + state.getCamera().getPosition().getY();


        double arrowX = mouseX - position.getX();
        double arrowY = mouseY - position.getY();

        double length = Math.sqrt(arrowX * arrowX + arrowY * arrowY);
        arrowX /= length;
        arrowY /= length;

        return new Vector2D(arrowX * arrowSpeed, arrowY * arrowSpeed);
    }
    private void handleShooting(State state) {
        if (mouseInput.shoot && System.currentTimeMillis() - lastShootTime >= shootCooldown) {
            shoot(state);
            lastShootTime = System.currentTimeMillis();
        }
    }

    private void shoot(State state) {
        Arrow arrow = new Arrow(state.getSpriteLibrary(), "Arrow");
        arrow.setPosition(position.getX(), position.getY());
        Vector2D arrowSpeed = calculateProjectileSpeed(state);
        arrow.setSpeed(arrowSpeed);
        state.getGameObjects().add(arrow);
    }
}
