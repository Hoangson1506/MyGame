package sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Sound {
    private Clip clip;
    private Map<String, URL> soundURL;
    public Sound() {
        soundURL = new HashMap<>();
        soundURL.put("MenuTheme", getClass().getResource("/sounds/MainTheme.wav"));
        soundURL.put("GameTheme", getClass().getResource("/sounds/GameTheme.wav"));
        soundURL.put("GameOver", getClass().getResource("/sounds/GameOver.wav"));
        soundURL.put("LevelUp", getClass().getResource("/sounds/LevelUp.wav"));
        soundURL.put("EnemyHurt", getClass().getResource("/sounds/EnemyHurt.wav"));
        soundURL.put("PlayerHurt", getClass().getResource("/sounds/PlayerHurt.wav"));
    }
    public void setSound(String name) {
        try{
            URL soundURL = this.soundURL.get(name);
            if (soundURL != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            } else {
                System.err.println("Sound file not found: " + name);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
