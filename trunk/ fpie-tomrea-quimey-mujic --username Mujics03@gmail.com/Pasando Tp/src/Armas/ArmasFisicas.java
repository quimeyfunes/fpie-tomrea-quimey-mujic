package Armas;
import java.awt.Point;

import Mapa.Vector2D;

public abstract class ArmasFisicas {

	byte bando;
	EstrategiaVuelo direccion_vuelo;
	
	public ArmasFisicas(byte bando, EstrategiaVuelo estrategia )
	{
		this.setBando(bando);
		this.setEstrategiaVuelo(estrategia);
	}
	
	public void setBando( byte parametro_bando ){
		bando = parametro_bando;
	}

	public void setEstrategiaVuelo( EstrategiaVuelo estrategia ){
		direccion_vuelo = estrategia;
	}
	
	
	public abstract Municion dispararDesde ( Vector2D ubicacion );
}
