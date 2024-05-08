package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean up, down, left, right, shoot, sprint;
    private boolean[] pressed;
    public KeyHandler() {
        pressed = new boolean[256];
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode >=0 && keyCode < pressed.length) {
            pressed[keyCode] = true;
            updateMovement();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode >=0 && keyCode < pressed.length) {
            pressed[keyCode] = false;
            updateMovement();
        }
    }
    private void updateMovement() {
        up = pressed[KeyEvent.VK_W];
        down = pressed[KeyEvent.VK_S];
        left = pressed[KeyEvent.VK_A];
        right = pressed[KeyEvent.VK_D];
        shoot = pressed[KeyEvent.VK_SPACE];
        sprint = pressed[KeyEvent.VK_SHIFT];
    }
}