package Objetos_moviles;
import Armas.Danio;
import Escenario.Escenario;

public abstract class Municion extends ObjetosMoviles{

	protected Danio danio;
	
	
	public boolean PuedeManejarItems() {
		return false;
	}

	public boolean PuedeSerAtacado() {
		return true;
	}

	protected void Actuar() {
		this.moverseIAsegunVel();
		
	}

	protected void ActuarAnteColision(ObjetosMoviles movil) 
	{
		movil.analizarDanio(this.daniar());
		this.Destructor();
	}
	

	protected Danio daniar()
	{
		return this.danio;
	}

	protected void VerificarColision() 
	{
		for (ObjetosMoviles movil : Escenario.getInstance().objetosVivos())
			if(this.PuedeSerAtacado() && this.condicionComun(movil))
				this.ActuarAnteColision(movil);			
		
	}
	
	public void cambiarDanio(short danio)
	{
		this.danio.setearPoder(danio);		
	} 


	
}
