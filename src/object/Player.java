package object;

import controller.KeyHandler;
import math.Position;
import mechanic.Movement;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    private KeyHandler keyHandler;
    private Movement movement;
    private double speed;
    public Player(KeyHandler keyHandler) {
        super();
        speed = 2;
        this.keyHandler = keyHandler;
        this.movement = new Movement(speed);
    }
    @Override
    public void update() {
        movement.update(keyHandler);
        position.apply(movement);
    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(0, 0, size.getWidth(), size.getHeight());
        return image;
    }
}
