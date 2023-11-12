package ArchivosRandom_4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class fibonaci1 {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		RandomAccessFile fich = new RandomAccessFile("FAleatorio2.dat", "rw");
		int aux = 5;
		int fibo = 0;
//		System.out.println(aux);
		int num1 = 0;
		int num2 = 1;
		int suma = 0;
		for (int i = 0; i <= aux; i++) {
			num1 = num2;
			num2 = fibo;
			fibo = num1 + num2;
			fich.seek(i * 4);
			fich.write(fibo);
			System.out.println(fibo);
		}

		System.out.println("Dime que elemento quieres borrar del 0 al " + aux);
		int usr = in.nextInt();

		fich.seek((usr - 1) * 4);
		System.out.println("Dime que numero deseas guardar");
		int usr2 = in.nextInt();
		fich.write(usr2);
		System.out.println("listo");

		for (int i = 0; i < aux; i++) {
			fich.seek(i * 4);
			System.out.println(fich.read());

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
