package object.projectile;

import animation.SpriteLibrary;
import game.state.State;
import math.Position;
import math.Vector2D;
import mechanic.CollisionBox;
import object.GameObject;

import java.awt.*;
import java.util.Iterator;

public class Projectile extends GameObject {
    Vector2D speed;
    public Projectile(SpriteLibrary spriteLibrary, String name) {
        super(spriteLibrary, name);
        speed = new Vector2D(0, 0);
        position = new Position(0, 0);
    }

    @Override
    public void update(State state) {
        handleCollisions(state);
        double projectileX = position.getX();
        double projectileY = position.getY();
        position.setX(projectileX + speed.getX());
        position.setY(projectileY + speed.getY());
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox(
                new Rectangle(
                        position.intX(),
                        position.intY(),
                        20, 20
                )
        );
    }

    @Override
    public boolean collidesWith(GameObject other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    @Override
    public void handleCollision(GameObject other) {

    }
    private void handleCollisions(State state) {
        Iterator<GameObject> iterator = state.getCollidingObjects(this).iterator();
        while (iterator.hasNext()) {
            GameObject gameObject = iterator.next();
            handleCollision(gameObject);
        }
    }
}
