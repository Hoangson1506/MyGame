package UI;
import object.MeleeEnemy;
import object.Player;
import object.projectile.Arrow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameUI {
    private Font karmatic_25;
    private BufferedImage lifeImage;
    private long startTimeMillis;
    private long levelUpStartTime, warningStartTime;
    private boolean enemyEvolved;
    public int timesInSeconds;
    public static long score;
    private boolean timeStopped;
    public GameUI() {
        karmatic_25 = new Font("Karmatic Arcade", Font.PLAIN, 25);
        try {
            lifeImage = ImageIO.read(getClass().getResourceAsStream("/sprites/LifeUI.png"));
        }catch (Exception e) {
            e.getStackTrace();
        }
        startTimeMillis = System.currentTimeMillis();
        timesInSeconds = 0;
        score = 0;
        levelUpStartTime = -1;
        warningStartTime = -1;
        enemyEvolved = false;
        timeStopped = false;
    }
    public void render(Graphics g2) {
        if(!timeStopped) {
            updateTime();
        }
        String time = formatGameTime();
        String points = String.valueOf(score);
        g2.setFont(karmatic_25);
        g2.setColor(Color.black);
        if(Player.life <= 30)
            g2.setColor(Color.red);
        g2.drawImage(lifeImage, 10, 10, null);
        g2.drawString(" X " + String.valueOf(Player.life), 35, 35);
        g2.setColor(Color.black);
        g2.drawString(time, 340, 35);
        g2.drawString(points, 675, 35);
        levelUpPlayer(g2);
        evolvedEnemy(g2);
        if(Player.life <= 0) {
            g2.setFont(g2.getFont().deriveFont(50F));
            g2.setColor(Color.red);
            g2.drawString("Game Over!", 210, 330);
        }
    }
    private void updateTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedTimeMillis = (currentTimeMillis - startTimeMillis) / 1000;
        timesInSeconds = (int) elapsedTimeMillis;
    }
    private String formatGameTime() {
        int minute = timesInSeconds / 60;
        int second = timesInSeconds % 60;
        StringBuilder stringBuilder = new StringBuilder();
        if(minute < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(minute);
        stringBuilder.append(":");
        if(second < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(second);
        return stringBuilder.toString();
    }
    private void evolvedEnemy(Graphics g2) {
        if(timesInSeconds % 3 == 0 && timesInSeconds != 0) {
            enemyEvolved = true;
        }
        if(enemyEvolved) {
            if(warningStartTime == -1) {
                warningStartTime = System.currentTimeMillis();
            }
            g2.setColor(Color.red);
            g2.drawString("Skeletons have evolved", 175, 250);

            long elapsedTime = System.currentTimeMillis() - warningStartTime;

            if(elapsedTime >= 1500) {
                MeleeEnemy.evolve();
                enemyEvolved = false;
                warningStartTime = -1;
            }
        }
    }
    private void levelUpPlayer(Graphics g2) {
        if(Player.exp >= Player.maxExp) {
            if(levelUpStartTime == -1) {
                levelUpStartTime = System.currentTimeMillis();
            }
            g2.setColor(Color.green);
            g2.drawString("Level Up!", 310, 320);
            if(System.currentTimeMillis() - levelUpStartTime >= 3000) {
                Player.exp -= Player.maxExp;
                Player.maxExp += 250;
                Player.shootCooldown -= 50;
                Player.speed += 0.15;
                Arrow.damage += 2;
                levelUpStartTime = -1;
            }
        }
    }

    public void reset() {
        score = 0;
        timesInSeconds = 0;
        startTimeMillis = System.currentTimeMillis();
    }
    public void stopTime() {
        timeStopped = true;
        startTimeMillis = System.currentTimeMillis();
    }
    public void startTime() {
        timeStopped = false;
    }
}