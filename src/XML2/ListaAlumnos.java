package XML2;

import java.util.ArrayList;
import java.util.List;

public class ListaAlumnos {
	private List<AlumnoCFGS> lista = new ArrayList<>();

	public ListaAlumnos() {
	}

	public void add(AlumnoCFGS alumno) {
		lista.add(alumno);
	}

	public List<AlumnoCFGS> getListaAlumnos() {
		return lista;
	}

}
