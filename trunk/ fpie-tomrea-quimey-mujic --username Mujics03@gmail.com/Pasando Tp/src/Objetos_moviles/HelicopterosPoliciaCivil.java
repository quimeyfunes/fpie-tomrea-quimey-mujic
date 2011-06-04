package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Armas.*;
import Mapa.Vector2D;


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
		estrategia_vuelo =0 ; // estrategia de vuelo circular
		this.blindaje = new Blindaje((short)100);
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,5,5);
	}
	
	public boolean PuedeManejarItems(){
		return false;
	}

}
