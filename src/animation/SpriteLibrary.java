package animation;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private static String basePath = "";
    private Map<String, Image> spriteSheets;
    public SpriteLibrary() {
        spriteSheets = new HashMap<>();
        loadSpriteFromDisk();
    }

    private void loadSpriteFromDisk() {
        String[] folderNames = getFolderNames(basePath);
        for(String folderName : folderNames) {
            String spritePath = basePath + "/" + folderName;
            String[] sheetsInFolder = getSheetsInFolder(spritePath);
            for(String sheet : sheetsInFolder) {
                spriteSheets.put(sheet.substring(0, sheet.length()-4), ImageLoader.loadImage(sheet));
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
}
