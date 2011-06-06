package Armas;

import java.util.LinkedList;
import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import Objetos_moviles.Municion;
import Armas.ArmasFisicas;

public class ControladorArmas
{
	LinkedList<ArmasFisicas> listaDeArmas;
	short weaponOfChoice;
	public ControladorArmas()
	{
		this.listaDeArmas = new LinkedList<ArmasFisicas>();
		this.weaponOfChoice = 1;
	}
	
	public void add(ArmasFisicas arma)
	{
		listaDeArmas.add(arma);
	}
	
	public void seleccionarSiguienteArma()
	{
		this.weaponOfChoice++;
		if(weaponOfChoice > listaDeArmas.size())
			this.weaponOfChoice = 1;
	}
	
	public Municion dispararElArmaSeleccionada(Vector2D pos)
	{
 		try
		{
			return ((this.listaDeArmas.get(this.weaponOfChoice)).dispararDesde(pos) );
		}
		catch(OutOfAmmoException e)
		{
			this.listaDeArmas.remove(weaponOfChoice);
			this.weaponOfChoice = 1;
		}
		return null;//No deberia llegar nunca aca...extraño.
	}

}
