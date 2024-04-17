package object;

import animation.AnimationManager;
import animation.SpriteLibrary;
import controller.KeyHandler;
import math.Position;
import mechanic.Movement;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    private KeyHandler keyHandler;

    private Movement movement;
    private double speed;
    private AnimationManager animationManager;
    public Player(SpriteLibrary spriteLibrary, KeyHandler keyHandler) {
        super();
        animationManager = new AnimationManager(spriteLibrary, "player");
        speed = 2;
        this.keyHandler = keyHandler;
        this.movement = new Movement(speed);
    }
    @Override
    public void update() {
        animationManager.update();
        movement.update(keyHandler);
        position.apply(movement);
    }

    @Override
    public Image getSprite() {
        return animationManager.getSprite();
    }


}
