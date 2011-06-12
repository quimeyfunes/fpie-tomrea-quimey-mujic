package Controlador;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import Escenario.Escenario;
import Objetos_moviles.*;

public class ControladorAvioneta {

	public static void main(String[] args) {
		
		double LimiteX = Escenario.getLimiteX();
		double LimiteY = Escenario.getLimiteY();
		

		/*
		 * Primero instancio mi modelo: una pelota que se mueve por una mesa
		 */
<<<<<<< .mine
		Avioneta avioneta = new Avioneta( 100 , 0 );
		Avioneta a2 = new Avioneta( 200 , 0 );
		Avioneta a3 = new Avioneta( 300 , 150 );
		Avioneta a4 = new Avioneta( 400 , 350 );
		
=======
		Bombardero bombardero = new Bombardero( 160  ,LimiteY -10);
		Avioneta avioneta = new Avioneta( 100 , LimiteY-10 );
>>>>>>> .r137
		Mesa unaMesa = new Mesa((int)LimiteX,(int)LimiteY);

		/*
		 * Luego instancio los objetos del framework: una ventana y el controlador
		 */		
		ControladorJuego controlador = new ControladorJuego(true);
		Ventana ventana = new VentanaPrincipal( controlador,(int)LimiteX,(int)LimiteY );
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		/*
		 * Instancio un cuadrado para que actue como vista de la mesa
		 */
		VistaMesa vistaMesa = new VistaMesa();
		vistaMesa.setPosicionable(unaMesa);
		
		/*
		 * Instancio una imagen para que actue como vista de la pelota
		 */
		VistaBombardero vistaBombardero = new VistaBombardero();
		VistaAvioneta vistaAvioneta = new VistaAvioneta();
		vistaAvioneta.setPosicionable(avioneta);
		vistaBombardero.setPosicionable(bombardero);
		
		VistaAvioneta vistaa2 = new VistaAvioneta();
		vistaa2.setPosicionable(a2);
		
		VistaAvioneta vistaa3 = new VistaAvioneta();
		vistaa3.setPosicionable(a3);
		
		VistaAvioneta vistaa4 = new VistaAvioneta();
		vistaa4.setPosicionable(a4);
		
		/*
		 * agrego la pelota a la lista de objetos vivios del controlador
		 * para que este le de vida dentro del gameloop
		 */
		controlador.agregarObjetoVivo(avioneta);
<<<<<<< .mine
		controlador.agregarObjetoVivo(a2);
		controlador.agregarObjetoVivo(a3);
		controlador.agregarObjetoVivo(a4);
=======
		controlador.agregarObjetoVivo(bombardero);
>>>>>>> .r137
		
		/*
		 * Agrego los objetos que actuan como vista a la lista de dibujables del controlador
		 * para que sean repintados al final de cada gameloop
		 */
		
		controlador.agregarDibujable(vistaMesa);
		controlador.agregarDibujable(vistaAvioneta);
<<<<<<< .mine
		controlador.agregarDibujable(vistaa2);
		controlador.agregarDibujable(vistaa3);
		controlador.agregarDibujable(vistaa4);
=======
		controlador.agregarDibujable(vistaBombardero);
>>>>>>> .r137
		
		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
		
	}
}
