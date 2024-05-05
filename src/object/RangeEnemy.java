package object;

import animation.SpriteLibrary;
import game.state.State;
import mechanic.CollisionBox;

import java.awt.*;

public class RangeEnemy extends GameObject{
    public RangeEnemy(SpriteLibrary spriteLibrary, String name) {
        super(spriteLibrary, name);
    }

    @Override
    public void update(State state) {

    }

    @Override
    public CollisionBox getCollisionBox() {
        return null;
    }

    @Override
    public boolean collidesWith(GameObject other) {
        return false;
    }

    @Override
    public void handleCollision(GameObject other) {

    }
    @Override
    public Image getSprite() {
        return null;
    }
}
