package DAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main_test {
	public static void main(String[] args) throws SQLException {

		dao1 jdbcTest = new dao1();
		AlumnoCFGS alumno = new AlumnoCFGS("Enrique", (byte) 19, (byte) 1, (float) 1.80, true, 0L, "animalX");
		AlumnoCFGS alumno2 = new AlumnoCFGS("Fer", (byte) 19, (byte) 1, (float) 1.60, false, 0L, "lal");
		AlumnoCFGS alumno3 = new AlumnoCFGS("nacho", (byte) 21, (byte) 1, (float) 1.60, false, 0L, "lal");

		jdbcTest.init();
		DaoCrearTabla crearTabla = new DaoCrearTabla();
		crearTabla.createTable();
		DaoAddReg add = new DaoAddReg();
		add.crearRegistro(alumno);
		add.crearRegistro(alumno2);
		add.crearRegistro(alumno3);

		DaoConsultas consulta = new DaoConsultas();
		consulta.consulta(alumno);
		DaoBorrar borrado = new DaoBorrar();
		borrado.borrarRegistro(alumno3);
		System.out.println();
		consulta.consulta(alumno);
		DaoActualizar act = new DaoActualizar();
		System.out.println("¿Qué quieres modificar?");
		System.out
				.println("1 - nombre\n2 - edad\n3 - NoGrupo\n4 - Altura\n5 - JuegaConsola\n6 - horasLOL\n7 - JuegoFav");

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		in.nextLine(); 

		System.out.println("Ingresa el nombre del alumno:");
		String nombreAlumno = in.nextLine();

		switch (num) {
		case 1:
			System.out.println("Ingresa el nuevo nombre:");
			String nuevoNombre = in.nextLine();
			act.modificarNombre(nombreAlumno, nuevoNombre);
			consulta.consultaInd(nuevoNombre);
			break;
		case 2:
			System.out.println("Ingresa la nueva edad:");
			byte nuevaEdad = in.nextByte();
			act.modificarEdad(nombreAlumno, nuevaEdad);
			break;
		case 3:
			System.out.println("Ingresa el nuevo número de grupo:");
			byte nuevoNoGrupo = in.nextByte();
			act.modificarNoGrupo(nombreAlumno, nuevoNoGrupo);
			break;
		case 4:
			System.out.println("Ingresa la nueva altura en metros (x.x):");
			float nuevaAltura = in.nextFloat();
			act.modificarAlturaAproxEnMetros(nombreAlumno, nuevaAltura);
			break;
		case 5:
			System.out.println("¿Juega en consola? (true/false):");
			boolean juegaEnConsola = in.nextBoolean();
			act.modificarJuegaEnConsola(nombreAlumno, juegaEnConsola);
			break;
		case 6:
			System.out.println("Ingresa las nuevas horas en el LOL:");
			long nuevasHorasLOL = in.nextLong();
			act.modificarHorasEnElLOL(nombreAlumno, nuevasHorasLOL);
			break;
		case 7:
			System.out.println("Ingresa el nuevo juego favorito:");
			String nuevoJuegoFav = in.nextLine();
			act.modificarJuegoFavorito(nombreAlumno, nuevoJuegoFav);
			break;
		default:
			System.out.println("Opción no válida");
		}


		consulta.consultaInd(nombreAlumno);
	}

}
