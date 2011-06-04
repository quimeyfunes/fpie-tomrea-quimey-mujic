package Armas;

import Mapa.Vector2D;
import ObjetosMoviles.EstrategiaDeVuelo;
import ObjetosMoviles.Municion;

public abstract class ArmasFisicas {

	byte bando;
	EstrategiaDeVuelo direccion_vuelo;
	
	public void setBando( byte parametro_bando ){
		bando = parametro_bando;
	}

	public void setEstrategiaVuelo( EstrategiaDeVuelo estrategia ){
		direccion_vuelo = estrategia;
	}
	
	
	public abstract Municion dispararDesde ( Vector2D ubicacion );
}
