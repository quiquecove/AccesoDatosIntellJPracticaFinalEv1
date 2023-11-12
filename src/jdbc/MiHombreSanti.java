package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MiHombreSanti {

	private static final String[] nombres = { "Pedro Sánchez", "Alberto Núñez Feijóo", "Santiago Abascal",
			"Albert Rivera" };
	private static final int[] edades = { 50, 60, 45, 45 };
	private static final String[] estudios = { "Licenciatura", "Licenciatura", "Licenciatura", "Doctorado" };

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:lider_partidos");

		PreparedStatement createStatement = connection.prepareStatement(
				"CREATE TABLE IF NOT EXISTS LideresPartidos (nombre VARCHAR(255) PRIMARY KEY, edad INTEGER, estudios VARCHAR(255))");
		createStatement.executeUpdate();

		PreparedStatement insertStatement = connection
				.prepareStatement("INSERT INTO LideresPartidos (nombre, edad, estudios) VALUES (?, ?, ?)");
		for (int i = 0; i < 4; i++) {
			insertStatement.setString(1, nombres[i]);
			insertStatement.setInt(2, edades[i]);
			insertStatement.setString(3, estudios[i]);
			insertStatement.executeUpdate();
		}

		PreparedStatement countStatement = connection.prepareStatement("SELECT COUNT(*) FROM LideresPartidos");
		ResultSet rs = countStatement.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		if (count != 4) {
			throw new SQLException("Error al crear o recuperar la tabla LideresPartidos");
		}

		Scanner in = new Scanner(System.in);

		System.out.println("Añadir nuevos miembros:");
		System.out.print("Nombre: ");
		String nuevoNombre = in.nextLine();
		System.out.print("Edad: ");
		int nuevaEdad = Integer.parseInt(in.nextLine());
		System.out.print("Estudios: ");
		String nuevosEstudios = in.nextLine();

		PreparedStatement checkStatement = connection
				.prepareStatement("SELECT * FROM LideresPartidos WHERE nombre = ?");
		checkStatement.setString(1, nuevoNombre);
		rs = checkStatement.executeQuery();

		if (!rs.next()) {
			insertStatement.setString(1, nuevoNombre);
			insertStatement.setInt(2, nuevaEdad);
			insertStatement.setString(3, nuevosEstudios);
			insertStatement.executeUpdate();
			System.out.println("Nuevo miembro agregado con éxito.");
		} else {
			System.out.println("Error, valor repetido. Introduce otro nombre.");

		}
		System.out.println("Miembros en la base de datos:");
		PreparedStatement selectAllStatement = connection.prepareStatement("SELECT * FROM LideresPartidos");
		rs = selectAllStatement.executeQuery();
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			int edad = rs.getInt("edad");
			String estudios = rs.getString("estudios");
			System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Estudios: " + estudios);
		}

		connection.close();
		in.close();
	}
}
