package quijote2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class quijoteWriter3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String fin = "\n Etc, etc... \n Fin del fichero";
		FileReader fr;
		FileWriter quijoteWriter = new FileWriter("Quijote2.txt",true);
		fr = new FileReader("Quijote.txt");
		char[] linea = new char[88];
		fr.read(linea);
		fr.read(linea);
		quijoteWriter.write(linea);
		quijoteWriter.write(fin);
		quijoteWriter.close();
		System.out.println(String.valueOf(linea));

//		String fin = "\n Etc, etc... \n Fin del fichero";
//		FileReader fr;
//		FileWriter quijoteWriter = new FileWriter("Quijote2.txt");
//		fr = new FileReader("Quijote.txt");
//		
//		
//		char[] linea=new char[178];
//		fr.read(linea);
//		
//		char[] linea2 = new char[88];
//		System.arraycopy(linea, 89, linea2, 0, 88);
//		quijoteWriter.write(linea2);
//		quijoteWriter.write(fin);
//		quijoteWriter.close();
//		System.out.println(String.valueOf(linea2));
	}

}
