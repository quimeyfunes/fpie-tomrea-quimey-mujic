package Objetos_moviles;

import Armas.*;

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
		estrategia_vuelo = new Circular();
		this.blindaje = new Blindaje((short)50);
		this.ConfigurarCuerpo(3, 3);
	}
}