package numerosBinarios;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class inputoutput2 {
	public static void main(String[] args) throws IOException {

		File file = new File("fBinario.dat");
		File file2 = new File("fBinario2.dat");

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file);

		FileInputStream fis2 = new FileInputStream(file2);
		FileOutputStream fos2 = new FileOutputStream(file2);

		DataOutputStream dos = new DataOutputStream(fos2);
		fos.write(10);
		int fibo = 0;
		int aux = fis.read();
		System.out.println(aux);
		int num1 = 0;
		int num2 = 1;
		int suma = 0;
		for (int i = 0; i <= aux; i++) {
			num1 = num2;
			num2 = fibo;
			fibo = num1 + num2;
			fos2.write(fibo);
			System.out.print(fis2.read()+", ");
		}

//		System.out.println(fibo);
//		System.out.println(fis2.read());

		fis.close();
		fos.close();
		fis2.close();
		fos2.close();
		dos.close();

	}
}
