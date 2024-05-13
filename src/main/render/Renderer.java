package main.render;

import game.Game;
import game.state.MenuState;
import game.state.State;
import map.Tile;
import object.Camera;
import object.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Renderer {
    public synchronized void render(State state, Graphics graphics) {
        if(state instanceof MenuState) {
            renderMenu(state, graphics);
        }
        else {
            renderMap(state, graphics);
            renderGameObjects(state, graphics);
        }
    }
    private void renderGameObjects(State state, Graphics graphics) {
        Camera camera = state.getCamera();
        int cameraX = camera.getPosition().intX();
        int cameraY = camera.getPosition().intY();
        int halfSpriteSize = Game.SPRITE_SIZE / 2;

        for (GameObject gameObject : state.getGameObjects()) {
            if (camera.isInView(gameObject)) {
                Image sprite = gameObject.getSprite();
                int objX = gameObject.getPosition().intX() - cameraX - halfSpriteSize;
                int objY = gameObject.getPosition().intY() - cameraY - halfSpriteSize;

                graphics.drawImage(sprite, objX, objY, null);
            }
        }
    }
    private void renderMap(State state, Graphics graphics) {
        Tile[][] tiles = state.getGameMap().getTiles();
        Camera camera = state.getCamera();
        int cameraX = camera.getPosition().intX();
        int cameraY = camera.getPosition().intY();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Image sprite = tiles[i][j].getSprite();
                int tileX = i * Game.SPRITE_SIZE - cameraX;
                int tileY = j * Game.SPRITE_SIZE - cameraY;

                graphics.drawImage(sprite, tileX, tileY, null);
            }
        }
    }
    private void renderMenu(State state, Graphics graphics) {
        ((MenuState) state).renderMenu(graphics);
    }
}
