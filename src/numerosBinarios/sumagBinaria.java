package numerosBinarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class sumagBinaria {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File suma = new File("sumaGaussBinaria.dat");
		FileWriter wr = new FileWriter(suma);
		suma.createNewFile();
		FileOutputStream fos = new FileOutputStream(suma);
		int res = 0;

		for (int i = 1, j = 100; i <= 50 || j > 50; i++, j--) {
			res += i + j;
		}
		System.out.println(res);
		wr.write(res);
		wr.close();
	}

}
