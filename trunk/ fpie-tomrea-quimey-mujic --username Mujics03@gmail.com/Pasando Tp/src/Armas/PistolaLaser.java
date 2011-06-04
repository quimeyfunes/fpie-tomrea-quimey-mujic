package Armas;
import java.awt.Point;

import Mapa.Vector2D;
import Objetos_moviles.EstrategiaDeVuelo;
import Objetos_moviles.Municion;

public class PistolaLaser extends ArmasFisicas{

	
	public PistolaLaser(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.setBando(bando);
		this.setEstrategiaVuelo(estrategia);
	}
	
	public Municion dispararDesde ( Vector2D ubicacion ) {
		Laser laser =  new Laser( ubicacion, direccionAApuntar, bando );
		return Laser;
	}
		
}
