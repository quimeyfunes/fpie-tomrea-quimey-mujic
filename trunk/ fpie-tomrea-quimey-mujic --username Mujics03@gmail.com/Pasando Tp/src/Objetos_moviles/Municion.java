package Objetos_moviles;
import java.util.Iterator;
import java.util.LinkedList;

import Armas.Danio;
import Escenario.Escenario;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Mapa.Ubicacion;
import Mapa.Vector2D;

public abstract class Municion extends ObjetosMoviles{

	protected Danio danio;
	
	protected void constructor(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando, Municion m)
	{
		m.setBando(bando);
		m.Vivo=true;
		m.setPosicion(Ubicacion.crearUbicacionEnXY(posicion.x, posicion.y));
		m.CambiarEstrategiaDeVuelo(estrategia);
		m.EstadoCorrecto();
		Escenario.getInstance().agregarObjeto(m);//entra al mundo de los vivos
	}	
	
	public boolean PuedeManejarItems() {
		return false;
	}

	public boolean PuedeSerAtacado() {
		return true;
	}

	protected void Actuar() {
		this.moverseIAsegunVel();
		
	}

	protected void ActuarAnteColision(ObjetosMoviles movil) 
	{
		this.Destructor();
		movil.analizarDanio(this.daniar());
	}
	

	protected Danio daniar()
	{
		return this.danio;
	}

	protected synchronized void VerificarColision() 
	{
		LinkedList<ObjetosMoviles> ObjVi =  Escenario.getInstance().objetosVivos();
		Iterator<ObjetosMoviles> it = ObjVi.iterator();
		
		while(it.hasNext()){
			ObjetosMoviles elemento = it.next();
			if ( (this.condicionComun(elemento))&&(elemento.PuedeSerAtacado())){
				this.ActuarAnteColision(elemento);
			}
		}
		
	}
	
	public void cambiarDanio(short danio)
	{
		this.danio.setearPoder(danio);		
	} 


	
}
