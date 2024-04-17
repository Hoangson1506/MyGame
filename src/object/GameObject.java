package object;

import animation.AnimationManager;
import animation.SpriteLibrary;
import main.Game;
import math.Position;
import math.Size;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;
    public GameObject() {
        size = new Size(Game.SPRITE_SIZE, Game.SPRITE_SIZE);
        position = new Position(50, 50);
    }
    public abstract void update();
    public abstract Image getSprite() ;
    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}
