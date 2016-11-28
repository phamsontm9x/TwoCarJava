package TwoCars;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundGame {
	
	private Clip sound;
	
	public SoundGame(String s) {
		try {
			AudioInputStream inputSound = AudioSystem.getAudioInputStream(new File(s));
			sound = AudioSystem.getClip();
			sound.open(inputSound);
			if (!s.equals("res/SoundBoom.wav"))  {
				sound.loop(Clip.LOOP_CONTINUOUSLY);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void StopSound() {
		if (sound.isRunning()){
			sound.stop();
		}
	}
	
	public void PlaySound() {
		sound.setMicrosecondPosition(0);
		sound.start();
	}

}
