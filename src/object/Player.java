package object;

import animation.AnimationManager;
import animation.SpriteLibrary;
import controller.KeyHandler;
import math.Position;
import mechanic.Direction;
import mechanic.Movement;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    private KeyHandler keyHandler;

    private Movement movement;
    private double speed;
    Direction direction;
    public Player(SpriteLibrary spriteLibrary, KeyHandler keyHandler) {
        super(spriteLibrary, "player");
        speed = 2;
        this.keyHandler = keyHandler;
        this.movement = new Movement(speed);
        this.direction = Direction.DOWN;
    }
    @Override
    public void update() {
        movement.update(keyHandler);
        position.apply(movement);
        manageDirection();
        animationManager.update(direction);
    }

    private void manageDirection() {
        if(movement.isMoving()) {
            direction = Direction.getDirection(movement);
        }
    }
}
