package mechanic.action;

import java.awt.*;

public interface Action {
    boolean playerUpdate(boolean isTakingAction);
    boolean enemyUpdate(boolean isTakingAction);
    Image getEnemySprite();
    Image getSprite();
}
