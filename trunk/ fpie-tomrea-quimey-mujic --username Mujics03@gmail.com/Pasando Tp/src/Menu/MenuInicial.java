package Menu;


import Vistas.VistaEmpezarNivelBoton;
import Vistas.VistaSalirJuegoBoton;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;


public class MenuInicial implements MouseClickObservador{
	
	private boolean exitClicked = false;
	
	private ControladorJuego controlador;

	@Override
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


	
}