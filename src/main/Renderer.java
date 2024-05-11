package main;

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
        for (GameObject gameObject : state.getGameObjects()) {
            graphics.drawImage(
                    gameObject.getSprite(),
                    gameObject.getPosition().intX() - camera.getPosition().intX() - Game.SPRITE_SIZE/2,
                    gameObject.getPosition().intY() - camera.getPosition().intY() - Game.SPRITE_SIZE/2,
                    null
            );
        }
    }
    private void renderMap(State state, Graphics graphics) {
        Tile[][] tiles = state.getGameMap().getTiles();
        Camera camera = state.getCamera();
        for(int i=0; i<tiles.length; i++) {
            for(int j=0; j<tiles[i].length; j++) {
                graphics.drawImage(
                        tiles[i][j].getSprite(),
                        i * Game.SPRITE_SIZE - camera.getPosition().intX(),
                        j * Game.SPRITE_SIZE - camera.getPosition().intY(),
                        null
                );
            }
        }
    }
    private void renderMenu(State state, Graphics graphics) {
        ((MenuState) state).renderMenu(graphics);
    }
}
