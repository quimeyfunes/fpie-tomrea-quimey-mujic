package Objetos_moviles;

import Mapa.Vector2D;

public class MovDirigido extends EstrategiaDeVuelo{

	@Override
	public void CalcularMovimiento(ObjetosMoviles ObjQueRastrea) {
		
		Vector2D DirTemp = (ObjQueRastrea.getPosicionDelObjetivo());
		Vector2D MyPos = ObjQueRastrea.getPosicion();
		
		MyPos.scaleThis((-1));
		
		DirTemp.translate(MyPos );
		
		ObjQueRastrea.direccion(DirTemp);	
		
		//"vector final menos inicial, da direccion hacia objetivo"
		
		
	}

}
