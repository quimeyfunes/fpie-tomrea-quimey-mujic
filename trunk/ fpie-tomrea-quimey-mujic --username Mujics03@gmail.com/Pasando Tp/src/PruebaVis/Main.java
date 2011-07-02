package PruebaVis;

import ControladorInterfaz.*;
import Menu.Juego;
import Menu.MenuInicial;


public class Main
{
	public static void main(String[] args)
	{
		ControladorMenu conMenu = new ControladorMenu();
		
		MenuInicial menu = new MenuInicial( conMenu );
		Juego juego = new Juego();
		
		while(menu.EmpiezaJuego()==false){
			
		}
		boolean b =  menu.getCargarJuego();
		if( b ){
			juego.cargar(menu.getUsuario());
		}else{
			juego.jugar();
			}
		
		

		
		}
		
	


}