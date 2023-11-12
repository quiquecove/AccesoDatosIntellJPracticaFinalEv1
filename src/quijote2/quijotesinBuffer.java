package quijote2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class quijotesinBuffer {

	public static void main(String[] args) throws IOException {
		// pruebas sin buffer
		final long tInicio = System.currentTimeMillis();

		File fl = new File("QuijoteCompleto.txt");

		FileReader fr = new FileReader(fl);
		FileWriter fw = new FileWriter("Quijote3.txt");
		int aux = 0;

		do {

			aux = fr.read();
			fw.write(aux);

		} while (aux != -1);

		fr.close();
		fw.close();
		final long tFinal = System.currentTimeMillis();
		long tTotal = tFinal - tInicio;
		System.out.println(tTotal + " ms");
	}
	
}
