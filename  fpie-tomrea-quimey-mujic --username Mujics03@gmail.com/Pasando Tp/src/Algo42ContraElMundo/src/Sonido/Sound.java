package Sonido;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Sound // Holds one audio file
{
	private AudioClip song; // Sound player
	private URL songPath; // Sound path

	public Sound(String filename)
	{
		setSong(filename);
	}

	private void setSong(String filename)
	{
		try
		{
			songPath = new URL(getCodeBase(),filename);//Load the Sound
			song = Applet.newAudioClip(songPath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} // Satisfy the catch
	}
	
	public void cambiarTema(String filename)
	{
		this.stopSound();
		this.setSong(filename);
		this.playSound();
	}

	private URL getCodeBase()
	{
		try
		{
			return new URL("file:/" + System.getProperty("user.dir") + "/src/Sonido/");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void playSound()
	{
		song.loop(); // Play
	}

	public void stopSound()
	{
		song.stop(); // Stop
	}

	public void playSoundOnce()
	{
		song.play(); // Play only once
	}
}
