package quijote2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class quijotebuffer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr;
		fr = new FileReader("Quijote.txt");
		char[] linea = new char[60];
		fr.read(linea);
		System.out.println(String.valueOf(linea));
	}

}
