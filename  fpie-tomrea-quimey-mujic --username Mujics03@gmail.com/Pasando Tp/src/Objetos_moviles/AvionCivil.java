package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Excepciones.GameOverException;
import Mapa.Vector2D;
import Armas.*;
import Mapa.*;


public class AvionCivil extends Voladores {
	
	protected void Actuar(){
		this.moverseIAsegunVel();
	}
	
	protected void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoUsuario();
		puntos = 300;
		Velocidad = 1;
		estrategia_vuelo = new LineaRectaDown();
		Blindaje blindaje = new Blindaje()bando;
		blindaje.Blindaje( 100 );
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,5,5);
	}
	
	public boolean PuedeManejarItems(){
		return false;
	}
	
	
}
