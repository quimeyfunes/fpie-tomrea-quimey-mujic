package Armas;

import java.util.Iterator;
import java.util.LinkedList;
import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import Objetos_moviles.Municion;
import Armas.ArmasFisicas;


public class ControladorArmas
{
	LinkedList<ArmasFisicas> listaDeArmas;
	ArmasFisicas weaponOfChoice;
	public ControladorArmas()
	{
		this.listaDeArmas = new LinkedList<ArmasFisicas>();
	}
	
	public void add(ArmasFisicas arma)
	{
		listaDeArmas.add(arma);
		
		if (this.listaDeArmas.size()==1){
		this.weaponOfChoice= this.listaDeArmas.getLast();
		}
	}
	
	public void seleccionarSiguienteArma()
	{
	Iterator<ArmasFisicas> it	=this.listaDeArmas.iterator();
	if (it.hasNext() ){
		this.weaponOfChoice = it.next();
	}
	else{
		this.weaponOfChoice=this.listaDeArmas.getFirst();
	}
	}
	
	public Municion dispararElArmaSeleccionada(Vector2D pos)
	{		
 		try
		{
 			return this.weaponOfChoice.dispararDesde(pos);
		}
		catch(OutOfAmmoException e)
		{
			this.listaDeArmas.remove(weaponOfChoice);
			this.weaponOfChoice = this.listaDeArmas.getFirst();
		}
		return null;
	}

}
