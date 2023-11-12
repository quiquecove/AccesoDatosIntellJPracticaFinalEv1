package ArchivosRandom_4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class fivonaciLong {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		RandomAccessFile fich = new RandomAccessFile("FAleatorio2.dat", "rw");
		long aux = 5;
		long fibo = 0;
//		System.out.println(aux);
		long num1 = 0;
		long num2 = 1;
		long suma = 0;
		fich.seek(0);
		for (int i = 0; i < aux; i++) {
			num1 = num2;
			num2 = fibo;
			fibo = num1 + num2;

			fich.writeLong(fibo);
			System.out.println(fibo);
		}

		fich.seek((aux - 3) * 8);
		fich.writeLong(0);

		fich.seek(0);
		for (int i = 0; i < aux; i++) {
			System.out.println(fich.readLong());

		}

		System.out.println("Dime que elemento quieres borrar del 0 al " + aux);
		long usr = in.nextLong();

		fich.seek((usr - 1) * 8);
		System.out.println("Dime que numero deseas guardar");
		long usr2 = in.nextLong();
		fich.writeLong(usr2);
		System.out.println("listo");
		fich.seek(0);
		for (int i = 0; i < aux; i++) {
			System.out.println(fich.readLong());

		}
		fich.close();
//			System.out.println(fibo);
//			System.out.println(fis2.read());
		// escribir

//			RandomAccessFile archivo = new RandomAccessFile("archivo.txt", "rw");
//			archivo.seek(5);
//			archivo.write("Datos".getBytes());
//			archivo.close();

//			leer

//			RandomAccessFile archivo = new RandomAccessFile("archivo.txt", "r");
//			archivo.seek(1);
//			byte[] bytes = new byte[5];
//			archivo.read(bytes);
//			archivo.close();
//			System.out.println(new String(bytes));

	}
}
