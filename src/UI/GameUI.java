package UI;
import object.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameUI {
    Font arial_25;
    BufferedImage lifeImage;
    public GameUI() {
        arial_25 = new Font("Arial", Font.PLAIN, 25);
        try {
            lifeImage = ImageIO.read(getClass().getResourceAsStream("/sprites/LifeUI.png"));
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
    public void render(Graphics g2) {
        g2.setFont(arial_25);
        g2.setColor(Color.white);
        g2.drawImage(lifeImage, 10, 10, null);
        g2.drawString(" X " + String.valueOf(Player.life), 35, 35);
        if(Player.life <= 0) {
            g2.setFont(g2.getFont().deriveFont(50F));
            g2.setColor(Color.red);
            g2.drawString("Game Over!", 270, 330);
        }
    }
}