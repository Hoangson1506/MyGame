package game.state;

import controller.KeyHandler;
import controller.MouseInput;
import game.Game;
import math.Size;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuState extends State{
    private Size menuSize;
    private BufferedImage background;
    private Font font;
    private int buttonWidth, buttonHeight, buttonX, buttonY;
    private int command;
    private final int commandDelay = 300;
    private long lastCommandTime;
    private boolean canChangeCommand;
    public MenuState(Size windowSize, KeyHandler keyHandler, MouseInput mouseInput) {
        super(windowSize, keyHandler, mouseInput);
        spawner.stop();
        this.menuSize = windowSize;
        try {
            background = ImageIO.read(getClass().getResourceAsStream("/background/background.png"));
        }
        catch (IOException e) {
            e.getStackTrace();
        }
        font = new Font("Karmatic Arcade", Font.PLAIN, 36);
        command = 0;
        canChangeCommand = true;
        playMusic("MenuTheme");
    }

    public void renderMenu(Graphics graphics) {
        Graphics g2 = (Graphics2D) graphics;
        g2.drawImage(background, 0, 0, menuSize.getWidth(), menuSize.getHeight(), null);
        buttonWidth = (int) g2.getFontMetrics().getStringBounds("Play", g2).getWidth();
        buttonHeight = (int) g2.getFontMetrics().getStringBounds("Play", g2).getHeight();
        buttonX = (menuSize.getWidth() - buttonWidth) / 2 - 50;
        buttonY = 350 - buttonHeight;
        g2.setFont(font);
        g2.setColor(Color.white);
        if(command == 0) {
            g2.setColor(Color.red);
            g2.drawString("Play", buttonX, buttonY);
            g2.setColor(Color.white);
            g2.drawString("Quit", buttonX, buttonY + 60);
        }
        else {
            g2.drawString("Play", buttonX, buttonY);
            g2.setColor(Color.red);
            g2.drawString("Quit", buttonX, buttonY + 60);
        }
    }
    public void update() {
        if(keyHandler.down && canChangeCommand) {
            command++;
            canChangeCommand = false;
            lastCommandTime = System.currentTimeMillis();
            command %= 2;
        }
        if(keyHandler.up && canChangeCommand) {
            command--;
            canChangeCommand = false;
            lastCommandTime = System.currentTimeMillis();
            if(command < 0)
                command = 1;
        }
        if(System.currentTimeMillis() - lastCommandTime >= commandDelay) {
            canChangeCommand = true;
        }
        if(keyHandler.restart && command == 0) {
            Game.startGame();
        }
        if(keyHandler.restart && command == 1) {
            System.exit(0);
        }
    }

}
