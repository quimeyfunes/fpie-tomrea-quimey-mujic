package Pruebas;
import junit.framework.*;
import Armas.*;
import Objetos_moviles.*;
import org.junit.Assert;

public class ControladorArmasYArmasFisicasTest extends TestCase{
	
	PistolaLaser pistola_laser; 
	LanzadorCohetes lanzador_cohetes;
	ControladorArmas controlador_armas; 
	
	pistola_laser = new PistolaLaser();
	pistola_laser.Pistola_laser( ObjetosMoviles.BandoUsuario();, new LineaRectaUp() );
	lanzador_cohetes = new LanzadorCohetes();
	lanzador_cohetes.LanzadorCohetes(  ObjetosMoviles.BandoUsuario(), new LineaRectaUp() );
	controlador_armas = new ControladorArmas();
	
	controlador_armas.add( pistola_laser );
	controlador_armas.add( lanzador_cohetes );
	
	Assert.assertTrue( controlador_armas.dispararElArmaSeleccionadaDesde( 10, 10 ) isinstanceof( Laser ));
	controlador_armas.seleccionarSiguienteArma(); 
	Assert.assertTrue( controlador_armas.dispararElArmaSeleccionadaDesde( 20, 20 ) isinstanceof( Cohete ));
	controlador_armas.seleccionarSiguienteArma();
	Assert.assertTrue( controlador_armas.dispararElArmaSeleccionadaDesde( 30, 30 ) isinstanceof( Laser ));
	controlador_armas.seleccionarSiguienteArma();
	
	int i; 
	for ( i = 0 ; i == 13 ; i++ ){
		controlador_armas.dispararElArmaSeleccionadaDesde( 20, 20 );
	}
	Assert.assertTrue( ( controlador_armas.dispararElArmaSeleccionadaDesde( 20, 20 ) ) isinstanceof( Laser ));
}
