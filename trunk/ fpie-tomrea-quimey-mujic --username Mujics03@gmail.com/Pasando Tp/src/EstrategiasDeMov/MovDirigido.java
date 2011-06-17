package EstrategiasDeMov;

import Mapa.Vector2D;
import Objetos_moviles.ObjetosMoviles;
import Objetos_moviles.Rastreador;

public class MovDirigido extends EstrategiaDeVuelo{
	

	private Vector2D CMovimiento( Rastreador ObjQueRastrea ) {						
									
		Vector2D DirTemp = ObjQueRastrea.getPosicionDelObjetivo();
		Vector2D MyPos = ObjQueRastrea.getPosicion();
		
		MyPos.scaleThis((-1));
		
		DirTemp.translate(MyPos );
		
		return DirTemp;
		
		//"vector final menos inicial, da direccion hacia objetivo"
	}
	
	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		objeto.direccion(this.CMovimiento((Rastreador)objeto));		
	}
}
