package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoConsultas extends dao1 {

	@Override
	public void consulta(AlumnoCFGS a) throws SQLException {
		// super.consulta(id, juegoFavorito, noGrupo, noGrupo, altura, juegaConsola,
		// horasEnLoL, juegoFavorito);
//		createStatement = connection.prepareStatement("SELECT * FROM TABLAALUMNOS WHERE NOMBRE=?,AND EDAD=?,AND NOGRUPO=?,AND alturaAproxEnMetros=?,AND juegaEnConsola=?,AND horasEnElLOL=?,AND juegoFavorito=?");
//		while (resultSet.next()) {
//			createStatement.setString(1, a.getNombre());
//			createStatement.setByte(2, a.getEdad());
//			createStatement.setByte(3, a.getNoGrupo());
//			createStatement.setFloat(4, a.getAlturaAproxEnMetros());
//			createStatement.setBoolean(5, a.isJuegaEnConsola());
//			createStatement.setLong(6, a.getHorasEnElLOL());
//			createStatement.setString(7, a.getJuegoFavorito());
//	}
		createStatement = connection.prepareStatement("SELECT * FROM TABLAALUMNOS");
//		createStatement.setString(1, a.getNombre());
		resultSet = createStatement.executeQuery();

//			 Realiza acciones con los datos recuperados, por ejemplo, imprimirlos

		while (resultSet.next()) {
			System.out.print("Nombre: " + resultSet.getString("nombre") + " - ");
			System.out.print("Edad: " + resultSet.getByte("edad") + " - ");
			System.out.print("NoGrupo: " + resultSet.getByte("noGrupo") + " - ");
			System.out.print("Altura: " + resultSet.getFloat("alturaproxEnMetros") + " - ");
			System.out.print("Juega en Consola: " + resultSet.getBoolean("juegaEnConsola") + " - ");
			System.out.print("Horas en el LOL: " + resultSet.getLong("horasEnLOL") + " - ");
			System.out.print("Juego Favorito: " + resultSet.getString("juegoFavorito"));
			System.out.println();
		}

		// Cierra el resultSet después de usarlo
		resultSet.close();
	}

	public void consultaInd(String nombre) throws SQLException {
		createStatement = connection.prepareStatement("SELECT * FROM TABLAALUMNOS WHERE NOMBRE=? ");
		createStatement.setString(1, nombre);
		resultSet = createStatement.executeQuery();
		while (resultSet.next()) {
			System.out.print("Nombre: " + resultSet.getString("nombre") + " - ");
			System.out.print("Edad: " + resultSet.getByte("edad") + " - ");
			System.out.print("NoGrupo: " + resultSet.getByte("noGrupo") + " - ");
			System.out.print("Altura: " + resultSet.getFloat("alturaproxEnMetros") + " - ");
			System.out.print("Juega en Consola: " + resultSet.getBoolean("juegaEnConsola") + " - ");
			System.out.print("Horas en el LOL: " + resultSet.getLong("horasEnLOL") + " - ");
			System.out.print("Juego Favorito: " + resultSet.getString("juegoFavorito"));
			System.out.println();
		}
		resultSet.close();

	}

}
