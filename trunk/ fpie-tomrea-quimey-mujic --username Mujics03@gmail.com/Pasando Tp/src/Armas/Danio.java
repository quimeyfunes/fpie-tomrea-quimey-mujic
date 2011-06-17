package Armas;

public class Danio
{
	short puntosDeDanio;
	public Danio(short puntos)
	{
		this.setearPoder(puntos);
	}
	
	public void setearPoder(short puntos)
	{
		this.puntosDeDanio = puntos;
	}
	
	public short lastimar()
	{
		return this.puntosDeDanio;
	}
}
