package Armas;

import java.util.List;

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
	
	public void seleccionarSiguienteArma()
	{
		weaponOfChoice++;
		if(weaponOfChoice > listaDeArmas.size())
			weaponOfChoice = 1;
	}

}
