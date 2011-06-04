package Armas;
import java.awt.Point;

public class LanzadorLaser extends ArmasFisicas{

	public Municion Disparar_desde ( Point ubicacion ) {
		Laser laser =  new Laser( Point ubicacion, EstrategiaVuelo direccionVuelo, String bando );
		return Laser;
	}
		
}
