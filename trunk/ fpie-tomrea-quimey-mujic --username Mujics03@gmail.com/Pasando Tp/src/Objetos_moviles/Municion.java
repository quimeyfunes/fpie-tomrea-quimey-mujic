package Objetos_moviles;
import java.awt.Point;

public class Municion extends Objetos_moviles{

	public static void main(String[] args) {
		Vivo = true;
		Puntos = 0;
	}
	
	public Municion Crear_en( Point ubicacion, Estrategia_vuelo direccion_vuelo, String bando ){
		Municion municion = new Municion();
		municion setBando( bando );
		municion setPosicion(  );// new de ubicacion
		municion SetEstrategia_vuelo( direccion_vuelo );
		municion SetEstado_correcto();
		escenario.Agregar_objeto( municion );
		return municion;				
	}


	
}
