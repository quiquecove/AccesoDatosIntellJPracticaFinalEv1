package XML2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import AlumnosCFGS.AlumnoCFGS;

public class xStream {

	public static void main(String[] args) throws IOException {
		ListaAlumnos la = new ListaAlumnos();


		XStream xstr = new XStream();
		
		xstr.alias("ListaAlumnos", ListaAlumnos.class);
		xstr.alias("Alumno", AlumnoCFGS.class);
		

		la.add(new XML2.AlumnoCFGS("Enrique", (byte)19 ,(byte) 1, (float) 1.80 ,false , 0L, "animalX"));
		
		la.add(new XML2.AlumnoCFGS("Fernando", (byte)27 ,(byte) 1, (float) 1.63 ,false , 9000L, "God Of War"));

		la.add(new XML2.AlumnoCFGS("Dudu", (byte)23 ,(byte) 2, (float) 1.750 ,false , 700L, "Skyrim"));
		
		la.add(new XML2.AlumnoCFGS("Dani", (byte)20 ,(byte) 2, (float) 1.97 ,true , 2500L, "FIFA"));
		
		la.add(new XML2.AlumnoCFGS("Dichao", (byte)23 ,(byte) 3, (float) 1.82 ,true , 48L, "Overcooked"));
		
		la.add(new XML2.AlumnoCFGS("Angel", (byte)23 ,(byte) 3, (float) 1.93 ,true , 2355L, "Final Fantasy 4"));
		
		
		xstr.addImplicitCollection(ListaAlumnos.class,"lista");
		File fl=new File("objetos.xml");
		fl.createNewFile();
		xstr.toXML(la,new FileOutputStream("fila1.xml"));

	}
}
