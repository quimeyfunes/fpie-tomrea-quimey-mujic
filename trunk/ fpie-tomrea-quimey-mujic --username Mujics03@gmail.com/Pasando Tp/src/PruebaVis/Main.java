package PruebaVis;


import ControladorInterfaz.ControladorMenu;

import Menu.Juego;
import Menu.MenuInicial;

//import Persistencia.*;

public class Main
{
	public static void main(String[] args)
	{

		ControladorMenu conMenu = new ControladorMenu();
		
		MenuInicial menu = new MenuInicial( conMenu );
		
	}


}
