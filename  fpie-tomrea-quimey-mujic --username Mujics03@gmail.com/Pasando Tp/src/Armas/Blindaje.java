package Armas;

import Excepciones.ChauBlindajeException;
import Objetos_Moviles.ItemVida;

public class Blindaje
{
	short hitPoints;
	public Blindaje(short hitPoints)
	{
		this.construidoCon(hitPoints);
	}
	
	public void construidoCon(short hitPoints)
	{
		this.hitPoints = hitPoints;
	}
	
	public short getHitPoints ()
	{
		return this.hitPoints;
	}
	
	public void repararPor(ItemVida itemVida)
	{
		hitPoints = (short) (hitPoints + (itemVida.reparar()) );

		//La vida del avion crece sin limite. Cada vez es mas poderoso."
	}
	
	public void daniar (Danio danio) 
	{
		//aca puede ir logistica escudos
		hitPoints = (short) (hitPoints - danio.lastimar());
		if(hitPoints <= 0)
			throw new ChauBlindajeException();
	}
}
