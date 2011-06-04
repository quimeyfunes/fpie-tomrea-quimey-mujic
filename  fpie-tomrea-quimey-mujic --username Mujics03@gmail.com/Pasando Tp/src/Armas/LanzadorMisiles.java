package Armas;
import java.awt.Point;

import ObjetosMoviles.EstrategiaDeVuelo;
import ObjetosMoviles.Municion;

public class LanzadorMisiles extends ArmasFisicas{

	public LanzadorMisiles(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.setBando(bando);
		this.setEstrategiaVuelo(estrategia);
	}

	int misiles;
		
	public void main(String [] args){
		misiles = 15;
	}

	public Municion Disparar_desde ( Point ubicacion ) {
		misiles = misiles - 1;
		if ( misiles < 0 ) trow new // excepcion out of ammo
		Misil misil = new Misil( Point ubicacion, EstrategiaVuelo direccionVuelo, String bando );
		return Misil;
	}
		
}
