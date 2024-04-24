package main;

import game.Game;
import game.state.State;
import map.Tile;
import object.Camera;

import java.awt.*;

public class Renderer {
    public void render(State state, Graphics graphics) {
        renderMap(state, graphics);
        Camera camera = state.getCamera();
        state.getGameObjects().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().intX() - camera.getPosition().intX() - Game.SPRITE_SIZE,
                gameObject.getPosition().intY() - camera.getPosition().intY() - Game.SPRITE_SIZE,
                null
        ));
    }

    private void renderMap(State state, Graphics graphics) {
        Tile[][] tiles = state.getGameMap().getTiles();
        Camera camera = state.getCamera();
        for(int i=0; i<tiles.length; i++) {
            for(int j=0; j<tiles[i].length; j++) {
                graphics.drawImage(
                        tiles[i][j].getSprite(),
                        i * Game.SPRITE_SIZE * 2 - camera.getPosition().intX(),
                        j * Game.SPRITE_SIZE * 2 - camera.getPosition().intY(),
                        null
                );
            }
        }
    }
}
