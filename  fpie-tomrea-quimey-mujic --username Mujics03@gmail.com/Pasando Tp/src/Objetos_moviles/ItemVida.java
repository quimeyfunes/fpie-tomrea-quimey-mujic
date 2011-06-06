package Objetos_moviles;

public class ItemVida extends Items
{
	short hitPointsAsumar;
	
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
		this.ConfigurarCuerpo(1,1);
	}
}	
