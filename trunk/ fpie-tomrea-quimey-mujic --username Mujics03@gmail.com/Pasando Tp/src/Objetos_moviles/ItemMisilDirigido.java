package Objetos_moviles;

import Vistas.VistaItemMisilDirigido;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import Armas.*;
import EstrategiasDeMov.MovDirigido;

public class ItemMisilDirigido extends Items{
	
	public ItemMisilDirigido(double x, double y,byte bando){
		this.constructor(x, y, bando, this);
	}

	public void ActuarAnteColision(ObjetosMoviles objeto){
		
		LanzadorMisiles misiles_dirigidos = new LanzadorMisiles( objeto.getBando() , new MovDirigido());
		((Voladores)objeto).agregarArma( misiles_dirigidos );
		this.Destructor();
	}
	
	public void EstadoCorrecto() {
		this.ConfigurarCuerpo(15,15);
	}

	@Override
	public DibujableExtra getVista() {
		return new VistaItemMisilDirigido();
	}
}
