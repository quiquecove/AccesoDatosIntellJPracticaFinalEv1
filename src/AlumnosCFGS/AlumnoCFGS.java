package AlumnosCFGS;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlumnoCFGS implements Serializable {
	private static final long serialVersionUID = 1L;
	public String nombre;
	public byte edad;
	public byte noGrupo;
	public float alturaAproxEnMetros;
	public boolean juegaEnConsola;
	public long horasEnElLOL;
	public String juegoFavorito;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public byte getNoGrupo() {
		return noGrupo;
	}

	public void setNoGrupo(byte noGrupo) {
		this.noGrupo = noGrupo;
	}

	public float getAlturaAproxEnMetros() {
		return alturaAproxEnMetros;
	}

	public void setAlturaAproxEnMetros(float alturaAproxEnMetros) {
		this.alturaAproxEnMetros = alturaAproxEnMetros;
	}

	public boolean isJuegaEnConsola() {
		return juegaEnConsola;
	}

	public void setJuegaEnConsola(boolean juegaEnConsola) {
		this.juegaEnConsola = juegaEnConsola;
	}

	public long getHorasEnElLOL() {
		return horasEnElLOL;
	}

	public void setHorasEnElLOL(long horasEnElLOL) {
		this.horasEnElLOL = horasEnElLOL;
	}

	public String getJuegoFavorito() {
		return juegoFavorito;
	}

	public void setJuegoFavorito(String juegoFavorito) {
		this.juegoFavorito = juegoFavorito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void main(String[] args) throws IOException {

		List<AlumnoCFGS> listaAlumnos = new ArrayList<>();

		AlumnoCFGS alumno1 = new AlumnoCFGS("Fer", (byte) 27, (byte) 1, (float) 1.62, false, (long) 8000, "God of War");
		AlumnoCFGS alumno2 = new AlumnoCFGS("Quique", (byte) 19, (byte) 1, (float) 1.80, false, (long) 0,
				"My Friend Pedro");
		AlumnoCFGS alumno3 = new AlumnoCFGS("Edu", (byte) 23, (byte) 2, (float) 1.75, false, (long) 700, "Skyrim");
		AlumnoCFGS alumno4 = new AlumnoCFGS("Dani", (byte) 20, (byte) 2, (float) 1.97, false, (long) 2500, "FIFA");
		AlumnoCFGS alumno5 = new AlumnoCFGS("Dichao", (byte) 23, (byte) 3, (float) 1.65, true, (long) 48, "Overcooked");
		AlumnoCFGS alumno6 = new AlumnoCFGS("Angel", (byte) 23, (byte) 3, (float) 1.93, false, (long) 2355,
				"FinalFantasy");

		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		listaAlumnos.add(alumno4);
		listaAlumnos.add(alumno5);
		listaAlumnos.add(alumno6);
//		File file = new File("fila1.dat");
//		file.createNewFile();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fila1.dat"));

		for (int i = 0; i < listaAlumnos.size(); i++) {

			System.out.println(listaAlumnos.get(i).toString());

		}
		oos.writeObject(listaAlumnos);

	}

	private static String listaAlumnos(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public AlumnoCFGS(String nombre, byte edad, byte noGrupo, float alturaAproxEnMetros, boolean juegaEnConsola,
			long horasEnElLOL, String juegoFavorito) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.noGrupo = noGrupo;
		this.alturaAproxEnMetros = alturaAproxEnMetros;
		this.juegaEnConsola = juegaEnConsola;
		this.horasEnElLOL = horasEnElLOL;
		this.juegoFavorito = juegoFavorito;
	}

	@Override
	public String toString() {
		return "AlumnoCFGS:" + "\n" + "nombre='" + nombre + '\'' + ", edad=" + edad + ", noGrupo=" + noGrupo
				+ ", alturaAproxEnMetros=" + alturaAproxEnMetros + ", juegaEnConsola=" + juegaEnConsola
				+ ", horasEnElLOL=" + horasEnElLOL + ", juegoFavorito='" + juegoFavorito + '\'' + '\n';
	}
}
