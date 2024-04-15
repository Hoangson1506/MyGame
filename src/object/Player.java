package object;

import controller.KeyHandler;
import math.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    KeyHandler keyHandler;
    public Player(KeyHandler keyHandler) {
        super();
        this.keyHandler = keyHandler;
    }
    @Override
    public void update() {
        int dX = 0, dY = 0;
        if(keyHandler.up) {
            dY--;
        }
        if(keyHandler.down) {
            dY++;
        }
        if(keyHandler.left) {
            dX--;
        }
        if(keyHandler.right) {
            dX++;
        }
        position = new Position(position.getX() + dX, position.getY() + dY);
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
