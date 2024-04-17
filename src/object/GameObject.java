package object;

<<<<<<< HEAD
import animation.AnimationManager;
import animation.SpriteLibrary;
import main.Game;
=======
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
import math.Position;
import math.Size;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;
    public GameObject() {
<<<<<<< HEAD
        size = new Size(Game.SPRITE_SIZE, Game.SPRITE_SIZE);
        position = new Position(50, 50);
    }
    public abstract void update();
    public abstract Image getSprite() ;
=======
        size = new Size(50, 50);
        position = new Position(50, 50);
    }
    public abstract void update();
    public abstract Image getSprite();
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}
