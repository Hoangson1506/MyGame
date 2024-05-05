package object;

import animation.AnimationManager;
import animation.SpriteLibrary;
import game.Game;
import game.state.State;
import math.Position;
import math.Size;
import mechanic.CollisionBox;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;
    protected AnimationManager animationManager;
    public GameObject(SpriteLibrary spriteLibrary, String name) {
        animationManager = new AnimationManager(spriteLibrary, name);
    }
    public abstract void update(State state);
    public abstract CollisionBox getCollisionBox();

    public abstract boolean collidesWith(GameObject other);

    public abstract void handleCollision(GameObject other);
    public Image getSprite() {
        return animationManager.getSprite();
    }
    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}
