package Objetos_moviles;

import java.awt.geom.Rectangle2D;

import Armas.Danio;
import Escenario.Escenario;
import Excepciones.ChauBlindajeException;
import Mapa.Ubicacion;
import Mapa.Vector2D;

public class TorpedoDirigido extends Municion
{
	private ObjetosMoviles objetivo;
	public TorpedoDirigido(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando)
	{
		this.setBando(bando);
		this.setPosicion(Ubicacion.crearUbicacionEnXY(posicion.x, posicion.y));
		this.CambiarEstrategiaDeVuelo(estrategia);
		this.EstadoCorrecto();
		Escenario.getInstance().agregarObjeto(this);//entra al mundo de los vivos
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
	
	@SuppressWarnings("unused")
	private Vector2D getPosicionDelObjetivo()
	{
		return this.objetivo.getPosicion();
	}

	protected void EstadoCorrecto()
	{
		this.danio = new Danio((short)40);
		this.Velocidad = 4;
		Vector2D p = ubicacion.XY();

		Cuerpo = new Rectangle2D.Double( p.x,p.y,2,2);
		this.buscarObjetivoSegunBando();
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
