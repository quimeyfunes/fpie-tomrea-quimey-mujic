package Armas;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import Objetos_moviles.Municion;
import Objetos_moviles.TorpedoDirigido;

public class LanzadorMisiles extends ArmasFisicas{

	public LanzadorMisiles(byte bando, EstrategiaDeVuelo estrategia )
	{
		this.constructor(bando, estrategia, this);
		this.misiles = 15;
	}

	int misiles;

	public Municion dispararDesde ( Vector2D ubicacion ) {
		misiles = misiles - 1;
		if ( misiles < 0 ) 
			throw new OutOfAmmoException(); 
		TorpedoDirigido torpedo = new TorpedoDirigido( ubicacion, direccionAApuntar, bando );
		return torpedo;
	}
		
}
