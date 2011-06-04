package Pruebas;
import junit.framework.*;
import Armas.Danio;
import Objetos_moviles.*;
import org.junit.Assert;

public class Choque2avionesTest extends TestCase{
	// Testea el choque de algo42 contra una avioneta, y la esperada muerta de la avioneta despues 
	
	// Variables
	Algo42 algo42; 
	Avioneta avioneta; 
	int valor_esperado; 
	Danio danio; 
	
	// Creaciones de unidades
	algo42.crearEnXY( 150 , 145 );
	avioneta.crearEnXY( 150 , 150 );
	
	int i;
	for ( i = 0 ; i == 2 ; i++ ){
		algo42.arriba();
	}
	
	Assert.assertFalse( avioneta.EstaVivo() );
	danio = algo42.fuerzaDeChoque();
	valor_esperado = danio.lastimar();
	Assert.assertEquals( valor_esperando , 50 );
}
