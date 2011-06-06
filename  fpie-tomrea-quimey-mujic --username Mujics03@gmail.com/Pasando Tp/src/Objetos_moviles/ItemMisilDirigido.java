package Objetos_moviles;
import java.awt.geom.Rectangle2D;

import Armas.*;
import Mapa.Vector2D;

public class ItemMisilDirigido extends Items{

	public void ActuarAnteColision(ObjetosMoviles objeto){
		// falta interface, metodo agregararma
		LanzadorMisiles misiles_dirigidos = new LanzadorMisiles( objeto.getBando() , new MovDirigido());
		objeto.agregarArma( misiles_dirigidos );
		this.Destructor();
	}
	
	public void EstadoCorrecto() {
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,2,2);
	}
	
	// falta initialize..va en main? 
}