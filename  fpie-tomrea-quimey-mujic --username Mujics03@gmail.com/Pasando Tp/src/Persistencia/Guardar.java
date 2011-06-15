package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import Escenario.*;

import Objetos_moviles.Algo42;

public class Guardar {
	
	String archivo_algo =  "algo_java.dat";
	String archivo_escenario =  "escneario_java.dat";
	
	public void GuardarPartida (Algo42 algo, Escenario escenario ) {
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(archivo_algo));
			oos.writeObject(algo);
			ObjectOutputStream oos2 = new ObjectOutputStream(
					new FileOutputStream(archivo_escenario));
			oos.writeObject(escenario);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
