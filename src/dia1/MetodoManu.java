package dia1;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class MetodoManu {
    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "PruebaDB402.yap");
        AlumnoCFGS a = new AlumnoCFGS();
        ObjectSet<AlumnoCFGS> result = db.queryByExample(a);
        
        while (result.hasNext()) {
            db.delete(result.next());
        }

        String[] nombre = {"Ana", "Bartolomeo", "Cristina", "Diego", "Elena"};
        byte[] edad = {20, 21, 22, 23, 20};
        byte[] noGrupo = {5, 10, 1, 8, 9};
        float[] alturaAproxEnMetros = {2.0F, 1.7F, 1.8F, 2.1F, 1.6F};
        boolean[] juegaEnConsola = {false, false, true, false, true};
        long[] horasEnElLOL = {200, 13, 0, 25, 315};
        String[] juegofavorito = {"Arx Fatalis", "Baldurs Gate 3", "Castlevania 1", "Danganronpa 2", "Elden Ring"};

        for (byte i = 0; i < nombre.length; i++) {
            db.store(new AlumnoCFGS(nombre[i], edad[i], noGrupo[i], alturaAproxEnMetros[i], juegaEnConsola[i], horasEnElLOL[i], juegofavorito[i]));
        }

        a.setJuegaEnConsola(true);
        result = db.queryByExample(a);
        System.out.println("La query ha devuelto " + result.size() + " alumnos.");

        AlumnoCFGS b;
        while (result.hasNext()) {
            b = result.next();
            if (b.getEdad() < 21) {
                db.delete(b);
            }
        }

        result = db.queryByExample(a);
        System.out.println("Tras la eliminación, quedan " + result.size() + " alumnos.");
        db.close();
    }
}
