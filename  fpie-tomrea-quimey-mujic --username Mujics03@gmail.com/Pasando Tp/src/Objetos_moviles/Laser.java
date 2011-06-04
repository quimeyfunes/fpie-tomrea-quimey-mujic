package Objetos_moviles;

import java.awt.geom.Rectangle2D;
import Armas.Danio;
import Mapa.Vector2D;

public class Laser extends Municion
{
	public Laser(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando)
	{
		this.constructor(posicion, estrategia, bando, this);
	}	
	
	protected void EstadoCorrecto()
	{
		this.danio = new Danio((short)25);
		this.Velocidad = 8;
		Vector2D p = ubicacion.XY();

		Cuerpo = new Rectangle2D.Double( p.x,p.y,1,1);

	}
	
	protected void ActuarAnteColision(ObjetosMoviles movil) 
	{
		if(movil.getClass() != this.getClass())
		{
			movil.analizarDanio(this.daniar());
			this.Vivo = false;
		}
	}

}
