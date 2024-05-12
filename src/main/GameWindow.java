package main;
import UI.GameUI;
import controller.KeyHandler;
import controller.MouseInput;
import game.state.EndState;
import game.state.MenuState;
import game.state.PlayState;
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
        canva.addMouseListener(mouseInput);
        canva.addMouseMotionListener(mouseInput);
        canva.addKeyListener(keyHandler);
        add(canva);
        pack();

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
        if(state instanceof PlayState) {
            gameUI.startTime();
            gameUI.render(graphics);
        }
        if(state instanceof EndState) {
            gameUI.stopTime();
            gameUI.render(graphics);
        }
        graphics.dispose();
        bufferedStrategy.show();
    }
    public void reset() {
        gameUI.reset();
    }
}
