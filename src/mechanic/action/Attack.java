package mechanic.action;

import animation.AnimationManager;
import game.Game;
import game.state.State;
import object.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Attack implements Action{
    private AnimationManager attackAnimation;
    GameObject objectWithAction;
    private int attackDuration;
    public Attack(GameObject gameObject, String name) {
        attackAnimation = new AnimationManager(State.spriteLibrary, name);
        objectWithAction = gameObject;
        attackDuration = 80;
    }
    @Override
    public boolean playerUpdate(boolean isAttacking) {
        if(isAttacking) {
            attackAnimation.update(objectWithAction.getDirection());
            attackDuration--;
            if(attackDuration == 0) {
                attackDuration = 80;
                return false;
            }
        }
        return isAttacking;
    }

    @Override
    public boolean enemyUpdate(boolean isAttacking) {
        if (isAttacking) {
            attackAnimation.updateEnemySprite(objectWithAction.getDirection());
            attackDuration--;
            if (attackDuration == 0) {
                attackDuration = 80;
                return false;
            }
        }
        return isAttacking;
    }
    @Override
    public Image getEnemySprite() {
        return attackAnimation.getEnemySprite();
    }

    @Override
    public Image getSprite() {
        return attackAnimation.getSprite();
    }
}
