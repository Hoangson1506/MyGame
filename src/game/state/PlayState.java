package game.state;

import controller.KeyHandler;
import math.Size;
import object.Player;

public class PlayState extends State{
    public PlayState(Size windowSize, KeyHandler keyHandler) {
        super(windowSize, keyHandler);
        Player player = new Player(spriteLibrary, keyHandler);
        gameObjects.add(player);
        camera.focusOn(player);
    }

}
