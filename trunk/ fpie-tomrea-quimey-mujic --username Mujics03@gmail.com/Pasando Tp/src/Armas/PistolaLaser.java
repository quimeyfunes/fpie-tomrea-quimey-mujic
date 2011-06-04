package Armas;
import java.awt.Point;

import ObjetosMoviles.EstrategiaDeVuelo;

public class PistolaLaser extends ArmasFisicas{

	
	public PistolaLaser(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.setBando(bando);
		this.setEstrategiaVuelo(estrategia);
	}
	
	public Municion Disparar_desde ( Point ubicacion ) {
		Laser laser =  new Laser( Point ubicacion, EstrategiaVuelo direccionVuelo, String bando );
		return Laser;
	}
		
}
