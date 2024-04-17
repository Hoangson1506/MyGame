package object;

<<<<<<< HEAD
import animation.AnimationManager;
import animation.SpriteLibrary;
=======
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
import controller.KeyHandler;
import math.Position;
import mechanic.Movement;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    private KeyHandler keyHandler;
<<<<<<< HEAD

    private Movement movement;
    private double speed;
    private AnimationManager animationManager;
    public Player(SpriteLibrary spriteLibrary, KeyHandler keyHandler) {
        super();
        animationManager = new AnimationManager(spriteLibrary, "player");
=======
    private Movement movement;
    private double speed;
    public Player(KeyHandler keyHandler) {
        super();
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
        speed = 2;
        this.keyHandler = keyHandler;
        this.movement = new Movement(speed);
    }
    @Override
    public void update() {
<<<<<<< HEAD
        animationManager.update();
=======
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
        movement.update(keyHandler);
        position.apply(movement);
    }

    @Override
    public Image getSprite() {
<<<<<<< HEAD
        return animationManager.getSprite();
    }


=======
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(0, 0, size.getWidth(), size.getHeight());
        return image;
    }
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
}
