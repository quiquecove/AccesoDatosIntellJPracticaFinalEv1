package dia1;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import DAO.AlumnoCFGS;

public class aumentarEdad {

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "alumnos.yap");
        ObjectSet<AlumnoCFGS> os = db.queryByExample(AlumnoCFGS.class);
        AlumnoCFGS alumno;
        byte edad;
        float altura;

        while (os.hasNext()) {
            alumno = os.next();
            if (alumno.getNoGrupo() == 2) {
                db.delete(alumno); 
            } else {
                edad = alumno.getEdad();
                alumno.setEdad((byte) (edad + 1));
                altura = alumno.getAlturaAproxEnMetros();
                alumno.setAlturaAproxEnMetros(altura + 0.01f);
                db.store(alumno);
            }
        }
        ObjectSet<AlumnoCFGS> os2 = db.queryByExample(AlumnoCFGS.class);

		while (os2.hasNext()) {
			
			System.out.println(os2.next());
		}

        db.commit(); // Guarda los cambios en la base de datos
        db.close();
    }
}
