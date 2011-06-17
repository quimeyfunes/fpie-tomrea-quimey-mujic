package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import Escenario.Escenario;
import Objetos_moviles.Algo42;

public class Cargar {

	
	public void CargarPartida(){
		try {
			
			String archivo_algo =  "algo_java.dat";
			String archivo_escenario =  "escneario_java.dat";

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					archivo_algo));
			ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(
					archivo_escenario));
			Algo42 algo = (Algo42) ois.readObject();
			System.out.println(algo.getVida());
			Escenario escenario = (Escenario ) ois2.readObject();
			System.out.println(escenario.getPuntos());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
