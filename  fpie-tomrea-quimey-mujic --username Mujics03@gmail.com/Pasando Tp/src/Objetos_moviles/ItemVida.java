package Objetos_moviles;

import Vistas.VistaItemVida;
import ar.uba.fi.algo3.titiritero.Dibujable;

public class ItemVida extends Items
{
	private short hitPointsAsumar;
	
	public ItemVida(double x,double y,byte bando){
		this.constructor(x, y, bando, this);
	}
	
	public short reparar()
	{
		return hitPointsAsumar;		
	}
	
	public void ActuarAnteColision(ObjetosMoviles objeto){
		((Voladores)objeto).manejarItemVida( this );
		this.Destructor();
		
	}
	
	public void EstadoCorrecto() {
		this.hitPointsAsumar=50;
		this.ConfigurarCuerpo(10,10);
	}

	@Override
	public Dibujable getVista() {
		return new VistaItemVida();
	}
}	
