package Menu;


import Vistas.VistaEmpezarNivelBoton;
import Vistas.VistaSalirJuegoBoton;
import Vistas.VistaTutorialBoton;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;


public class MenuInicial implements MouseClickObservador{
	
	private boolean exitClicked = false;
	private boolean tutorialButonClicked;
	
	private ControladorJuego controlador;

	
	public void MouseClick(int x, int y) {
		if(  x >= VistaEmpezarNivelBoton.getPosX() &&  x <= VistaEmpezarNivelBoton.getPosX() + VistaEmpezarNivelBoton.getAncho() ){
			
			if( y >= VistaEmpezarNivelBoton.getPosY() &&  y <= VistaEmpezarNivelBoton.getPosY() + VistaEmpezarNivelBoton.getAlto()  ){
				//se seleciono empezar
				System.out.print("empezar");
				this.controlador.detenerJuego();
			}
			else if( y >= VistaSalirJuegoBoton.getPosY() &&  y <= VistaSalirJuegoBoton.getPosY() + VistaSalirJuegoBoton.getAlto()  ){
				System.exit(0);
					
			}
			else if( y >= VistaTutorialBoton.getPosY() &&  y <= VistaTutorialBoton.getPosY() + VistaTutorialBoton.getAlto()  ){
				this.tutorialButonClicked = true;
				this.controlador.detenerJuego();
				
				
			}
			else{
				System.out.print("x="+x+" y="+y);
			}		
			
		}else{
			System.out.print("x="+x+" y="+y);
		}
	}

	public void setControlador(ControladorJuego controlador) {
		this.controlador = controlador;
		
	}

	

	public boolean isExitClicked() {
		return exitClicked;
	}

	public void setTutorialButonClicked(boolean tutorialButonClicked) {
		this.tutorialButonClicked = tutorialButonClicked;
	}

	public boolean isTutorialButonClicked() {
		return tutorialButonClicked;
	}


	
}