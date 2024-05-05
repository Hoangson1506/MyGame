package mechanic;

import math.Vector2D;

public enum Direction {
    RIGHT(0),
    LEFT(1),
    DOWN(2),
    UP(3);
    private int animationRow;
    Direction(int animationRow) {
        this.animationRow = animationRow;
    }
    public static Direction getDirection(Movement movement) {
        double x = movement.getVector2D().getX();
        double y = movement.getVector2D().getY();
        if(x > 0) return RIGHT;
        if(x < 0) return LEFT;
        if(y > 0) return DOWN;
        if(y < 0) return UP;
        return null;
    }
    public static Direction getEnemyDirection(Vector2D vector2D) {
        double x = vector2D.getX();
        double y = vector2D.getY();
        if(x > 0) return RIGHT;
        if(x < 0) return LEFT;
        if(y > 0) return DOWN;
        if(y < 0) return UP;
        return RIGHT;
    }
    public int getAnimationRow() {
        return animationRow;
    }
}
