package quijote2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class quijoteWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileWriter quijoteWriter = new FileWriter("Quijote2.txt");
			// Escribe en el archivo
			FileReader fr = new FileReader("Quijote.txt");
			int i = 0;
			String fin="\n Etc, etc... \n Fin del fichero";
			while(i!=-1){
				System.out.print((char)i);
				i=fr.read();
				quijoteWriter.write(i);
			}
			// Cierra el archivo
			quijoteWriter.write(fin);
			quijoteWriter.close();
			System.out.println("Se ha escrito en el archivo.");

		}catch(

	IOException e)
	{
		System.out.println("Ha ocurrido un error.");
		e.printStackTrace();
	}

}
	
	//Metodo fachero
//	FileWriter escritor = new FileWriter("Quijote.txt");
//	FileReader lector = new FileReader("Quijote2.txt");
//
//	lector.transferTo(escritor);
//	
//	escritor.close();

}
