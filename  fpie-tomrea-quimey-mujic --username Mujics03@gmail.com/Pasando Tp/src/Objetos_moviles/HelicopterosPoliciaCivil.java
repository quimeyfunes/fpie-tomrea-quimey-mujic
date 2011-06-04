package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import Escenario.*;
import Excepciones.ChauBlindajeException; 
import Armas.*;
import Mapa.Vector2D;
import Objetos_moviles.*;


public class HelicopterosPoliciaCivil extends Voladores{
	
	protected void Actuar(){
		this.moverseIAsegunVel();
	}
	
	protected void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoUsuario();
		puntos = 200;
		Velocidad = 1;
		estrategia_vuelo = new LineaRectaDown(); // estrategia de vuelo circular
		Blindaje blindaje = new Blindaje()bando;
		blindaje.Blindaje( 100 );
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,5,5);
	}
	
	protected boolean PuedeManejarItems(){
		return false;
	}

}
