package Armas;
import java.awt.Point;

public class Lanzador_laser extends Armas{

	public Municion Disparar_desde ( Point ubicacion ) {
		Laser laser =  new Laser( Point ubicacion, Estrategia_vuelo direccion_vuelo, String bando );
		return Laser;
	}
		
}
