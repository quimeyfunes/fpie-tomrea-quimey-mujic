package Objetos_moviles;

import java.awt.geom.Rectangle2D;

import Mapa.Vector2D;

public class ItemVida extends Items
{
	short hitPointsAsumar;
	
	public short reparar()
	{
		return hitPointsAsumar;		
	}
	
	//aca hay que poner una interfaz en Volador para manejar items	
	public void ActuarAnteColision(ObjetosMoviles objeto){
		//no reconoce el metodo porq esta en voladores
		objeto.manejarItemVida( this );
		this.Destructor();
		
	}
	
	public void EstadoCorrecto() {
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,1,1);
	}
	
	// falta el initialize..lo pongo en main??
}	
