package EstrategiasDeMov;

import Mapa.Vector2D;
import Objetos_moviles.ObjetosMoviles;

public class ZigZag extends EstrategiaDeVuelo
{
	private boolean subiendo = true;
	
	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) 
	{
		
		if(objeto.EstaCercaAlAlimiteSuperior())
		{
			subiendo = false;
		}
		else if (objeto.EstaCercaAlAlimiteInferior())
			subiendo = true;
		
		if (this.Parametro <= EstrategiaDeVuelo.getSlide())
		{
			objeto.direccion( new Vector2D(-1, (subiendo ? 1 : -1)));
			if (objeto.EstaCercaAlAlimiteIzquierdo())
			{
				this.Parametro=EstrategiaDeVuelo.getSlide()+1;
			}
		}
		else
		{
			objeto.direccion( new Vector2D(1,(subiendo ? 1 : -1)));
			if ( objeto.EstaCercaAlAlimiteDerecho() )
			{
				this.restartearParametro();
			}
		}
		
		Parametro=Parametro+1;
		if (Parametro> EstrategiaDeVuelo.getSlide()*2 )
		{
			this.restartearParametro();
		}
		
	}

}
