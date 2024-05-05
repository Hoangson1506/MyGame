package map;

import animation.SpriteLibrary;
import game.Game;
import math.Size;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GameMap {
    Tile[][] tiles;
    public GameMap(Size size, SpriteLibrary spriteLibrary) {
        tiles = new Tile[size.getWidth()][size.getHeight()];
        initTiles(spriteLibrary);
    }

    private void initTiles(SpriteLibrary spriteLibrary) {
        for(Tile[] row : tiles) {
            Arrays.fill(row, new Tile(spriteLibrary));
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public double getWidth() {
        return tiles.length * Game.SPRITE_SIZE;
    }
    public double getHeight() {
        return tiles[0].length * Game.SPRITE_SIZE;
    }
}
