package Armas;

import java.util.List;
import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import ObjetosMoviles.Municion;
import Armas.ArmasFisicas;

public class ControladorArmas
{
	List<ArmasFisicas> listaDeArmas;
	short weaponOfChoice;
	public ControladorArmas()
	{
		this.listaDeArmas = new List<ArmasFisicas>();
		weaponOfChoice = 1;
	}
	
	public void add(ArmasFisicas arma)
	{
		listaDeArmas.add(arma);
	}
	
	public void seleccionarSiguienteArma()
	{
		weaponOfChoice++;
		if(weaponOfChoice > listaDeArmas.size())
			weaponOfChoice = 1;
	}
	
	public void dispararElArmaSeleccionada(Vector2D pos)
	{
		ArmasFisicas arma = this.listaDeArmas.get(weaponOfChoice);
		try
		{
			ObjetosMoviles.Municion municion = arma.dispararDesde(pos);
		}
		catch(OutOfAmmoException e)
		{
			this.listaDeArmas.remove(weaponOfChoice);
			weaponOfChoice = 1;
		}
	}

}
