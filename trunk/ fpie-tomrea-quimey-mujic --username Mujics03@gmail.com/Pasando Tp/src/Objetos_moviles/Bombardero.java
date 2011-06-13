package Objetos_moviles;
import Vistas.VistaBombardero;
import ar.uba.fi.algo3.titiritero.Dibujable;
import Armas.*;
import EstrategiasDeMov.LineaRectaDown;
import EstrategiasDeMov.MovDirigido;
import EstrategiasDeMov.ZigZag;

public class Bombardero extends Voladores
{
	public Bombardero(double x, double y)
	{
		this.constructor(x, y, this);
	}	
	
	public void Actuar(){
		if ( Timing >= 50 ) {
			Timing = 0;
			this.seleccionarSiguienteArma();
			this.disparar();
		} else { 
			this.moverseIAsegunVel();
			Timing = Timing + 1;
		}
	}
	
	public void Destructor(){
		this.Vivo = false;
		
		new ItemMisilDirigido(this.ubicacion.XY().x,this.ubicacion.XY().y,this.getBando());
	}
	
	public void EstadoCorrecto(){
		this.bando = ObjetosMoviles.BandoEnemigo();
		this.puntos = 30; 
		this.Velocidad = 1;
		this.estrategia_vuelo = new ZigZag();
		this.blindaje = new Blindaje((short)200);

		this.ConfigurarCuerpo(20,20);
		
		PistolaLaser pistola_laser = new PistolaLaser( bando , new LineaRectaDown() );
		LanzadorMisiles lanzador_misiles = new LanzadorMisiles(bando, new MovDirigido());
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes(bando, new LineaRectaDown());
		this.weapons.add( pistola_laser );
		this.weapons.add( lanzador_misiles );
		this.weapons.add( lanzador_cohetes );
	}

	@Override
	public Dibujable getVista() {
		return new VistaBombardero();
	}
	
}
