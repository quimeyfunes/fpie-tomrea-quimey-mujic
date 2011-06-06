package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Mapa.Vector2D;
import Armas.*;

public class Caza extends Voladores
{
	public Caza(double x, double y)
	{
		this.constructor(x, y, this);
	}	
	
	public void Actuar(){
		if ( Timing >= 5 ) {
			Timing = 0;
			this.seleccionarSiguienteArma();
			this.disparar();
		} else { 
			this.moverseIAsegunVel();
			Timing = Timing + 1;
		}
	}
	
	public void DESTRUCTOR(){
		this.Vivo = false;
		ItemVida item_vida = new ItemVida();
		// falta la funcion crear en 
	}
	
	public void EstadoCorrecto(){
		this.bando = ObjetosMoviles.BandoEnemigo();
		this.puntos = 30; 
		Velocidad = 3;
		estrategia_vuelo = new LineaRectaDown();
		this.blindaje = new Blindaje((short)100);
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,4,4);
		PistolaLaser pistola_laser = new PistolaLaser(bando , new LineaRectaDown());
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes(bando , new LineaRectaDown());
		weapons.add( pistola_laser );
		weapons.add( lanzador_cohetes );
	}
}
