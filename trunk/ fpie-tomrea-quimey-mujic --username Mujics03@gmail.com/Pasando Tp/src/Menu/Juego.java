package Menu;


import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import Escenario.Escenario;
import ManejoXml.ParserNivelesXml;
import Objetos_moviles.Algo42;
import Objetos_moviles.AvionCivil;
import Objetos_moviles.Avioneta;
import Objetos_moviles.Bombardero;
import Objetos_moviles.Caza;
import Objetos_moviles.Exploradores;
import Objetos_moviles.Guia;
import Objetos_moviles.HelicopterosPoliciaCivil;
import Persistencia.Persistencia;
import Sonido.Sound;
import Vistas.VentanaPrincipal;
import Vistas.VistaBlindajeAlgo42;
import Vistas.VistaFondoJuego;
import Vistas.VistaGameOver;
import Vistas.VistaNextLevel;
import Vistas.VistaPuntos;
import Vistas.VistaWinner;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Juego {
	
	private int intervaloSimulacion = 21;
	
	private double LimiteX = Escenario.getLimiteX();
	private double LimiteY = Escenario.getLimiteY();
	private double AltDeEnemy = LimiteY - 20;
	private ControladorJuego controlador = new ControladorJuego(false);
	
	public Juego(){
		controlador.setIntervaloSimulacion(intervaloSimulacion);
		Escenario.InicializarEscenario(controlador);
		
	}
	
	public void jugar(){
	//+++++++++++++++++++++++++++++++
	


	
	Ventana ventana = new VentanaPrincipal(controlador, (int) LimiteX + 50, (int) LimiteY + 50);
	controlador.setSuperficieDeDibujo(ventana);
	ventana.setVisible(true);
	

	ParserNivelesXml parser = new ParserNivelesXml();
	boolean perdio = false;
	boolean gano = false;
	while ((!perdio) && (!gano))
	{
		VistaFondoJuego fondoJuego = new VistaFondoJuego();
		controlador.agregarDibujable(fondoJuego);
		
		controlador.agregarObjetoVivo(Escenario.getInstance());

		Random r = new Random();
		for (int i = 0; i < parser.getCantCazas(); i++)
		{
			Caza caza = new Caza((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
		}

		for (int i = 0; i < parser.getCantExploradores(); i++)
		{
			Exploradores explorador = new Exploradores((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
		}

		for (int i = 0; i < parser.getCantAvionetas(); i++)
		{
			Avioneta avioneta = new Avioneta((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
		}

		for (int i = 0; i < parser.getCantBombarderos(); i++)
		{
			Bombardero bombardero = new Bombardero((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
		}

		for (int i = 0; i < parser.getCantAvionCivil(); i++)
		{
			AvionCivil avion = new AvionCivil((double) r.nextInt((int) Escenario.getLimiteX()), (double) r
					.nextInt((int) Escenario.getLimiteY()));
		}

		for (int i = 0; i < parser.getCantHelicopteros(); i++)
		{
			HelicopterosPoliciaCivil hel = new HelicopterosPoliciaCivil((double) r.nextInt((int) Escenario
					.getLimiteX()), (double) r.nextInt((int) Escenario.getLimiteY()));
		}
		
		Guia guia = new Guia(20, 400);
		guia.setBlindaje(parser.getVidaGuia());
		
		Algo42 algo42 = new Algo42(950, 50);//ver de definir esto afuera
		DibujableExtra vistaAlgo = new VistaBlindajeAlgo42();
		vistaAlgo.setMonitoreable(algo42);
		controlador.agregarDibujable(vistaAlgo);
		Dibujable VistaPuntos = new VistaPuntos(Escenario.getInstance());
		controlador.agregarDibujable(VistaPuntos);
		controlador.agregarKeyPressObservador(algo42);
		
		try
		{
			while(controlador.getSeguirEjecutando())
			{
				if(!controlador.getPausado())
				{
					controlador.comenzarJuego();
				}
			}
			//Guardar partida = new Guardar();
			//partida.GuardarPartida(algo42, Escenario.getInstance());
		}
		catch (Exception e)
		{
			perdio=true;
			System.out.println("Perdiste, entrena mas nw");
			//testsong.cambiarTema("Whispering.mid");
		}
		
		if(!perdio && parser.getUltimoNivel()){
			gano = true;
		}
		else if(!perdio)
		{
			parser.pasarNivel();
			Escenario.aumentarNivel();
			System.out.println("nivel ganado");
			//Cargar partida = new Cargar();
			//partida.CargarPartida();
			controlador.DetenerBorrarJuego();
			controlador.agregarDibujable(fondoJuego);
			VistaNextLevel nextLevel = new VistaNextLevel();
			controlador.agregarDibujable(nextLevel);
			controlador.comenzarJuego(100);
			controlador.DetenerBorrarJuego();
			controlador.setSeguirEjecutando(true);
		}
	}
	
	controlador.DetenerBorrarJuego();
	if(perdio)
	{
		VistaGameOver game_over = new VistaGameOver();
		controlador.agregarDibujable(game_over);
	}
	else
	{
		VistaWinner winner = new VistaWinner();
		controlador.agregarDibujable(winner);
	}
	controlador.comenzarJuego();
}

	public void cargar(String usuario) {
		
		//OJO, muchas de estas cosas estan creadas como privado del metodo juego, no se si les sirven esos.
			
		//Sound testsong = new Sound("Laguerradelasgalaxias.mid");
		//testsong.playSound();
		
		// seteo el controlador y lo dejo listo para correr
		Escenario escenario = Escenario.getInstance();
		Hashtable Usuarios = escenario.getUsuarios();
		Persistencia persis = new Persistencia();
		persis.Cargar((LinkedList<String>) (Usuarios.get(usuario)));
		ControladorJuego controlador = new ControladorJuego(false);
		controlador.setIntervaloSimulacion(intervaloSimulacion);
		Escenario.InicializarEscenario(controlador);
		//+++++++++++++++++++++++++++++++
		Ventana ventana = new VentanaPrincipal(controlador, (int) LimiteX + 50, (int) LimiteY + 50);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
	}


}

