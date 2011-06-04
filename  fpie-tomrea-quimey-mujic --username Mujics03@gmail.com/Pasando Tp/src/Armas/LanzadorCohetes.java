package Armas;

import java.awt.Point;

import ObjetosMoviles.EstrategiaDeVuelo;
import ObjetosMoviles.Municion;

public class LanzadorCohetes extends ArmasFisicas {

	int cohetes;
	
	public LanzadorCohetes(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.setBando(bando);
		this.setEstrategiaVuelo(estrategia);
	}
	
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
