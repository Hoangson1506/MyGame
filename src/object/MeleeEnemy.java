package object;

import animation.SpriteLibrary;
import game.Game;
import game.state.State;
import math.Position;
import math.Size;
import math.Vector2D;
import mechanic.CollisionBox;
import mechanic.Direction;
import mechanic.Spawner;
import mechanic.action.Attack;
import mechanic.action.Die;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MeleeEnemy extends GameObject{
    private Spawner spawner;
    private Camera camera;
    private Vector2D vector2D;
    private double speed;
    private GameObject player;
    private boolean isAttacking;
    private Attack attack;
    private boolean isDead;
    private Die die;
    private int life;
    private int attackDuration;
    private int deathDuration;
    public MeleeEnemy(SpriteLibrary spriteLibrary, String name, Position position, Camera camera) {
        super(spriteLibrary, name);
        this.position = position;
        this.direction = Direction.RIGHT;
        size = new Size(Game.SPRITE_SIZE * 2, Game.SPRITE_SIZE * 2);
        this.camera = camera;
        vector2D = new Vector2D(1, 1);
        speed = 1.2;
        this.player = camera.getObjectWithFocus().get();
        attack = new Attack(this, "SkeletonAttack");
        die = new Die(this, "SkeletonDeath");
        isDead = false;
        isAttacking = false;
        attackDuration = 40;
        deathDuration = 40;
        life = 100;
    }
    @Override
    public void update(State state) {
        handleCollisions(state);
        if(isDead) {
            isDead = die.enemyUpdate(isDead);
            deathDuration--;
            if(deathDuration<=0) {
                state.getGameObjects().remove(this);
            }
        }
        else if(isAttacking) {
            isAttacking = attack.enemyUpdate(isAttacking);
            attackDuration--;
        }
        else {
            vector2D = getEnemyVector();
            vector2D.normalize();
            vector2D.multiply(speed);
            position.setX(position.getX() + vector2D.getX());
            position.setY(position.getY() + vector2D.getY());
            manageDirection();
            animationManager.updateEnemySprite(direction);
        }
    }
    private Vector2D getEnemyVector() {
        double currentX = position.getX();
        double currentY = position.getY();
        double directionX = player.getPosition().getX() - currentX;
        double directionY = player.getPosition().getY() - currentY;
        return new Vector2D(directionX, directionY);
    }
    private void handleCollisions(State state) {
        Iterator<GameObject> iterator = state.getCollidingObjects(this).iterator();
        while (iterator.hasNext()) {
            GameObject gameObject = iterator.next();
            handleCollision(gameObject);
        }
    }


    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox(
                new Rectangle(
                        position.intX(),
                        position.intY(),
                        32,
                        32
                )
        );
    }

    @Override
    public boolean collidesWith(GameObject other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    @Override
    public void handleCollision(GameObject other) {
        if(other instanceof Player) {
            isAttacking = true;
            if(attackDuration == 0) {
                Player.life -= 3;
                attackDuration = 40;
            }
            life--;
            if(life <= 0) {
                isDead = true;
            }
        }
    }

    private void manageDirection() {
        direction = Direction.getEnemyDirection(vector2D);
    }
    @Override
    public Image getSprite() {
        if(isDead) {
            return die.getEnemySprite();
        }
        if(isAttacking) {
            return attack.getEnemySprite();
        }
        return animationManager.getEnemySprite();
    }
}
