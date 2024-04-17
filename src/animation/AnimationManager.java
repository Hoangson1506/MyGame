package animation;

import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    SpriteLibrary spriteLibrary;
    BufferedImage currentSpriteSheet;
    private int updatesPerFrame;
    private int currentFrame;
    private int frameIndex;
    public AnimationManager(SpriteLibrary spriteLibrary, String name) {
        this.spriteLibrary = spriteLibrary;
        updatesPerFrame = 12;
        currentFrame = 0;
        frameIndex = 0;
        this.currentSpriteSheet = (BufferedImage) spriteLibrary.getSpriteSheet(name);
    }
    public void update() {
        currentFrame++;
        if(currentFrame >= updatesPerFrame) {
            currentFrame = 0;
            frameIndex++;
            if(frameIndex > currentSpriteSheet.getWidth()/ Game.SPRITE_SIZE - 1) {
                frameIndex = 0;
            }
        }
    }
    public Image getSprite() {
        return currentSpriteSheet.getSubimage(
                frameIndex * Game.SPRITE_SIZE   ,
                0, Game.SPRITE_SIZE, Game.SPRITE_SIZE
        );
    }
}
