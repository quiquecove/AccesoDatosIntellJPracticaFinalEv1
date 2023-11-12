package jdbc;

import java.sql.*;

public class ej1Jdbc {
	public static void main(String[] args) throws SQLException {

		// Conectamos con la base de datos
		Connection connection = DriverManager.getConnection("jdbc:derby:SeriesFavoritasDB;create=true");
		PreparedStatement statement;
		// Crear la tabla
		statement = connection.prepareStatement("DROP TABLE SeriesFavoritas");
		statement.executeUpdate();

		String sql = "CREATE TABLE SeriesFavoritas (id INTEGER PRIMARY KEY, nombre VARCHAR(255), SerieFavorita VARCHAR(255))";
		statement = connection.prepareStatement(sql);

		statement.executeUpdate();

		// Insertar
		statement = connection
				.prepareStatement("INSERT INTO SeriesFavoritas (id, nombre, SerieFavorita) VALUES (?, ?, ?)");
		statement.setInt(1, 1);
		statement.setString(2, "Quique");
		statement.setString(3, "Bojack");
		statement.executeUpdate();

		statement = connection
				.prepareStatement("INSERT INTO SeriesFavoritas (id, nombre, SerieFavorita) VALUES (?, ?, ?)");
		statement.setInt(1, 2);
		statement.setString(2, "Fer");
		statement.setString(3, "Dora la Explotadora");
		statement.executeUpdate();

		// Mostramos la tabla
		sql = "SELECT * FROM SeriesFavoritas";
		statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("nombre") + " - "
					+ resultSet.getString("SerieFavorita"));
		}

		// Cerramos la conexión
		connection.close();
	}
}
