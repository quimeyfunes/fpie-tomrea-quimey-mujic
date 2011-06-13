package PruebaVisual;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import Escenario.Escenario;
import Objetos_moviles.*;

public class PruebaVisual {

	public static void main(String[] args) {
		
		double LimiteX = Escenario.getLimiteX();
		double LimiteY = Escenario.getLimiteY();
		double AltDeEnemy = LimiteY-20;
		//esos son limites que uso para probar la simulacion
		
		//seteo el controlador y lo dejo listo para correr		
		ControladorJuego controlador = new ControladorJuego(true);
		Ventana ventana = new VentanaPrincipal( controlador,(int)LimiteX+ 50,(int)LimiteY +50);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		VistaMesa vistaMesa = new VistaMesa();
		Mesa unaMesa = new Mesa((int)LimiteX+50,(int)LimiteY+50);
		vistaMesa.setPosicionable(unaMesa);
		
		controlador.agregarDibujable(vistaMesa);
		controlador.setIntervaloSimulacion(20);
		//fin seteo controlador
		Escenario.InicializarEscenario(controlador);
	
		Caza caza = new Caza ( 20 , AltDeEnemy );
		Exploradores explorador = new Exploradores( 300, AltDeEnemy );
		Bombardero bombardero = new Bombardero( 700  ,AltDeEnemy);
		Avioneta avioneta = new Avioneta( 500 , AltDeEnemy );
		Algo42 algo42 = new Algo42(950,50);
	

		controlador.comenzarJuego();
		
	}
}
