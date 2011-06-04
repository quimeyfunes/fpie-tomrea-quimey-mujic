package Objetos_moviles;

import java.awt.geom.Rectangle2D;

import Armas.Danio;
import Mapa.Vector2D;

public class Cohete extends Municion
{
	public Cohete(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando)
	{
		this.constructor(posicion, estrategia, bando, this);
	}	
	
	protected void EstadoCorrecto()
	{
		this.danio = new Danio((short)50);
		this.Velocidad = 3;
		Vector2D p = ubicacion.XY();

		Cuerpo = new Rectangle2D.Double( p.x,p.y,2,2);

	}

}
