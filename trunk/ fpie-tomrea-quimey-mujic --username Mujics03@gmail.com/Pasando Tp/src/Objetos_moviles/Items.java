package Objetos_moviles;

import java.util.Iterator;
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
	protected synchronized void VerificarColision() {
		// buscar tipo generico Collection
		LinkedList<ObjetosMoviles> ObjVi =  Escenario.getInstance().objetosVivos();
		Iterator<ObjetosMoviles> it = ObjVi.iterator();
		
		while(it.hasNext()){
			ObjetosMoviles elemento = it.next();
			if ( (this.condicionComun(elemento))&&(elemento.PuedeManejarItems())){
				this.ActuarAnteColision(elemento);
			}
			
		}
	}
}
