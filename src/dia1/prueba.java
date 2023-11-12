package dia1;

import java.awt.List;
import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import DAO.AlumnoCFGS;

public class prueba {
	public static void main(String[] args) {

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "alumnos.yap");
//		db.store(new AlumnoCFGS("Enrique", (byte) 19, (byte) 1, (float) 1.80, true, 0L, "animalX"));
//
//		db.store(new AlumnoCFGS("Fernando", (byte) 27, (byte) 1, (float) 1.63, false, 9000L, "God Of War"));
//
//		db.store(new AlumnoCFGS("Dudu", (byte) 23, (byte) 2, (float) 1.750, false, 700L, "Skyrim"));
//
//		db.store(new AlumnoCFGS("Dani", (byte) 20, (byte) 2, (float) 1.97, true, 2500L, "FIFA"));
//
//		db.store(new AlumnoCFGS("Dichao", (byte) 23, (byte) 3, (float) 1.82, true, 48L, "Overcooked"));
//
//		db.store(new AlumnoCFGS("Angel", (byte) 23, (byte) 3, (float) 1.93, true, 2355L, "Final Fantasy 4"));

// borrar

//		ObjectSet<AlumnoCFGS> result = db.query(new Predicate<AlumnoCFGS>() {
//			public boolean match(AlumnoCFGS alumno) {
//				return alumno.getNombre().equals("Angel");
//			}
//		});
//		if (result.size() > 0) {
//			db.delete(result.get(0)); // Elimina el primer objeto encontrado
//			db.commit(); // Guarda los cambios en la base de datos
//		}

//		ObjectSet<AlumnoCFGS> os2 = db.queryByExample(AlumnoCFGS.class);
//		while (os2.hasNext()) {
//			AlumnoCFGS alumno = os2.next();
//			System.out.println(alumno);
//		}
//		System.out.println("---------------------------------------------------");
//		// borrar 2 videojuegos
//		ObjectSet<AlumnoCFGS> result = db.query(new Predicate<AlumnoCFGS>() {
//			public boolean match(AlumnoCFGS alumno) {
//				return alumno.isJuegaEnConsola() == true && alumno.getEdad() < 21;
//			}
//		});
//		if (result.size() > 0) {
//			for (int i = 0; i < result.size(); i++) {
//				db.delete(result.get(i));
//			}
//			db.commit(); // Guarda los cambios en la base de datos
//		}

//select
//		ObjectSet<AlumnoCFGS> os2 = db.query(new Predicate<AlumnoCFGS>() {
//			public boolean match(AlumnoCFGS alumno) {
//				return alumno.getNoGrupo() == 1;
//			}
//		});
//
//		while (os2.hasNext()) {
//			AlumnoCFGS alumno = os2.next();
//			System.out.println(alumno);
//		}

//bucle de borrado
//		while(os.hasNext()) {
//			db.delete(os2.next());
//		}
//		db.commit();
//		db.close();
////	}
////recorrer base de datos
		ObjectSet<AlumnoCFGS> os = db.queryByExample(AlumnoCFGS.class);
		while (os.hasNext()) {
			System.out.println(os.next());
		}
		db.close();
//}
//	
	}
}
