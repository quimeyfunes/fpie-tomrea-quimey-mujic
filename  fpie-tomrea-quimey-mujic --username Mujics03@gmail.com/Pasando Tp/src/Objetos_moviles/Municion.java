package Objetos_moviles;
import Armas.Danio;
import Escenario.Escenario;
import Mapa.Ubicacion;
import Mapa.Vector2D;

public abstract class Municion extends ObjetosMoviles{

	protected Danio danio;
	
	protected void constructor(Vector2D posicion, EstrategiaDeVuelo estrategia, byte bando, Municion m)
	{
		m.setBando(bando);
		m.setPosicion(Ubicacion.crearUbicacionEnXY(posicion.x, posicion.y));
		m.CambiarEstrategiaDeVuelo(estrategia);
		m.EstadoCorrecto();
		Escenario.getInstance().agregarObjeto(m);//entra al mundo de los vivos
	}	
	
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
