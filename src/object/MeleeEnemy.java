package object;

import animation.SpriteLibrary;

import java.awt.*;

public class MeleeEnemy extends GameObject{

    public MeleeEnemy(SpriteLibrary spriteLibrary, String name) {
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
