package animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageLoader {
    public static Image loadImage(String filePath) {
        try{
            return ImageIO.read(ImageLoader.class.getResource(filePath));
        }
        catch (IOException e) {
            System.out.println("cannot load file from " + filePath);
        }
        return null;
    }
}
