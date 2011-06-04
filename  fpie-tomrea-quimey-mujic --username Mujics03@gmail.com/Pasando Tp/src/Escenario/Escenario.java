package Escenario;

import java.util.List;

import Excepciones.FinEscenarioException;
import Objetos_moviles.Municion;
import Objetos_moviles.ObjetosMoviles;

public class Escenario
{
	List<ObjetosMoviles> todoLoQueEstaEnJuego;
	int sumaDePuntos;

	public Escenario()
	{
		sumaDePuntos = 0;
		todoLoQueEstaEnJuego = new List<ObjetosMoviles>();
	}
	
	public List<ObjetosMoviles> objetosVivos() 
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
	
	public void limpiarListaYrecolectarPuntos()
	{
		//Itero sobre Muertos, borro sobre TodoLoQueEstaEnJuego , voy sumando puntos
		List<ObjetosMoviles> muertos = new List<ObjetosMoviles>();
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
			movil.vivir();
		}
		this.limpiarListaYrecolectarPuntos();
	}
}
