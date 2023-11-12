package quijote2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class quijote5_6veces {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fin = "\n";
		FileReader fr;
		FileWriter quijoteWriter = new FileWriter("Quijote2.txt");
		File file = new File("Quijote.txt");

		fr = new FileReader("Quijote.txt");
		char[] linea = new char[(int) file.length()];
		for (int i = 0; i < 6; i++) {
			fr.read(linea);
			quijoteWriter.write(linea);
			quijoteWriter.write("\n");
		}
		quijoteWriter.close();

	}

}
