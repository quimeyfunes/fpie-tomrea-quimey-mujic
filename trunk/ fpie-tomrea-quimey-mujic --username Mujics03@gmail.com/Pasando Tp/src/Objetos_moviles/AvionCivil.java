package Objetos_moviles;
import Vistas.VistaAvionCivil;
import ar.uba.fi.algo3.titiritero.Dibujable;
import Armas.*;
import EstrategiasDeMov.DerechaIzquierda;


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
		this.estrategia_vuelo = new DerechaIzquierda();
		this.blindaje = new Blindaje((short)100);

		this.ConfigurarCuerpo(50,50);
	}

	public boolean PuedeManejarItems(){
		return false;
	}

	@Override
	public Dibujable getVista() {
		return new VistaAvionCivil();
	}
	
	
}
