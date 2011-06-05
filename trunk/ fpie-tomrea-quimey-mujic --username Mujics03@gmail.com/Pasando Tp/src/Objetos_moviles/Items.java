package Objetos_moviles;

import java.util.LinkedList;

import Escenario.Escenario;

public class Items extends ObjetosMoviles{
	
	public void Verificar_colicion(){
		//borre lo que estaba aca
	}

	
	public boolean Maneja_items(){
		return false;
	}
	
	public boolean Puede_ser_atacado(){
		return false;
	}


	@Override
	public boolean PuedeManejarItems() {
		return false;
	}


	@Override
	public boolean PuedeSerAtacado() {
		return false;
	}


	@Override
	protected void Actuar() {
		this.Verificar_colicion();
		
	}


	@Override
	public abstract void ActuarAnteColision(ObjetosMoviles objeto);	
	


	@Override
	public abstract void EstadoCorrecto() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void VerificarColision() {
		Escenario esc = Escenario.getInstance();
		// buscar tipo generico Collection
		LinkedList<ObjetosMoviles> todoLoQueEstaEnJuego = esc.objetosVivos();
		int j; 
		for ( j = 0 ; j == todoLoQueEstaEnJuego.size() ; j++ ){
			ObjetosMoviles elemento = todoLoQueEstaEnJuego.get( j );
			if ( elemento.condicionComun(elemento) && ( elemento.PuedeManejarItems() ) ) this.ActuarAnteColision(elemento);
			}
	}
}
