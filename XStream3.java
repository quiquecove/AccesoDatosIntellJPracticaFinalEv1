package XML2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.lang.model.type.NoType;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import org.kxml2.*;
import org.xmlpull.v1.XmlPullParserFactory;

public class XStream3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XStream xs = new XStream();
		xs.addPermission(NoTypePermission.NONE);
		xs.addPermission(NullPermission.NULL);
		xs.addPermission(PrimitiveTypePermission.PRIMITIVES);

		Class[] clases = { ListaAlumnos.class, AlumnoCFGS.class };
		xs.allowTypes(clases);

		xs.allowTypesByWildcard(new String[] { "XML2.*" });
		xs.alias("ListaAlumnos", ListaAlumnos.class);
		xs.alias("Alumno", AlumnoCFGS.class);

		xs.addImplicitCollection(ListaAlumnos.class, "lista");

		ListaAlumnos listaAlumdef = new ListaAlumnos();

		FileOutputStream filaFinal = new FileOutputStream("FilasClase.xml");

		for (int i = 1; i < 5; i++) {
			if (i == 4) {
				xs.alias("Alumnos", AlumnoCFGS.class);
			}
			FileInputStream fis = new FileInputStream("Fila" + i + ".xml");
			ListaAlumnos listaAlum = (ListaAlumnos) xs.fromXML(fis);
//			listaAlumdef.add(listaAlum);
			xs.toXML(listaAlum, filaFinal);
			fis.close();
		}

		filaFinal.close();

		// Read the file that we have created on the screen
		byte[] bytes = System.in.readAllBytes();

		// Create a FileOutputStream object for the ClaseCompleta.dat file
		FileOutputStream fos = new FileOutputStream("ClaseCompleta.dat");

		// Write the bytes to the ClaseCompleta.dat file
		fos.write(bytes);

		// Close the FileOutputStream object
		fos.close();
		// Leer el archivo "FilasClase.xml" y escribir su contenido en
		// "ClaseCompleta.dat"
		FileInputStream filaFinalInputStream = new FileInputStream("FilasClase.xml");
		FileOutputStream claseCompletaOutputStream = new FileOutputStream("ClaseCompleta.dat");

		byte[] buffer = new byte[1024];
		int bytesRead;
		while ((bytesRead = filaFinalInputStream.read(buffer)) != -1) {
			claseCompletaOutputStream.write(buffer, 0, bytesRead);
		}

		// Cerrar los flujos de entrada y salida
		filaFinalInputStream.close();
		claseCompletaOutputStream.close();

		// Imprimir el contenido de "ClaseCompleta.dat" por la consola
		FileInputStream claseCompletaInputStream = new FileInputStream("ClaseCompleta.dat");
		BufferedReader br = new BufferedReader(new InputStreamReader(claseCompletaInputStream));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		claseCompletaInputStream.close();

	}

}
