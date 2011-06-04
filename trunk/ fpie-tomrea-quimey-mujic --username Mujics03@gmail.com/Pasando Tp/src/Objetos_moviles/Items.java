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


	@Override
	public boolean PuedeManejarItems() {
		return false;
	}


	@Override
	public boolean PuedeSerAtacado() {
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
