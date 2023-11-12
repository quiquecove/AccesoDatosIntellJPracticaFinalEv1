package dia1;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import DAO.AlumnoCFGS;

public class mostrarParejaylado {
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "alumnos.yap");
		ObjectSet<AlumnoCFGS> os = db.queryByExample(AlumnoCFGS.class);
		AlumnoCFGS alumno;

		while (os.hasNext()) {
			alumno = os.next();
			if (alumno.getNoGrupo() == 1 || alumno.getNoGrupo() == 2) {
				System.out.println(alumno);
			}
		}
		db.commit(); // Guarda los cambios en la base de datos
		db.close();

	}
}
