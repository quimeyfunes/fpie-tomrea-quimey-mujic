package ControladorInterfaz;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Menu.Juego;
import Menu.MenuInicial;


public class ControladorMenu {
		
		public ControladorMenu()
		{
		}
		
		private class EscuchaBotonEmpezar implements ActionListener
		{
			private MenuInicial men;
			EscuchaBotonEmpezar(MenuInicial men){
				this.men=men;
				}
		
			public synchronized void actionPerformed(ActionEvent e)
			{
				men.MostrarEmpezarJuego();
				}
			}
		
		private class EscuchaBotonSalir implements ActionListener
		{	
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}
		
		
		private class EscuchaBotonTutorial implements ActionListener
		{	
			private MenuInicial men;
			
			EscuchaBotonTutorial(MenuInicial men){
				this.men=men;
			}
			
			public void actionPerformed(ActionEvent e)
			{
				men.MostrarTutorial();
			}
		}
		
		private class EscuchaBotonCargarPartida implements ActionListener
		{	
			private MenuInicial men;
			
			EscuchaBotonCargarPartida(MenuInicial men){
				this.men = men;
			}
			
			public void actionPerformed(ActionEvent e)
			{
				
				men.MostrarCargarJuego();
				
			}
		}

		private class EscuchaBotonAtras implements ActionListener
		{
			private MenuInicial men;
			
			EscuchaBotonAtras( MenuInicial men ){
				this.men=men;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				this.men.MostrarMenuInicial();
			}
			
		}
		
		
		
	public ActionListener getListenerBotonEmpezar(MenuInicial men) {
		return new EscuchaBotonEmpezar(men);
	}

	public ActionListener getListenerBotonSalir() {
		return new EscuchaBotonSalir();
	}
	
	public ActionListener getListenerBotonTutorial(MenuInicial men) {
		return new EscuchaBotonTutorial(men);
	}
	public ActionListener getListenerBotonCargarPartida(MenuInicial men) {
		return new EscuchaBotonCargarPartida(men);
	}
	

	public ActionListener getListenerBotonAtras(MenuInicial men) {
		return new EscuchaBotonAtras(men);
	}

}
