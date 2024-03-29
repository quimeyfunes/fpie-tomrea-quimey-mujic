package Objetos_moviles;

import Vistas.VistaExplorador;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import Armas.*;
import EstrategiasDeMov.Circular;

public class Exploradores extends Voladores
{
	public Exploradores(double x, double y)
	{
		this.constructor(x, y, this);
	}	
	
	public void Actuar(){
		this.moverseIAsegunVel();
	}
	
	public void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoEnemigo();
		puntos = 50; 
		Velocidad = 3;
		// Verificar variables necesarias pra el movimientos circular
		this.blindaje = new Blindaje((short)50);
		this.ConfigurarCuerpo(25, 25);
		estrategia_vuelo = new Circular( Circular.radioStandarSegunDistancia(this.getPosicion()));
	}

	@Override
	public DibujableExtra getVista() {
		return new VistaExplorador();
	}
}
