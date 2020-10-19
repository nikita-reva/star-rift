package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
	private File musicpath;
	static Clip clip;
	
	public MusicPlayer(String track) {
		musicpath = new File(track);
		if(musicpath.exists()) {
			try {
				AudioInputStream inputstream = AudioSystem.getAudioInputStream(musicpath);
				clip = AudioSystem.getClip();
				clip.open(inputstream);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selecttrack(String track) {
		clip.close();
		musicpath = new File(track);
		if(musicpath.exists()) {
			try {
				AudioInputStream inputstream = AudioSystem.getAudioInputStream(musicpath);
				clip = AudioSystem.getClip();
				clip.open(inputstream);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void playmusic() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopmusic() {
		clip.stop();
	}
}
