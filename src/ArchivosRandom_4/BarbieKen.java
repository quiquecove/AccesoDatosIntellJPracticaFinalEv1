package ArchivosRandom_4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BarbieKen {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("FAleatorio3.dat", "rw");

		raf.writeUTF("¡Hola Barbie!");

		raf.seek(0);
		System.out.println(raf.readUTF());

		raf.seek((raf.length()/2)-3);
		raf.write("Ken!    ".getBytes("UTF-8"));

		raf.seek(0);
		System.out.println(raf.readUTF());
	}
}
