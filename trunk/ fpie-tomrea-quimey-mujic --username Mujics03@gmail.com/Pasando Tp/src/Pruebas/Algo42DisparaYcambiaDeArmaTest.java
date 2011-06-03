package Pruebas;
import junit.framework.*;
import java.awt.Point;

public class Algo42DisparaYcambiaDeArmaTest extends TestCase{
	// Testea el disparo de un torpedo dirigido por Algo42 contra una avioneta
	
	// Variables
	Avioneta avioneta;
	Algo42 algo42;
	Municion municion;
	Point valor_esperado;
	LanzadorDeMisilesTeledirigidos misiles_dirigidos;
	
	//Creacion unidades
	avioneta.CrearEnXY( 120 , 120 );
	algo42.CrearEnXY( 100 , 100 );
	
	//Seteo y acoplamiento de los misiles
	misiles_dirigidos.bando( algo42.getBando() );
	misiles_dirigidos.direccionAapuntar( MovDirigido );
	algo42.agregarArma( misiles_dirigidos );
	
	//El misil es disparado y pasa a actuar como tal
	municion = algo42.disparar();
	municion.moverseIAsegunVel();
	
	// Ubicacion esperada del misil
	valor_esperando.setLocation( 100 , 108 ); 
	assertEquals( valor_esperando , municion.getPosicion );
	
	algo42.seleccionarSiguienteArma();
	municion = algo42.disparar();
	
	assertTrue( municion isistanceof TorpedosDirigido );
}
