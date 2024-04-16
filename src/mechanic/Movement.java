package mechanic;

import controller.KeyHandler;
import math.Vector2D;

public class Movement {
    private Vector2D vector2D;
    private double speed;
    public Movement(double speed) {
        this.speed = speed;
        vector2D = new Vector2D(0, 0);
    }
    public void update(KeyHandler keyHandler) {
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
        vector2D = new Vector2D(dX, dY);
        vector2D.normalize();
        vector2D.multiply(speed);
    }
    public Vector2D getVector2D() {
        return vector2D;
    }
}
