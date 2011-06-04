package Armas;

import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import Objetos_moviles.Cohete;
import Objetos_moviles.EstrategiaDeVuelo;
import Objetos_moviles.Municion;

public class LanzadorCohetes extends ArmasFisicas {

	int cohetes;
	
	public LanzadorCohetes(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.constructor(bando, estrategia, this);
	}
	
	public void main(String [] args){
		cohetes = 15;
	}

	public Municion dispararDesde ( Vector2D ubicacion ) {
		cohetes = cohetes - 1;
		if ( cohetes < 0 ) 
			throw new OutOfAmmoException();
		Cohete cohete = new Cohete( ubicacion, direccionAApuntar, bando );
		return cohete;
	}
	

}
