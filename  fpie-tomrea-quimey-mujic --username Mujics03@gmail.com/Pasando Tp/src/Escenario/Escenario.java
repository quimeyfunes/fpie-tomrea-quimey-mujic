package Escenario;

import java.util.LinkedList;

import Excepciones.FinEscenarioException;
import Objetos_moviles.ObjetosMoviles;

public class Escenario
{
	LinkedList<ObjetosMoviles> todoLoQueEstaEnJuego;
	int sumaDePuntos;
	private static Escenario instance = null;
	
	private synchronized static void createInstance() {
		if (instance == null) { 
			instance = new Escenario();
	    }
	}
	
	public static Escenario getInstance() {
	    if (instance == null) 
	    	createInstance();
	    return instance;
	}

	public Escenario()
	{
		sumaDePuntos = 0;
		todoLoQueEstaEnJuego = new LinkedList< ObjetosMoviles >();
	}
	
	public LinkedList<ObjetosMoviles> objetosVivos() 
	{
		return todoLoQueEstaEnJuego;
	}
	
	public void agregarObjeto(ObjetosMoviles objeto)
	{
		this.todoLoQueEstaEnJuego.add(objeto);
	}
	
	public void eliminarObjeto(ObjetosMoviles objeto)
	{
		this.todoLoQueEstaEnJuego.remove(objeto);
	}
	
	private void limpiarListaYrecolectarPuntos()
	{
		//Itero sobre Muertos, borro sobre TodoLoQueEstaEnJuego , voy sumando puntos
		LinkedList<ObjetosMoviles> muertos = new LinkedList<ObjetosMoviles>();
		for (ObjetosMoviles movil : this.objetosVivos())
			if(!movil.EstaVivo())
				muertos.add(movil);
		
		for (ObjetosMoviles movil : muertos)
		{
			this.sumaDePuntos += movil.RecolectarPuntos();
			this.eliminarObjeto(movil);
		}
		
		if(this.sumaDePuntos >= 1000)
			throw new FinEscenarioException();
	}
	
	public void vivanTodos()
	{
		for (ObjetosMoviles movil : this.objetosVivos())
		{
			movil.VIVIR();
		}
		this.limpiarListaYrecolectarPuntos();
	}
}
