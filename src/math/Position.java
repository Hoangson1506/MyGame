package math;

import map.GameMap;
import mechanic.Movement;

public class Position {
    private double x;
    private double y;
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public int intX() {
        return (int) Math.round(x);
    }
    public int intY() {
        return (int) Math.round(y);
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void apply(Movement movement) {
        Vector2D vector2D = movement.getVector2D();
        x += vector2D.getX();
        y += vector2D.getY();
        clampBoundaries();
    }
    private void clampBoundaries() {
        if(x < 0) x = 0;
        if(y < 0) y = 0;
        if(x > GameMap.getWidth()) x = GameMap.getWidth();
        if(y > GameMap.getHeight()) y = GameMap.getHeight();
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
