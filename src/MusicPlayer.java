import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
	static Clip clip;
	
	public MusicPlayer(URL track) {
		try {
			AudioInputStream inputstream = AudioSystem.getAudioInputStream(track);
			clip = AudioSystem.getClip();
			clip.open(inputstream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selecttrack(URL track) {
		clip.close();
		try {
			AudioInputStream inputstream = AudioSystem.getAudioInputStream(track);
			clip = AudioSystem.getClip();
			clip.open(inputstream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void playmusic() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopmusic() {
		clip.stop();
	}
}
