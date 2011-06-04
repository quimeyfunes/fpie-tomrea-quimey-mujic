package Armas;
import java.awt.Point;

import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import Objetos_moviles.EstrategiaDeVuelo;
import Objetos_moviles.Municion;

public class LanzadorMisiles extends ArmasFisicas{

	public LanzadorMisiles(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.setBando(bando);
		this.setEstrategiaVuelo(estrategia);
	}

	int misiles;
		
	public void main(String [] args){
		misiles = 15;
	}

	public Municion dispararDesde ( Vector2D ubicacion ) {
		misiles = misiles - 1;
		if ( misiles < 0 ) 
			throw new OutOfAmmoException(); 
		Misil misil = new Misil( ubicacion, direccionAApuntar, bando );
		return Misil;
	}
		
}
