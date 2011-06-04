package Pruebas;
import junit.framework.*;
import Armas.Danio;
import Mapa.Ubicacion; 
import Escenario.*;
import Objetos_moviles.*;
import org.junit.Assert;

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
	// verificar si va a haber un inicializar o si lo seteo desde las pruebas
	objetos_moviles.Inicializar( escenario );
	ubicacion.Inicializar();
	estrategiaDeVuelo.Inicializar();
	caza.crearEnXY( 100 , 100);
	
	danio = new Danio();
	danio.setearPoder( 200 );
	caza.analizarDanio( danio );
	algo42.crearEnXY( 100 , 100 );
	
	algo42.Verificar_Colicion();
	
	danio.setearPoder( 160 );
	algo42.analizarDanio( danio );
	//Algo sigue vivo debido a la vida del item obtenido 
	Assert.assertFalse( algo42.EstaVivo );
}
