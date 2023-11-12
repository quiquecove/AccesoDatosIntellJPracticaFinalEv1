package quijote2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class quijoteBufferReaderWriter1 {

	public static void main(String[] args) throws IOException {

		final long tInicio = System.currentTimeMillis();
		
		File file = new File("QuijoteCompleto.txt");

		FileReader reader = new FileReader(file);
		FileWriter writter = new FileWriter("Quijote3");

		BufferedReader lector = new BufferedReader(reader);
		BufferedWriter escritor = new BufferedWriter(writter);

		String linea;
		while ((linea = lector.readLine()) != null) {
			escritor.write(linea + "\n");
		}
		while ((reader.read()) != -1) {
			escritor.write(lector.readLine() + "\n");
		}
		escritor.close();
		lector.close();

		// pruebas sin buffer

//		File fl = new File("QuijoteCompleto.txt");
//
//		FileReader fr = new FileReader(fl);
//		FileWriter fw = new FileWriter("Quijote3.txt");
//		int aux = 0;
//
//		do {
//
//			aux = fr.read();
//			fw.write(aux);
//
//		} while (aux != -1);
//
//		fr.close();
//		fw.close();

		final long tFinal = System.currentTimeMillis();
		long tTotal = tFinal - tInicio;
		System.out.println(tTotal + " ms");

	}

}
