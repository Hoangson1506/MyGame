import controller.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int width, height;
    KeyHandler keyHandler = new KeyHandler();
    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        addKeyListener(keyHandler);
        setFocusable(true);
    }
    public void update() {

    }
    public void render() {

    }
}
