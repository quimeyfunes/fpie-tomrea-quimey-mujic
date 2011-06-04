package Objetos_moviles;

public class Items extends ObjetosMoviles{
	
	public void Verificar_colicion(){
		//borre lo que estaba aca
	}

	
	public boolean Maneja_items(){
		return false;
	}
	
	public boolean Puede_ser_atacado(){
		return false;
	}
	
	public void Direccion(){
	}
	
	public void Mover_segun_velocidad(){
	}


	@Override
	public boolean PuedeManejarItems() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean PuedeSerAtacado() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected void Actuar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void ActuarAnteColision(ObjetosMoviles objeto){
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void EstadoCorrecto() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void VerificarColision() {
		// TODO Auto-generated method stub
		
	}
}
