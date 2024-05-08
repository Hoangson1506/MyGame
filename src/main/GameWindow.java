package main;
import UI.GameUI;
import controller.KeyHandler;
import controller.MouseInput;
import game.state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameWindow extends JFrame {
    private Canvas canva;
    Renderer renderer;
    private GameUI gameUI;
    public GameWindow(int width, int height, KeyHandler keyHandler, MouseInput mouseInput) {
        setTitle("My Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        gameUI = new GameUI();

        canva = new Canvas();
        canva.setPreferredSize(new Dimension(width, height));
        canva.setFocusable(true);
        canva.addMouseMotionListener(mouseInput);
        add(canva);
        pack();

        setFocusable(true);
        addKeyListener(keyHandler);

        canva.createBufferStrategy(3);
        renderer = new Renderer();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void render(State state) {
        BufferStrategy bufferedStrategy = canva.getBufferStrategy();
        Graphics graphics = bufferedStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canva.getWidth(), canva.getHeight());

        renderer.render(state, graphics);
        gameUI.render(graphics);

        graphics.dispose();
        bufferedStrategy.show();
    }
}
