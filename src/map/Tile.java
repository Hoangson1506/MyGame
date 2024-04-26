package map;

import animation.SpriteLibrary;

import java.awt.*;

public class Tile {
    private Image sprite;
    public Tile(SpriteLibrary spriteLibrary) {
        this.sprite = spriteLibrary.getTile("dirt_tile");
    }
    public Image getSprite() {
        return sprite;
    }
}
