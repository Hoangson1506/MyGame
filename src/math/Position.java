package math;

import mechanic.Movement;

public class Position {
    private double x;
    private double y;
    public Position(int x, int y) {
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
    }
}
