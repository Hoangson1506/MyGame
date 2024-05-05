package object;

import animation.AnimationManager;
import animation.SpriteLibrary;
import controller.KeyHandler;
import game.Game;
import game.state.State;
import math.Position;
import math.Size;
import mechanic.CollisionBox;
import mechanic.Direction;
import mechanic.Movement;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    private KeyHandler keyHandler;

    private Movement movement;
    private double speed;
    private Direction direction;
    private static int maxLife;
    public static int life;
    public Player(SpriteLibrary spriteLibrary, KeyHandler keyHandler) {
        super(spriteLibrary, "player");
        size = new Size(Game.SPRITE_SIZE , Game.SPRITE_SIZE );
        position = new Position(50, 50);
        speed = 2;
        this.keyHandler = keyHandler;
        this.movement = new Movement(speed);
        this.direction = Direction.DOWN;
        maxLife = 100;
        life = maxLife;
    }
    @Override
    public void update(State state) {
        movement.update(keyHandler);
        handleCollisions(state);
        position.apply(movement);
        manageDirection();
        animationManager.update(direction);
        if(life <= 0) {
            state.getGameObjects().remove(this);
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
}
