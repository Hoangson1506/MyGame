package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    boolean up, down, left, right, dodge, sprint;
    private boolean[] keyPressed;
    public KeyHandler() {
        keyPressed = new boolean[256];
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode >=0 && keyCode < keyPressed.length) {
            keyPressed[keyCode] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode >=0 && keyCode < keyPressed.length) {
            keyPressed[keyCode] = false;
        }
    }
    private void updateMovement() {
        up = keyPressed[KeyEvent.VK_W];
        down = keyPressed[KeyEvent.VK_S];
        left = keyPressed[KeyEvent.VK_A];
        right = keyPressed[KeyEvent.VK_D];
        dodge = keyPressed[KeyEvent.VK_SPACE];
        sprint = keyPressed[KeyEvent.VK_SHIFT];
    }
}
