package mechanic.action;

import animation.AnimationManager;
import game.state.State;
import object.GameObject;

import java.awt.*;

public class TakeHit implements Action {
    private GameObject objectWithAction;
    private int takeHitDuration;
    private AnimationManager takeHitAnimation;
    public TakeHit(GameObject gameObject, String name) {
        objectWithAction = gameObject;
        takeHitDuration = 40;
        takeHitAnimation = new AnimationManager(State.spriteLibrary, name);
    }
    @Override
    public boolean playerUpdate(boolean isDead) {
        if(isDead) {
            takeHitAnimation.update();
            takeHitDuration--;
            if(takeHitDuration == 0) {
                takeHitDuration = 40;
                return false;
            }
        }
        return isDead;
    }

    @Override
    public boolean enemyUpdate(boolean isDead) {
        if(isDead) {
            takeHitAnimation.updateEnemySprite();
            takeHitDuration--;
            if(takeHitDuration == 0) {
                takeHitDuration = 40;
                return false;
            }
        }
        return isDead;
    }

    @Override
    public Image getEnemySprite() {
        return takeHitAnimation.getEnemySprite();
    }

    @Override
    public Image getSprite() {
        return takeHitAnimation.getSprite();
    }
}
