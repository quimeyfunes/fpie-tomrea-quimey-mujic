package Menu;


import Vistas.VistaEmpezarNivelBoton;
import Vistas.VistaSalirJuegoBoton;
import Vistas.VistaTutorialBoton;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;


public class MenuTutorial implements MouseClickObservador{
	
	private boolean backToMainMenuClicked = false;
	private int anchoMaximo = 450;
	private int anchoMinimo = 780;
	private int altoMaximo = 620;
	private int altoMinimo = 670;
	
	private ControladorJuego controlador;

	
	public void MouseClick(int x, int y) {
		if(  x >= this.anchoMinimo &&  x <= this.altoMaximo ){
			if(  y >= this.altoMinimo &&  y <= this.altoMinimo ){
				backToMainMenuClicked = true;
				System.exit(0);
			}
		}
			
			
	}


	public boolean isBackToMainMenuClicked() {
		return backToMainMenuClicked;
	}



	
}