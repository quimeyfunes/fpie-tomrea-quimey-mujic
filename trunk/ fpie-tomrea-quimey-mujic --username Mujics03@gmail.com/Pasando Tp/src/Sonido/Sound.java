package Sonido;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Sound // Holds one audio file
{
	private AudioClip song; // Sound player
	private URL songPath; // Sound path
	private boolean sonando;

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
			this.sonando = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public void cambiarTema(String filename)
	{
		this.stopSound();
		this.setSong(filename);
		this.playSound();
	}
	
	public void cambiarEstadoSonido()
	{
		if(this.sonando)
		{
			this.stopSound();
			this.sonando = false;			
		}
		else
		{
			this.playSound();
			this.sonando = true;	
		}
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
	
	public boolean estaSonando(){
		return this.sonando;
	}

	public void playSound()
	{
		song.loop(); // Play
		this.sonando=true;
	}

	public void stopSound()
	{
		song.stop(); // Stop
		this.sonando=false;
	}

	public void playSoundOnce()
	{
		song.play(); // Play only once
	}
}
