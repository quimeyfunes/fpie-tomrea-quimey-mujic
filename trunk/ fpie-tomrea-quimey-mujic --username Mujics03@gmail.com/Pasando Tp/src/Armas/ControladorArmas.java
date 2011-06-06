package Armas;

import java.util.Iterator;
import java.util.LinkedList;
import Excepciones.OutOfAmmoException;
import Mapa.Vector2D;
import Objetos_moviles.Municion;
import Armas.ArmasFisicas;


public class ControladorArmas
{
	private LinkedList<ArmasFisicas> listaDeArmas;
	private ArmasFisicas weaponOfChoice;
	private Iterator<ArmasFisicas> it;
	
	private void ReiniciarIt(){
		this.it= this.listaDeArmas.iterator();
		this.it.next();
		
	}
	

	public ControladorArmas()
	{
		this.listaDeArmas = new LinkedList<ArmasFisicas>();
		this.weaponOfChoice=null;
		this.it=null;
	}
	
	public void add(ArmasFisicas arma)
	{
		listaDeArmas.add(arma);
		this.ReiniciarIt();
		
		if (this.listaDeArmas.size()==1){
		this.weaponOfChoice= this.listaDeArmas.getFirst();
		}
	}
	
	public void seleccionarSiguienteArma()
	{
		boolean bandera = it.hasNext();
		if ( bandera){
			this.weaponOfChoice= this.it.next();
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
			this.ReiniciarIt();
		}
		return null;
	}

}
