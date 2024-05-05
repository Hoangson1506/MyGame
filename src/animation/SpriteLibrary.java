package animation;

import game.Game;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private Map<String, Image> playerSheets;
    private Map<String, Image> enemySheets;
    private Map<String, Image> tiles;
    public SpriteLibrary() {
        playerSheets = new HashMap<>();
        tiles = new HashMap<>();
        loadSpriteFromDisk();
    }

    private void loadSpriteFromDisk() {
        loadPlayerSheets("/sprites");
        loadTiles("/tiles");
    }

    private void loadTiles(String basePath) {
        String[] sheetsInFolder = getImagesInFolder(basePath);
        for(String sheet : sheetsInFolder) {
            tiles.put(sheet.substring(0, sheet.length()-4), ImageLoader.loadImage(basePath + "/" + sheet));
        }
    }

    private void loadPlayerSheets(String basePath) {
        String[] folderNames = getFolderNames(basePath);
        for(String folderName : folderNames) {
            String spritePath = basePath + "/" + folderName;
            String[] sheetsInFolder = getImagesInFolder(spritePath);
            for(String sheet : sheetsInFolder) {
                playerSheets.put(sheet.substring(0, sheet.length()-4), ImageLoader.loadImage(spritePath + "/" + sheet));
            }
        }
    }

    private String[] getImagesInFolder(String path) {
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
        return playerSheets.get(name);
    }
    public Image getTile(String name) {
        return tiles.get(name);
    }
}
