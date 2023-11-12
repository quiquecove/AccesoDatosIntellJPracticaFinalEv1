package DAO;

import java.sql.SQLException;

public class DaoActualizar extends dao1 {
	public void modificarNombre(String nombre, String nombreN) throws SQLException {
		createStatement = connection.prepareStatement("UPDATE TABLAALUMNOS SET NOMBRE = ? WHERE NOMBRE = ?" );
		createStatement.setString(1, nombreN);
		createStatement.setString(2, nombre);
		int rowsUpdated = createStatement.executeUpdate();

		if (rowsUpdated > 0) {
			System.out.println("Nombre modificado con éxito.");
		} else {
			System.out.println("No se encontró el registro para modificar.");
		}
	}

	public void modificarEdad(String nombre, byte edad) throws SQLException {
		createStatement = connection.prepareStatement("UPDATE TABLAALUMNOS SET EDAD = ? WHERE NOMBRE = ?");
		createStatement.setByte(1,edad);
		createStatement.setString(2, nombre);
		int rowsUpdated = createStatement.executeUpdate();

		if (rowsUpdated > 0) {
			System.out.println("Edad modificada con éxito.");
		} else {
			System.out.println("No se encontró el registro para modificar.");
		}
	}

	public void modificarNoGrupo(String nombre, byte nGrupo) throws SQLException {
		createStatement = connection.prepareStatement("UPDATE TABLAALUMNOS SET NOGRUPO = ? WHERE NOMBRE = ?");
		createStatement.setByte(1, nGrupo);
		createStatement.setString(2, nombre);
		int rowsUpdated = createStatement.executeUpdate();

		if (rowsUpdated > 0) {
			System.out.println("Número de grupo modificado con éxito.");
		} else {
			System.out.println("No se encontró el registro para modificar.");
		}

	}

	public void modificarAlturaAproxEnMetros(String nombre, float altura) throws SQLException {
		createStatement = connection.prepareStatement("UPDATE TABLAALUMNOS SET ALTURAPROXENMETROS = ? WHERE NOMBRE = ?");
		createStatement.setFloat(1, altura);
		createStatement.setString(2, nombre);
		int rowsUpdated = createStatement.executeUpdate();

		if (rowsUpdated > 0) {
			System.out.println("Altura modificada con éxito.");
		} else {
			System.out.println("No se encontró el registro para modificar.");
		}
	}

	public void modificarJuegaEnConsola(String nombre,boolean juega) throws SQLException {
		createStatement = connection.prepareStatement("UPDATE TABLAALUMNOS SET JUEGAENCONSOLA = ? WHERE NOMBRE = ?");
		createStatement.setBoolean(1,juega);
		createStatement.setString(2, nombre);
		int rowsUpdated = createStatement.executeUpdate();

		if (rowsUpdated > 0) {
			System.out.println("Campo juegaEnConsola modificado con éxito.");
		} else {
			System.out.println("No se encontró el registro para modificar.");
		}
	}

	public void modificarHorasEnElLOL(String nombre, long horas) throws SQLException {
		createStatement = connection.prepareStatement("UPDATE TABLAALUMNOS SET HORASENLOL = ? WHERE NOMBRE = ?");
		createStatement.setLong(1, horas);
		createStatement.setString(2, nombre);
		int rowsUpdated = createStatement.executeUpdate();

		if (rowsUpdated > 0) {
			System.out.println("Horas en el LOL modificadas con éxito.");
		} else {
			System.out.println("No se encontró el registro para modificar.");
		}
	}

	public void modificarJuegoFavorito(String nombre, String juegoFav) throws SQLException {
		createStatement = connection.prepareStatement("UPDATE TABLAALUMNOS SET JUEGOFAVORITO = ? WHERE NOMBRE = ?");
		createStatement.setString(1, juegoFav);
		createStatement.setString(2, nombre);
		int rowsUpdated = createStatement.executeUpdate();

		if (rowsUpdated > 0) {
			System.out.println("Juego favorito modificado con éxito.");
		} else {
			System.out.println("No se encontró el registro para modificar.");
		}
	}

	// Implementa métodos similares para modificar los otros campos
	// (ALTURAPROXENMETROS, JUEGAENCONSOLA, HORASENLOL, JUEGOFAVORITO)

//	@Override
//	public void modificarRegistro(AlumnoCFGS a) throws SQLException {
//		// TODO Auto-generated method stub
////		super.modificarRegistro(int id,String nombre,byte edad,byte noGrupo, float altura, boolean juegaConsola, long horasEnLoL,String juegoFavorito);
//		    createStatement = connection.prepareStatement("INSERT INTO TABLAALUMNOS (NOMBRE, EDAD, NOGRUPO, ALTURAPROXENMETROS, JUEGAENCONSOLA, HORASENLOL, JUEGOFAVORITO) VALUES (?, ?, ?, ?, ?, ?, ?)");
//
//		    createStatement.setString(1, a.getNombre());
//		    createStatement.setByte(2, a.getEdad());
//		    createStatement.setByte(3, a.getNoGrupo());
//		    createStatement.setFloat(4, a.getAlturaAproxEnMetros());
//		    createStatement.setBoolean(5, a.isJuegaEnConsola());
//		    createStatement.setLong(6, a.getHorasEnElLOL());
//		    createStatement.setString(7, a.getJuegoFavorito());
//		    createStatement.executeUpdate();
//		    
//		    System.out.println("Registro modificado!!!");
//	}

}
