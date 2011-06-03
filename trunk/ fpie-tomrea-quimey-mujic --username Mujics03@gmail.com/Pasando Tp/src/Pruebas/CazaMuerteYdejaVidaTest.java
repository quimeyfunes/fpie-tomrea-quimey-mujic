package Pruebas;
import junit.framework.*;


public class CazaMuerteYdejaVidaTest extends TestCase{
	// Testea la muerte del caza y que algo sigue vivo debido al item liberado por este.
	
	// Variables
	Escenario escenario; 
	ObjetosMoviles objetos_moviles; 
	Ubicacion ubicacion; 
	EstrategiaDeVuelo estrategiaDeVuelo; 
	Caza caza; 
	Danio danio; 
	Algo42 algo42; 
	
	//Inicializa las unidades
	objetos_moviles.Inicializar( escenario );
	ubicacion.Inicializar();
	estrategiaDeVuelo.Inicializar();
	caza.crearEnXY( 100 , 100);
	
	
	danio = Danio.De( 200 );
	caza.analizarDanio( danio );
	algo42.crearEnXY( 100 , 100 );
	
	algo42.Verificar_Colicion();
	
	danio = Danio.De( 160 );
	algo42.analizarDanio( danio );
	//Algo sigue vivo debido a la vida del item obtenido 
	assertFalse( algo42.EstaVivo );
}
