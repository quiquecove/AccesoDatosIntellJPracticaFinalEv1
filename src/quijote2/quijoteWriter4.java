package quijote2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class quijoteWriter4 {

	public static void main(String[] args) throws IOException {

		String fin = "\n Etc, etc... \n Fin del fichero";
		FileReader fr;
		FileWriter quijoteWriter = new FileWriter("Quijote2.txt");
		fr = new FileReader("Quijote.txt");
		File file = new File("Quijote.txt");

		char[] linea = new char[(int) file.length()];
		fr.read(linea);

		char[] linea2 = new char[75];
		System.arraycopy(linea, 0, linea2, 10, 65);
		quijoteWriter.write(linea2);
//		quijoteWriter.write(linea2, 10, 55);

		quijoteWriter.write(fin);
		quijoteWriter.close();
		System.out.println(String.valueOf(linea2));

//		char buf[] = new char[(int) file.length()];
//		int despLec=22,despEsc=10,tamLec=65;
//		int tamEsc=tamLec-despEsc;
//		fr.read(buf,despEsc,tamEsc);
//		quijoteWriter.write(buf,despEsc,tamEsc);
//		quijoteWriter.close();
//		System.out.println("listo");
		
	
	
	}
}
