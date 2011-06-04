package Escenario;

import java.util.List;

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

}
