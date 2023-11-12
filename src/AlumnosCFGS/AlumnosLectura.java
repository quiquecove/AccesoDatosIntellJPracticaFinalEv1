package AlumnosCFGS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AlumnosLectura {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clase.dat"));
		ObjectInputStream ios1 = new ObjectInputStream(new FileInputStream("fila1.dat"));
		ObjectInputStream ios2 = new ObjectInputStream(new FileInputStream("Fila2.dat"));
		ObjectInputStream ios3 = new ObjectInputStream(new FileInputStream("Fila3.dat"));
		ObjectInputStream ios4 = new ObjectInputStream(new FileInputStream("Fila4.dat"));
		ObjectInputStream[] lector = new ObjectInputStream[] { ios1, ios2, ios3, ios4 };
		AlumnoCFGS alumno;
		for (byte i = 1; i <= 4; i++) {
			for (alumno = (AlumnoCFGS) lector[i].readObject(); alumno != null; alumno = (AlumnoCFGS) lector[i]
					.readObject()) {
				oos.writeObject(alumno);
			}

			ios1.close();
			ios2.close();
			ios3.close();
			ios4.close();
			oos.close();
		}
	}

//		for (int j = 0; j < 24; j++) {
//			if (j <= 6) {
//				for (int k = 0; k < 6; k++) {
//					oos.writeObject(ios1.readObject());
//				}
//			} else if (j <= 12 && j > 6) {
//				for (int k = 0; k < 6; k++) {
//					oos.writeObject(ios2.readObject());
//				}
//			} else if (j <= 18 && j > 12) {
//				for (int k = 0; k < 6; k++) {
//					oos.writeObject(ios3.readObject());
//				}
//			} else if (j > 18) {
//				for (int k = 0; k < 4; k++) {
//					oos.writeObject(ios4.readObject());
//				}
//			}
//		}

}
