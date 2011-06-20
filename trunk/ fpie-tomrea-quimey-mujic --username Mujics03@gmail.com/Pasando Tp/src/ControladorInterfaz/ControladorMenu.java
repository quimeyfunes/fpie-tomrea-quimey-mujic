package ControladorInterfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu {
		
		public ControladorMenu()
		{
		}
		
		private class EscuchaBotonEmpezar implements ActionListener
		{	public void actionPerformed(ActionEvent e)
			{
				
			

			}
		}
		
		private class EscuchaBotonSalir implements ActionListener
		{	
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}
		
		
		private class EscuchaBotonTutorial implements ActionListener
		{	public void actionPerformed(ActionEvent e)
			{
			
			}
		}

	public ActionListener getListenerBotonEmpezar() {
		return new EscuchaBotonEmpezar();
	}

	public ActionListener getListenerBotonSalir() {
		return new EscuchaBotonSalir();
	}
	
	public ActionListener getListenerBotonTutorial() {
		return new EscuchaBotonTutorial();
	}
}
