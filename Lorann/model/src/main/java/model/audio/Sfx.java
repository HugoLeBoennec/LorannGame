package model.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * <h1>The Class Sprite contains one or more images.</h1>
 *
 * @author Matthieu CARTERON matthieu.carteron@viacesi.fr
 * @version 1.0
 */
public class Sfx {

	 /** The sound played at purses. */
    public static Clip SFX_PURSE;
    
    /** The sound played at bubbles. */
    public static Clip SFX_BUBBLE;
    
    /** The sound played when cast the spell. */
    public static Clip SFX_SORTILEGE;
    
    /** The sound played when death. */
    public static Clip SFX_DEATH;
	
	/**
     * Load all the sound effects
     * 
	 * @throws IOException
	 * 				the input output exception
	 * @throws UnsupportedAudioFileException
	 * 				the audio is unsupported
	 * @throws LineUnavailableException
	 * 				the line is unavailable
     */
	static public void LoadSfx() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		SFX_PURSE = AudioSystem.getClip();
    	SFX_PURSE.open(AudioSystem.getAudioInputStream(new File("sound/money.wav")));
    	
    	SFX_BUBBLE = AudioSystem.getClip();
    	SFX_BUBBLE.open(AudioSystem.getAudioInputStream(new File("sound/bubble.wav")));
    	
    	SFX_SORTILEGE = AudioSystem.getClip();
    	SFX_SORTILEGE.open(AudioSystem.getAudioInputStream(new File("sound/cast.wav")));
    	
    	SFX_DEATH = AudioSystem.getClip();
    	SFX_DEATH.open(AudioSystem.getAudioInputStream(new File("sound/death.wav")));
	}
}
