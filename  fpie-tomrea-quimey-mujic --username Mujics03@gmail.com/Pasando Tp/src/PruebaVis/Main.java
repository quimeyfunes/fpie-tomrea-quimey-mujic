package PruebaVis;

import java.util.Random;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import Sonido.Sound;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ControladorInterfaz.ControladorMenu;
import Escenario.Escenario;
import ManejoXml.ParserNivelesXml;
import Menu.MenuInicial;
import Objetos_moviles.*;
//import Persistencia.*;

public class Main
{
	public static void main(String[] args)
	{

		ControladorMenu conMenu = new ControladorMenu();
		
		MenuInicial menu = new MenuInicial( conMenu );

	}
}
