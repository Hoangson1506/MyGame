package animation;

import game.Game;
import mechanic.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    SpriteLibrary spriteLibrary;
    BufferedImage currentSpriteSheet;
    private int updatesPerFrame;
    private int currentFrame;
    private int frameIndex;
    private int directionIndex;
    public AnimationManager(SpriteLibrary spriteLibrary, String name) {
        this.spriteLibrary = spriteLibrary;
        updatesPerFrame = 10;
        currentFrame = 0;
        frameIndex = 0;
        directionIndex = 0;
        this.currentSpriteSheet = (BufferedImage) spriteLibrary.getSpriteSheet(name);
    }
    public void update(Direction direction) {
        currentFrame++;
        directionIndex = direction.getAnimationRow();
        if(currentFrame >= updatesPerFrame) {
            currentFrame = 0;
            frameIndex++;
            if(frameIndex > currentSpriteSheet.getWidth()/ Game.SPRITE_SIZE - 1) {
                frameIndex = 0;
            }
        }
    }
    public void updateEnemySprite(Direction direction) {
        currentFrame++;
        directionIndex = direction.getAnimationRow();
        if(currentFrame >= updatesPerFrame) {
            currentFrame = 0;
            frameIndex++;
            if(frameIndex > currentSpriteSheet.getWidth()/ (Game.SPRITE_SIZE * 2) - 1) {
                frameIndex = 0;
            }
        }
    }
    public Image getSprite() {
        return currentSpriteSheet.getSubimage(
                frameIndex * Game.SPRITE_SIZE   ,
                directionIndex * Game.SPRITE_SIZE
                , Game.SPRITE_SIZE, Game.SPRITE_SIZE
        );
    }
    public Image getEnemySprite() {
        return currentSpriteSheet.getSubimage(
                frameIndex * Game.SPRITE_SIZE * 2,
                directionIndex * Game.SPRITE_SIZE * 2,
                Game.SPRITE_SIZE * 2, Game.SPRITE_SIZE * 2
        );
    }
}
