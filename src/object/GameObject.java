package object;

import animation.AnimationManager;
import animation.SpriteLibrary;
import game.Game;
import math.Position;
import math.Size;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;
    protected AnimationManager animationManager;
    public GameObject(SpriteLibrary spriteLibrary, String name) {
        animationManager = new AnimationManager(spriteLibrary, name);
        size = new Size(Game.SPRITE_SIZE , Game.SPRITE_SIZE );
        position = new Position(50, 50);
    }
    public abstract void update();
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
