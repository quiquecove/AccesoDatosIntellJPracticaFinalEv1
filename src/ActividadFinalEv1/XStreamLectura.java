package ActividadFinalEv1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.List;

public class XStreamLectura {
    public static void main(String[] args) {
        try {
            // Configuración de XStream
            XStream xstream = new XStream(new DomDriver());

            // Permisos y configuración de tipos permitidos
            xstream.addPermission(NoTypePermission.NONE);
            xstream.addPermission(NullPermission.NULL);
            xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);

            // Remueve la restricción para java.util.List
            xstream.allowTypes(new Class[]{ListaPaises.class, PaisSerializable.class, java.util.ArrayList.class, java.util.HashMap.class, java.util.LinkedHashMap.class});

            // Alias para mapear los nombres de las clases y elementos XML
            xstream.alias("lista_paises", ListaPaises.class);
            xstream.addImplicitCollection(ListaPaises.class, "paises", PaisSerializable.class);
            xstream.alias("pais", PaisSerializable.class);

            // Crear una lista directamente a partir del archivo XML
            FileReader fileReader = new FileReader("Paises.xml");
            ListaPaises listaPaises = (ListaPaises) xstream.fromXML(fileReader);
            List<PaisSerializable> paises = listaPaises.getPaises();
            //utilizo un fos y un oos para escribir objetos de tipo ListaPaises en el fichero Paises.dat
            FileOutputStream fos=new FileOutputStream("Paises.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            // Imprimir la información de los países
            for (PaisSerializable pais : paises) {
                System.out.println("Region del país: " + pais.getRegion());
                System.out.println("Nombre del país: " + pais.getNombre_pais());
                System.out.println("Presidente: " + pais.getPresidente());
                System.out.println("PIB: " + pais.getPib());
                System.out.println("Gini: " + pais.getGini());
                System.out.println("-----------------------");
                //introduzco el pais de la iteracion.
                objectOutputStream.writeObject(pais);
            }
            objectOutputStream.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
