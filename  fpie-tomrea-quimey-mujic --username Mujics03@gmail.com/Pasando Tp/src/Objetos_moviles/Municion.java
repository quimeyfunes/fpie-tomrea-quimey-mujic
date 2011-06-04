package Objetos_moviles;
import java.awt.Point;

import Mapa.Vector2D;

public class Municion extends ObjetosMoviles{

	
	public static Municion MunicionCrear( Vector2D ubicacion, EstrategiaDeVuelo direccion_vuelo, String bando ){
		Municion municion = new Municion();
		municion setBando( bando );
		municion setPosicion(  );// new de ubicacion
		municion SetEstrategia_vuelo( direccion_vuelo );
		municion SetEstado_correcto();
		escenario.Agregar_objeto( municion );
		return municion;				
	}

	@Override
	public boolean PuedeManejarItems() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean PuedeSerAtacado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void Actuar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void ActuarAnteColision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void EstadoCorrecto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void VerificarColision() {
		// TODO Auto-generated method stub
		
	}


	
}
