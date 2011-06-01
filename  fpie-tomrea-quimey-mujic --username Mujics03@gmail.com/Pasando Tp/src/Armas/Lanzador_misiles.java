package Armas;
import java.awt.Point;

public class Lanzador_misiles extends Armas{

	int misiles;
		
	public void main(String [] args){
		misiles = 15;
	}

	public Municion Disparar_desde ( Point ubicacion ) {
		misiles = misiles - 1;
		if ( misiles < 0 ) trow new // excepcion out of ammo
		Misil misil = new Misil( Point ubicacion, Estrategia_vuelo direccion_vuelo, String bando );
		return Misil;
	}
		
}
