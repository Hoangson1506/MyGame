package game.state;

import controller.KeyHandler;
import controller.MouseInput;
import math.Size;
import object.Player;

public class PlayState extends State{
    public PlayState(Size windowSize, KeyHandler keyHandler, MouseInput mouseInput) {
        super(windowSize, keyHandler, mouseInput);
        Player player = new Player(spriteLibrary, keyHandler, mouseInput);
        gameObjects.add(player);
        camera.focusOn(player);
    }
}
