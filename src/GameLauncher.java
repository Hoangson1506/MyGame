import javax.swing.*;

public class GameLauncher extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("My Game");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);
        GamePanel gamePanel = new GamePanel(1280, 720);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(new GameLoop(gamePanel)).start();
    }
}
