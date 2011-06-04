package Armas;

import Mapa.Vector2D;
import Objetos_moviles.EstrategiaDeVuelo;
import Objetos_moviles.Municion;

public abstract class ArmasFisicas {

	byte bando;
	EstrategiaDeVuelo direccionAApuntar;
	
	public final void setBando( byte parametro_bando ){
		bando = parametro_bando;
	}

	public final void setEstrategiaVuelo( EstrategiaDeVuelo estrategia ){
		direccionAApuntar = estrategia;
	}
	
	
	public abstract Municion dispararDesde ( Vector2D ubicacion );
}
