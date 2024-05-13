package object;

import game.state.State;
import math.Position;
import math.Size;

import java.awt.*;
import java.util.Optional;

public class Camera {
    private Position position;
    private Size windowSize;
    private Optional<GameObject> objectWithFocus;
    private Rectangle viewBounds;
    public Camera(Size windowSize) {
        this.windowSize = windowSize;
        this.position = new Position(0, 0);
        calculateViewBounds();
    }
    private void calculateViewBounds() {
        viewBounds = new Rectangle(position.intX(), position.intY(), windowSize.getWidth(), windowSize.getHeight());
    }
    public void focusOn(GameObject gameObject) {
        objectWithFocus = Optional.ofNullable(gameObject);
    }
    public void update(State state) {
        if(this.objectWithFocus != null && objectWithFocus.isPresent()) {
            Position objectPosition = objectWithFocus.get().getPosition();
            this.position.setX(objectPosition.getX() - windowSize.getWidth()/2);
            this.position.setY(objectPosition.getY() - windowSize.getHeight()/2);
            clampBoudaries(state);
            calculateViewBounds();
        }
    }

    private void clampBoudaries(State state) {
        if(position.getX() < 0) {
            position.setX(0);
        }
        if(position.getY() < 0) {
            position.setY(0);
        }
        if(position.getX() + windowSize.getWidth() > state.getGameMap().getWidth()) {
            position.setX(state.getGameMap().getWidth() - windowSize.getWidth());
        }
        if(position.getY() + windowSize.getHeight() > state.getGameMap().getHeight()) {
            position.setY(state.getGameMap().getHeight() - windowSize.getHeight());
        }
    }

    public Position getPosition() {
        return position;
    }

    public double getWidth() {
        return windowSize.getWidth();
    }
    public double getHeight() {
        return windowSize.getHeight();
    }
    public Optional<GameObject> getObjectWithFocus() {
        return objectWithFocus;
    }

    public boolean isInView(GameObject gameObject) {
        return viewBounds.intersects(gameObject.getCollisionBox().getBounds());
    }
}
