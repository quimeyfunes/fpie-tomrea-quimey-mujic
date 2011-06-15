package PruebaVis;

import java.util.Random;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import Escenario.Escenario;
import Excepciones.GameOverException;
import ManejoXml.ParserNivelesXml;
import Objetos_moviles.*;

public class PruebaVisual
{

	public static void main(String[] args)
	{

		double LimiteX = Escenario.getLimiteX();
		double LimiteY = Escenario.getLimiteY();
		double AltDeEnemy = LimiteY - 20;
		// esos son limites que uso para probar la simulacion

		// seteo el controlador y lo dejo listo para correr
		ControladorJuego controlador = new ControladorJuego(false);
		Ventana ventana = new VentanaPrincipal(controlador, (int) LimiteX + 50, (int) LimiteY + 50);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);

		controlador.setIntervaloSimulacion(25);
		// fin seteo controlador
		Escenario.InicializarEscenario(controlador);

		ParserNivelesXml parser = new ParserNivelesXml();
		boolean perdio = false;
		boolean gano = false;
		while ((!perdio) && (!gano))
		{
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

			controlador.agregarObjetoVivo(Escenario.getInstance());

			Algo42 algo42 = new Algo42(950, 50);

			DibujableExtra vistaAlgo = new VistaBlindajeAlgo42();
			vistaAlgo.setMonitoreable(algo42);
			controlador.agregarDibujable(vistaAlgo);

			Dibujable VistaPuntos = new VistaPuntos(Escenario.getInstance());
			controlador.agregarDibujable(VistaPuntos);

			Guia guia = new Guia(20, 400);
			guia.setBlindaje(parser.getVidaGuia());

			controlador.agregarKeyPressObservador(algo42);

			try
			{
				controlador.comenzarJuego();
			}
			catch (GameOverException e)
			{
				controlador.detenerJuego();
				perdio = true;
			}
			if(parser.getUltimoNivel())
				gano = true;
			else if(!perdio)
				parser.pasarNivel();
		}

	}
}
