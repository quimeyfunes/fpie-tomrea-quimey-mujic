package Objetos_moviles; 
import java.awt.geom.Rectangle2D;
import Excepciones.GameOverException;
import Mapa.Vector2D;
import Armas.*;
import Mapa.*;

public class Algo42 extends Voladores{
	
	protected void DESTRUCTOR() throws GameOvereException {
		Vivo = false; 
		throw new GameOverException();
	}
	
	protected void EstadoCorrecto(){
		// Verificar esta funcion que no existe
		bando = ObjetosMoviles bandoUsuario;
		Velocidad = 5;
		Blindaje blindaje = new Blindaje();
		blindaje.contruidoCon( 150 );
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,4,4);
		PistolaLaser pistola_laser = new PistolaLaser();
		// Verificar de dond sale bando
		pistolar_laser.PistolaLaser( bando , new LineaRectaUp() )
		weapons.add( pistola_laser );
	}
}
