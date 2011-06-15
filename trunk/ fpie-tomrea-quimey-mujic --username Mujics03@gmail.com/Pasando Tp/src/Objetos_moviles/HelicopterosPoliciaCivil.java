package Objetos_moviles;

import Vistas.VistaHelicoptero;
import ar.uba.fi.algo3.titiritero.Dibujable;
import Armas.*;
import EstrategiasDeMov.Circular;


public class HelicopterosPoliciaCivil extends Voladores
{
	public HelicopterosPoliciaCivil(double x, double y)
	{
		this.constructor(x, y, this);
	}
	
	protected void Actuar(){
		this.moverseIAsegunVel();
	}
	
	protected void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoUsuario();
		puntos = 200;
		Velocidad = 1;
		this.ConfigurarCuerpo(20,20);
		estrategia_vuelo = new Circular(Circular.radioStandarSegunDistancia(this.getPosicion())) ; // estrategia de vuelo circular
		this.blindaje = new Blindaje((short)100);

	}
	
	public boolean PuedeManejarItems(){
		return false;
	}

	@Override
	public Dibujable getVista() {
		return new VistaHelicoptero();
	}

}
