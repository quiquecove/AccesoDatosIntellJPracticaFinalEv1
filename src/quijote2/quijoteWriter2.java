package quijote2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

public class quijoteWriter2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fin = "\n Etc, etc... \n Fin del fichero";
		FileReader fr;
		FileWriter quijoteWriter = new FileWriter("Quijote2.txt");
		fr = new FileReader("Quijote.txt");
		char[] linea = new char[88];
		fr.read(linea);
		quijoteWriter.write(linea);
		quijoteWriter.write(fin);
		quijoteWriter.close();
		System.out.println(String.valueOf(linea));
	}

}
