package Pruebas;
import java.awt.Point;
import Objetos_moviles.*;
import junit.framework.*;
import Armas.*;
import org.junit.Assert;

public class Algo42DisparaYcambiaDeArmaTest extends TestCase{
	// Testea el disparo de un torpedo dirigido por Algo42 contra una avioneta
	
	// Variables
	Avioneta avioneta;
	Algo42 algo42;
	Municion municion;
	Point valor_esperado;
	LanzadorMisiles misiles_dirigidos;
	
	//Creacion unidades
	avioneta.CrearEnXY( 120 , 120 );
	algo42.CrearEnXY( 100 , 100 );
	
	//Seteo y acoplamiento de los misiles
	misiles_dirigidos = new LanzadorMisilesTeledirigidos();
	misiles_dirigidos.LanzadorMisilesTeledirigidos( algo42.getBando , MovDirigido );
	algo42.agregarArma( misiles_dirigidos );
	
	//El misil es disparado y pasa a actuar como tal
	municion = algo42.disparar();
	municion.moverseIAsegunVel();
	
	// Ubicacion esperada del misil
	valor_esperando.setLocation( 100 , 108 ); 
	Assert.assertEquals( valor_esperando , municion.getPosicion );
	
	algo42.seleccionarSiguienteArma();
	municion = algo42.disparar();
	Assert.assertTrue(  municion isistanceof TorpedosDirigido );
}
