package Objetos_moviles;

import java.util.Iterator;
import java.util.LinkedList;

import ar.uba.fi.algo3.titiritero.Dibujable;

import Armas.Blindaje;
import Armas.Danio;
import Escenario.Escenario;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Mapa.Vector2D;
import Vistas.VistaTorpedo;

public class TorpedoDirigido extends Municion implements Rastreador
{
	private ObjetosMoviles objetivo;
	public TorpedoDirigido(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando)
	{
		this.constructor(posicion, estrategia, bando, this);
		this.buscarObjetivoSegunBando();
	}	
	
	private void setObjetivo(ObjetosMoviles movil)
	{
		this.objetivo = movil;
	}
	
	private void buscarObjetivoSegunBando()
	{
		boolean bandera = false;
		
		LinkedList<ObjetosMoviles> ObjVi =  Escenario.getInstance().objetosVivos();
		Iterator<ObjetosMoviles> it = ObjVi.iterator();
				
		while(it.hasNext() && !bandera){
			
			ObjetosMoviles movil = it.next();
			if(this.smallCondicion(movil) && movil.PuedeManejarItems())
			{
				this.setObjetivo(movil);
				bandera = true;
			}
		}
		if(!bandera)
			this.Destructor();
	
		//si no encuentra nada enemigo para perseguir, explota
	}
	
	
	public Vector2D getPosicionDelObjetivo()
	{
		return this.objetivo.getPosicion();
	}

	protected void EstadoCorrecto()
	{
		this.danio = new Danio((short)40);
		this.Velocidad = 1;
		this.blindaje= new Blindaje((short)30);

		this.ConfigurarCuerpo(3,2);
	}
	
	public void moverseIAsegunVel()
	{
		if(this.EstaVivo())
		{
			if(this.objetivo.EstaVivo())
				this.movPrivado();
			else
				this.buscarObjetivoSegunBando();
		}
		else
			this.Destructor();
		//Misil inteligente.SI el objetivo que estaba persiguiendo es destruido, simplemente busca otro
	}
	
	private void movPrivado()
	{
		for (int i = 0; i < this.Velocidad ; i++)
		{
			this.moverse();
		} 
	}

	@Override
	public Dibujable getVista() {
		return new VistaTorpedo();
	}
}
