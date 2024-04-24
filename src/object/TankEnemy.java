package object;

import animation.SpriteLibrary;

import java.awt.*;

public class TankEnemy extends GameObject{
    public TankEnemy(SpriteLibrary spriteLibrary, String name) {
        super(spriteLibrary, name);
    }

    @Override
    public void update() {

    }

    @Override
    public Image getSprite() {
        return null;
    }
}
