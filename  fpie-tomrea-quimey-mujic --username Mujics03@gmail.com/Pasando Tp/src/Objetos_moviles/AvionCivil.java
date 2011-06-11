package Objetos_moviles;
import Armas.*;
import EstrategiasDeMov.LineaRectaDown;


public class AvionCivil extends Voladores {
	
	protected void Actuar(){
		this.moverseIAsegunVel();
	}
	
	public AvionCivil(double x, double y)
	{
		this.constructor(x, y, this);
	}
	
	protected void EstadoCorrecto(){
		this.bando = ObjetosMoviles.BandoUsuario();
		this.puntos = -300;
		this.Velocidad = 1;
		this.estrategia_vuelo = new LineaRectaDown();
		this.blindaje = new Blindaje((short)100);

		this.ConfigurarCuerpo(4,4);
	}
	
	public boolean PuedeManejarItems(){
		return false;
	}
	
	
}
