package Objetos_moviles;

import Armas.Danio;
import Escenario.Escenario;
import Excepciones.ChauBlindajeException;
import Mapa.Vector2D;

public class TorpedoDirigido extends Municion
{
	private ObjetosMoviles objetivo;
	public TorpedoDirigido(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando)
	{
		this.constructor(posicion, estrategia, bando, this);
	}	
	
	private void setObjetivo(ObjetosMoviles movil)
	{
		this.objetivo = movil;
	}
	
	private void buscarObjetivoSegunBando()
	{
		boolean bandera = false;
		
		for (ObjetosMoviles movil: Escenario.getInstance().objetosVivos())
		{
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
		this.Velocidad = 4;

		this.ConfigurarCuerpo(2,2);
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
			throw new ChauBlindajeException();
		//Misil inteligente.SI el objetivo que estaba persiguiendo es destruido, simplemente busca otro
	}
	
	private void movPrivado()
	{
		for (int i = 0; i < this.Velocidad ; i++)
		{
			this.moverse();
		} 
	}
}
