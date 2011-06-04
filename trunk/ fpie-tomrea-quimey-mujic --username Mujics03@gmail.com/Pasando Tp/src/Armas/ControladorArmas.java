package Armas;

import java.util.List;

import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import Objetos_Moviles.Municion;

public class ControladorArmas
{
	List<ArmasFisicas> listaDeArmas;
	short weaponOfChoice;
	public ControladorArmas()
	{
		listaDeArmas = new List<ArmasFisicas>();
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
		ArmasFisicas arma = listaDeArmas.get(weaponOfChoice);
		try
		{
			Municion municion = arma.dispararDesde(pos);
		}
		catch(OutOfAmmoException e)
		{
			listaDeArmas.remove(weaponOfChoice);
			weaponOfChoice = 1;
		}
	}

}
