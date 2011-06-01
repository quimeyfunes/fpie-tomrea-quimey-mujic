package Armas;
import java.awt.Point;

public class Armas {

	String bando;
	Estrategia_vuelo direccion_vuelo;
	
	public void setBando( String parametro_bando ){
		bando = parametro_bando;
	}

	public void setEstrategia_vuelo( Estrategia_vuelvo estrategia ){
		direccion_vuelo = estrategia;
	}
	
	
	public abstract Municion Disparar_desde ( Point ubicacion ) {
		
	}
}
