package Objetos_moviles;

import ar.uba.fi.algo3.titiritero.DibujableExtra;
import Armas.Blindaje;
import Armas.Danio;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Mapa.Vector2D;
import Vistas.VistaMisil;

public class Cohete extends Municion
{
	public Cohete(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando)
	{
		this.constructor(posicion, estrategia, bando, this);
	}	
	
	protected void EstadoCorrecto()
	{
		this.danio = new Danio((short)50);
		this.Velocidad = 5;
		this.ConfigurarCuerpo(8,8);
		this.blindaje= new Blindaje((short)50);

	}

	@Override
	public DibujableExtra getVista() {
		return new VistaMisil();
	}

}
