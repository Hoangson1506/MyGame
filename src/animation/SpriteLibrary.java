package animation;

import game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private static String basePath = "/sprites";
    private Map<String, Image> spriteSheets;
    private Map<String, Image> tiles;
    public SpriteLibrary() {
        spriteSheets = new HashMap<>();
        tiles = new HashMap<>();
        loadSpriteFromDisk();
    }

    private void loadSpriteFromDisk() {
        loadSpriteSheets();
        loadTiles();
    }

    private void loadTiles() {
        BufferedImage sprite = new BufferedImage(Game.SPRITE_SIZE * 2, Game.SPRITE_SIZE * 2, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = sprite.createGraphics();
        graphics2D.setColor(Color.red);
        graphics2D.drawRect(0, 0, Game.SPRITE_SIZE * 2, Game.SPRITE_SIZE * 2);
        graphics2D.dispose();
        tiles.put("default", sprite);
    }

    private void loadSpriteSheets() {
        String[] folderNames = getFolderNames(basePath);
        for(String folderName : folderNames) {
            String spritePath = basePath + "/" + folderName;
            String[] sheetsInFolder = getSheetsInFolder(spritePath);
            for(String sheet : sheetsInFolder) {
                spriteSheets.put(sheet.substring(0, sheet.length()-4), ImageLoader.loadImage(spritePath + "/" + sheet));
            }
        }
    }

    private String[] getSheetsInFolder(String path) {
        URL resource = SpriteLibrary.class.getResource(path);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isFile());
    }

    private String[] getFolderNames(String path) {
        URL resource = SpriteLibrary.class.getResource(path);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isDirectory());
    }
    public Image getSpriteSheet(String name) {
        return spriteSheets.get(name);
    }
    public Image getTile(String name) {
        return tiles.get(name);
    }
}
