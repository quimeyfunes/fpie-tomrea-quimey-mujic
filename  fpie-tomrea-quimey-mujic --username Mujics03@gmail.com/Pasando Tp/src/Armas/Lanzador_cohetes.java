package Armas;

import java.awt.Point;

public class Lanzador_cohetes extends Armas {

	int cohetes;
	
	public void main(String [] args){
		cohetes = 15;
	}

	public Municion Disparar_desde ( Point ubicacion ) {
		cohetes = cohetes - 1;
		if ( cohetes < 0 ) trow new // excepcion out of ammo
		Cohete cohete = new Cohete( Point ubicacion, Estrategia_vuelo direccion_vuelo, String bando );
		return cohete;
	}
	

}
