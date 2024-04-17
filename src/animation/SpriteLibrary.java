package animation;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
<<<<<<< HEAD
    private static String basePath = "/sprites";
=======
    private static String basePath = "";
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
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
<<<<<<< HEAD
                spriteSheets.put(sheet.substring(0, sheet.length()-4), ImageLoader.loadImage(spritePath + "/" + sheet));
=======
                spriteSheets.put(sheet.substring(0, sheet.length()-4), ImageLoader.loadImage(sheet));
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
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
<<<<<<< HEAD
    public Image getSpriteSheet(String name) {
        return spriteSheets.get(name);
    }
=======
>>>>>>> b7803ae47bf0f763707d444e4726a5839c5353f8
}
