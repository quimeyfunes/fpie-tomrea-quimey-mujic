package Armas;
import java.awt.Point;

public class ArmasFisicas {

	byte bando;
	EstrategiaVuelo direccion_vuelo;
	
	public ArmasFisicas(byte bando, EstrategiaVuelo estrategia )
	{
		this.setBando(bando);
		this.setEstrategia_vuelo(estrategia);
	}
	
	public void setBando( byte parametro_bando ){
		bando = parametro_bando;
	}

	public void setEstrategia_vuelo( EstrategiaVuelo estrategia ){
		direccion_vuelo = estrategia;
	}
	
	
	public abstract Municion Disparar_desde ( Point ubicacion ) {
		
	}
}
