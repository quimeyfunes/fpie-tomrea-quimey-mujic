package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Mapa.Vector2D;
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
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,3,3);
	}
}
