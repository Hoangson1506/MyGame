package controller;

import math.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener, MouseListener {
    private Position mousePosition;
    public boolean shoot;
    public MouseInput() {
        mousePosition = new Position(0, 0);
        shoot = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double mouseX = e.getPoint().getX();
        double mouseY = e.getPoint().getY();
        mousePosition.setX(mouseX);
        mousePosition.setY(mouseY);
    }
    public Position getMousePosition() {
        return mousePosition;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        shoot = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shoot = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
