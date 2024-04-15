import controller.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameWindow extends JFrame {
    private Canvas canva;
    public GameWindow(int width, int height, KeyHandler keyHandler) {
        setTitle("My game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        canva = new Canvas();
        canva.setPreferredSize(new Dimension(width, height));
        canva.setFocusable(true);
        add(canva);
        pack();
        setFocusable(true);
        addKeyListener(keyHandler);
        canva.createBufferStrategy(3);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void render(Game game) {
        BufferStrategy bufferedStrategy = canva.getBufferStrategy();
        Graphics graphics = bufferedStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canva.getWidth(), canva.getHeight());

        game.getGameObjects().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                null
        ));

        graphics.dispose();
        bufferedStrategy.show();
    }
}
