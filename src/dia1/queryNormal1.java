package dia1;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import DAO.AlumnoCFGS;

import com.db4o.ObjectSet;

public class queryNormal1 {

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "alumnos.yap");
		Query q = db.query();
		q.constrain(AlumnoCFGS.class); // Especifica la clase que quieres consultar
//        q.descend("juegaEnConsola").constrain(true).and(q.descend("edad").constrain(21).smaller());
		q.descend("nombre").constrain("Enrique").or(q.descend("juegaEnConsola").constrain(true));

		ObjectSet<AlumnoCFGS> result = q.execute();

		while (result.hasNext()) {
			AlumnoCFGS alumno = result.next();
			// Realiza alguna acción con el objeto AlumnoCFGS (por ejemplo, imprimirlo)
			System.out.println(alumno);

			// Elimina el objeto de la base de datos
//			db.delete(alumno);
		}

//		db.commit(); // Guarda los cambios en la base de datos
		db.close();
	}
}
