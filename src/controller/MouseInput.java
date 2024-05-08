package controller;

import math.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener {
    private Position mousePosition;
    public MouseInput() {
        mousePosition = new Position(0, 0);
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
}
