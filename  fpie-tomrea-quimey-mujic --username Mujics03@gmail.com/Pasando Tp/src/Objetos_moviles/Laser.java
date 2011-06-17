package Objetos_moviles;

import ar.uba.fi.algo3.titiritero.DibujableExtra;
import Armas.Blindaje;
import Armas.Danio;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Mapa.Vector2D;
import Vistas.VistaLaser;

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
		this.ConfigurarCuerpo(8,8);
		this.blindaje= new Blindaje((short)1);

	}
	
	protected void ActuarAnteColision(ObjetosMoviles movil) 
	{
		if(movil.getClass() != this.getClass())
		{
			this.Destructor();
			movil.analizarDanio(this.daniar());
		}
	}

	@Override
	public DibujableExtra getVista() {
		return new VistaLaser();
	}

}
