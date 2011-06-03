package Pruebas;
import junit.framework.*;

public class ControladorArmasYArmasFisicasTest extends TestCase{
	
	PistolaLaser pistola_laser; 
	LanzadorDeCohete lanzador_cohetes;
	ControladorArmas controlador_armas; 
	
	pistola_laser = new PistolaLaser( ObjetosMoviles bandoUsuario, LineaRectaUp );
	lanzador_cohetes = new LanzadorDeCoehte( ObjetosMoviles bandoUsuario, LineaRectaUp );
	controlador_armas = new ControladorArmas();
	
	controlador_armas.add( pistola_laser );
	controlador_armas.add( lanzador_cohetes );
	
	assertTrue( controlador_armas.dispararElArmaSeleccionadaDesde( 10, 10 ) isinstanceof( Laser ));
	controlador_armas.SeleccionarSiguienteArma; 
	assertTrue( controlador_armas.dispararElArmaSeleccionadaDesde( 20, 20 ) isinstanceof( Cohete ));
	controlador_armas.SeleccionarSiguienteArma;
	assertTrue( controlador_armas.dispararElArmaSeleccionadaDesde( 30, 30 ) isinstanceof( Laser ));
	controlador_armas.SeleccionarSiguienteArma;
	
	int i; 
	for ( i = 0 ; i = 13 ; i++ ){
		controlador_armas.dispararElArmaSeleccionadaDesde( 20, 20 );
	}
	assertTrue( ( controlador_armas.dispararElArmaSeleccionadaDesde( 20, 20 ) ) isinstanceof( Laser ));
}
