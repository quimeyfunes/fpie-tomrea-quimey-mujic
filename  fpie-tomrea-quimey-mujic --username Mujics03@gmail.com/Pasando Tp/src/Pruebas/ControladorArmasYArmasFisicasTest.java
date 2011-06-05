package Pruebas;
import junit.framework.*;
import Armas.*;
import Mapa.Vector2D;
import Objetos_moviles.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControladorArmasYArmasFisicasTest extends TestCase{
	
	private PistolaLaser pistola_laser; 
	private LanzadorCohetes lanzador_cohetes;
	private ControladorArmas controlador_armas; 
	
	@Before
	public void setUp() throws Exception {
		
		pistola_laser = new PistolaLaser( ObjetosMoviles.BandoUsuario(), new LineaRectaUp() );
		lanzador_cohetes = new LanzadorCohetes(  ObjetosMoviles.BandoUsuario(), new LineaRectaUp() );
		controlador_armas = new ControladorArmas();
		
		controlador_armas.add( pistola_laser );
		controlador_armas.add( lanzador_cohetes );
	}
	
	@Test
	public void testCreacion(){
	
		Assert.assertTrue( (controlador_armas.dispararElArmaSeleccionada( new Vector2D(10, 10) )) instanceof Laser);
		controlador_armas.seleccionarSiguienteArma(); 
		Assert.assertTrue( controlador_armas.dispararElArmaSeleccionada( new Vector2D(20, 20) ) instanceof Cohete );
		controlador_armas.seleccionarSiguienteArma();
		Assert.assertTrue( controlador_armas.dispararElArmaSeleccionada( new Vector2D(10, 10) ) instanceof Laser );
		controlador_armas.seleccionarSiguienteArma();
		
		int i; 
		for ( i = 0 ; i == 13 ; i++ ){
			controlador_armas.dispararElArmaSeleccionada( new Vector2D(20, 20) );
		}
	Assert.assertTrue( ( controlador_armas.dispararElArmaSeleccionada( new Vector2D(20, 20) )) instanceof Laser );

	}
}	
