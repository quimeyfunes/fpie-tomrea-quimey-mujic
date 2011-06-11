package Armas;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Mapa.Vector2D;
import Objetos_moviles.Laser;
import Objetos_moviles.Municion;

public class PistolaLaser extends ArmasFisicas{

	
	public PistolaLaser(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.constructor(bando, estrategia, this);
	}
	
	public Municion dispararDesde ( Vector2D ubicacion ) {
		Laser laser =  new Laser( ubicacion, direccionAApuntar, bando );
		return laser;
	}
		
}
