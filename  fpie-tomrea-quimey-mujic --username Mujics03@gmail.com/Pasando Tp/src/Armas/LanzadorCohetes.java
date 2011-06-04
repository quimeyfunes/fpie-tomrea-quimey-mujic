package Armas;

import java.awt.Point;

public class LanzadorCohetes extends ArmasFisicas {

	int cohetes;
	
	public void main(String [] args){
		cohetes = 15;
	}

	public Municion Disparar_desde ( Point ubicacion ) {
		cohetes = cohetes - 1;
		if ( cohetes < 0 ) trow new // excepcion out of ammo
		Cohete cohete = new Cohete( Point ubicacion, EstrategiaVuelo direccionVuelo, String bando );
		return cohete;
	}
	

}
