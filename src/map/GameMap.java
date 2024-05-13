package map;

import animation.SpriteLibrary;
import game.Game;
import math.Size;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GameMap {
    private static Tile[][] tiles;
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

    public static double getWidth() {
        return tiles.length * Game.SPRITE_SIZE;
    }
    public static double getHeight() {
        return tiles[0].length * Game.SPRITE_SIZE;
    }
}
