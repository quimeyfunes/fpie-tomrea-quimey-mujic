package Objetos_moviles; 
import java.awt.geom.Rectangle2D;
import Excepciones.GameOverException;
import Mapa.Vector2D;
import Armas.*;

public class Algo42 extends Voladores{
	
	protected void DESTRUCTOR() throws GameOverException {
		Vivo = false; 
		throw new GameOverException();
	}
	
	protected void EstadoCorrecto(){ 
		this.bando = ObjetosMoviles.BandoUsuario();
		this.Velocidad = 5;
		this.blindaje = new Blindaje((short) 150);
		Vector2D p = ubicacion.XY();
		this.Cuerpo = new Rectangle2D.Double( p.x,p.y,4,4);
		PistolaLaser pistola_laser = new PistolaLaser( this.bando ,new LineaRectaUp());
		this.weapons.add( pistola_laser );
	}
}
