package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Mapa.Vector2D;
import Armas.*;


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
		Vector2D p = ubicacion.XY();
		this.Cuerpo = new Rectangle2D.Double( p.x,p.y,5,5);
	}
	
	public boolean PuedeManejarItems(){
		return false;
	}
	
	
}
