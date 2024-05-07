package mechanic.action;

import animation.AnimationManager;
import game.state.State;
import object.GameObject;

import java.awt.*;

public class Die implements Action{
    private GameObject objectWithAction;
    private int deathAnimationDuration;
    private AnimationManager deathAnimation;
    public Die(GameObject gameObject, String name) {
        objectWithAction = gameObject;
        deathAnimationDuration = 40;
        deathAnimation = new AnimationManager(State.spriteLibrary, name);
    }
    @Override
    public boolean playerUpdate(boolean isDead) {
        if(isDead) {
            deathAnimation.update();
            deathAnimationDuration--;
            if(deathAnimationDuration == 0) {
                deathAnimationDuration = 40;
                return false;
            }
        }
        return isDead;
    }

    @Override
    public boolean enemyUpdate(boolean isDead) {
        if(isDead) {
            deathAnimation.updateEnemySprite();
            deathAnimationDuration--;
            if(deathAnimationDuration == 0) {
                deathAnimationDuration = 40;
                return false;
            }
        }
        return isDead;
    }

    @Override
    public Image getEnemySprite() {
        return deathAnimation.getEnemySprite();
    }

    @Override
    public Image getSprite() {
        return deathAnimation.getSprite();
    }
}
