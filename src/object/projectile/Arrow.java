package object.projectile;

import animation.SpriteLibrary;
import game.state.State;
import math.Position;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Arrow extends Projectile {
    private int lifespan;
    private int frameCount;
    private int angle;
    public static int damage;
    public Arrow(SpriteLibrary spriteLibrary, String name) {
        super(spriteLibrary, name);
        lifespan = 90;
        angle = 0;
        damage = 10;
    }
    public void setSpeed(Vector2D velocity) {
        speed = velocity;
    }
    public void setPosition(double x, double y) {
        position = new Position(x, y);
    }
    public void update(State state) {
        super.update(state);
        frameCount++;
        if(frameCount >= lifespan) {
            state.getGameObjects().remove(this);
        }
    }
}
