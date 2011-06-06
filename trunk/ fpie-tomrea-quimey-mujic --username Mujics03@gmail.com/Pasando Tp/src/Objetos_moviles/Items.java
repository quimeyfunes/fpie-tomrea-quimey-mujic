package Objetos_moviles;

import java.util.LinkedList;

import Escenario.Escenario;
import Mapa.Ubicacion;

public abstract class Items extends ObjetosMoviles{
	
	protected void constructor(double x, double y,byte bando,Items item) {
		
		item.setPosicion(Ubicacion.crearUbicacionEnXY(x, y));
		item.EstadoCorrecto();
		item.Vivo=true;
		item.puntos=0;
		item.setBando(bando);
		Escenario.getInstance().agregarObjeto(item);//entra al mundo de los vivos
		
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
		this.VerificarColision();
		
	}


	@Override
	public abstract void ActuarAnteColision(ObjetosMoviles objeto);	
	


	@Override
	public abstract void EstadoCorrecto();


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
