package Objetos_moviles;
import Vistas.VistaCaza;
import ar.uba.fi.algo3.titiritero.Dibujable;
import Armas.*;
import EstrategiasDeMov.IdaYvuelta;
import EstrategiasDeMov.LineaRectaDown;

public class Caza extends Voladores
{
	public Caza(double x, double y)
	{
		this.constructor(x, y, this);
	}	
	
	public void Actuar(){
		if ( Timing >= 30 ) {
			Timing = 0;
			this.seleccionarSiguienteArma();
			this.disparar();
		} else { 
			this.moverseIAsegunVel();
			Timing = Timing + 1;
		}
	}
	
	protected void Destructor(){
		this.Vivo = false;
		new ItemVida(this.getPosicion().x,this.getPosicion().y, this.getBando());
	}
	
	public void EstadoCorrecto(){
		this.bando = ObjetosMoviles.BandoEnemigo();
		this.puntos = 30; 
		Velocidad = 3;
		estrategia_vuelo = new IdaYvuelta();
		this.blindaje = new Blindaje((short)100);
		
		this.ConfigurarCuerpo(6,6);
		
		PistolaLaser pistola_laser = new PistolaLaser(bando , new LineaRectaDown());
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes(bando , new LineaRectaDown());
		weapons.add( pistola_laser );
		weapons.add( lanzador_cohetes );
	}

	@Override
	public Dibujable getVista() {
		return new VistaCaza();
	}
}
