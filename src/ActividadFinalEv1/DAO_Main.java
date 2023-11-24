package ActividadFinalEv1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.List;

public class DAO_Main extends DAO1 {
    public static void main(String[] args) throws SQLException {
        DAO1.init();
        DAO_Operaciones dp = new DAO_Operaciones();
        dp.createTable();
        List<PaisSerializable> paises = null;
        try {
            // Configuración de XStream
            XStream xstream = new XStream(new DomDriver());

            
            // Permisos y configuración de tipos permitidos
            xstream.addPermission(NoTypePermission.NONE);
            xstream.addPermission(NullPermission.NULL);
            xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);

            // Remueve la restricción para java.util.List
            xstream.allowTypes(new Class[]{ListaPaises.class, PaisSerializable.class, java.util.ArrayList.class, java.util.HashMap.class, java.util.LinkedHashMap.class});
//metodo manu
//            xstream.allowTypesByWildcard(new String[] {
//                    "ListaPaises.class",
//                    "PaisSerializable.class"
//            });

            // Alias para mapear los nombres de las clases y elementos XML
            xstream.alias("lista_paises", ListaPaises.class);
            xstream.addImplicitCollection(ListaPaises.class, "paises", PaisSerializable.class);
            xstream.alias("pais", PaisSerializable.class);

            // Crear una lista directamente a partir del archivo XML
            FileReader fileReader = new FileReader("Paises.xml");
            ListaPaises listaPaises = (ListaPaises) xstream.fromXML(fileReader);
            paises = listaPaises.getPaises();
            //utilizo un fos y un oos para escribir objetos de tipo ListaPaises en el fichero Paises.dat
//            FileOutputStream fos = new FileOutputStream("Paises.dat");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            // Imprimir la información de los países
            for (PaisSerializable pais : paises) {

                //System.out.println("Region del país: " + pais.getRegion());
                System.out.println("Nombre del país: " + pais.getNombre_pais());
                System.out.println("Presidente: " + pais.getPresidente());
                System.out.println("PIB: " + pais.getPib());
                System.out.println("Gini: " + pais.getGini());
                System.out.println("-----------------------");
                //introduzco el pais de la iteracion.
//                objectOutputStream.writeObject(pais);
                //
                dp.crearRegistro(pais);

            }
//            objectOutputStream.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //consultar la tabla PAISES
        dp.consultarTabla();
        //modifico el PIB
        dp.modifPIB();
        System.out.println("---------------------");
        //volvemos a consultar la tabla para ver los cambios reflejados
        dp.consultarTabla();
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Antes:");
        dp.consultarPais("El Salvador");
        dp.consultarPais("Honduras");
        dp.consultarPais("México");
        /////////////////////////////////////
        //modificamos el gini de los 3 paises
        dp.modiGINIshm("El Salvador");
        dp.modiGINIshm("Honduras");
        dp.modiGINIshm("México");
        ////////////////////////////////////////
        System.out.println("Despues:");
        dp.consultarPais("El Salvador");
        dp.consultarPais("Honduras");
        dp.consultarPais("México");
    }

}
