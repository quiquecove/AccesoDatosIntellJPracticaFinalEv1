package AlumnosCFGS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class HolaMundoRandom {
	public static void main(String[] args) throws IOException {
		RandomAccessFile fichero;
		fichero = new RandomAccessFile("FAleatorio.dat", "rw");
		fichero.writeUTF("¡Hola mundo!");
		fichero.seek(0);
		System.out.println(fichero.readUTF().toString());

	}
}
