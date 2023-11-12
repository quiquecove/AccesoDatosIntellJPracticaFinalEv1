package jdbc;

import java.sql.*;
import java.util.Scanner;

public class sqlite {
	public static void main(String[] args) throws SQLException {
		Scanner in = new Scanner(System.in);
		// Conectamos con la base de datos
		Connection connection = DriverManager.getConnection("jdbc:sqlite:SeriesFavoritasDB2;create=true");
		PreparedStatement statement;
		ResultSet resultSet = null;
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

		statement = connection
				.prepareStatement("INSERT INTO SeriesFavoritas (id, nombre, SerieFavorita) VALUES (?, ?, ?)");
		statement.setInt(1, 3);
		statement.setString(2, "Angel");
		statement.setString(3, "Super nenas");
		statement.executeUpdate();

		statement = connection
				.prepareStatement("INSERT INTO SeriesFavoritas (id, nombre, SerieFavorita) VALUES (?, ?, ?)");
		statement.setInt(1, 4);
		statement.setString(2, "Dani");
		statement.setString(3, "Pocoyo");
		statement.executeUpdate();

		statement = connection
				.prepareStatement("INSERT INTO SeriesFavoritas (id, nombre, SerieFavorita) VALUES (?, ?, ?)");
		statement.setInt(1, 5);
		statement.setString(2, "Edu");
		statement.setString(3, "Breaking Bad");
		statement.executeUpdate();

		statement = connection
				.prepareStatement("INSERT INTO SeriesFavoritas (id, nombre, SerieFavorita) VALUES (?, ?, ?)");
		statement.setInt(1, 6);
		statement.setString(2, "Dichao");
		statement.setString(3, "Breaking Bad");
		statement.executeUpdate();

		// Mostramos la tabla
		// filtro
		sql = "SELECT * FROM SeriesFavoritas WHERE SerieFavorita = ? ";

		String inp;
		boolean fl = true;
		while (fl) {
		    try {
		    	System.out.println("¿Qué serie quieres filtrar?");
		        statement = connection.prepareStatement(sql);
		        inp = in.nextLine();
		        statement.setString(1, inp);
		        resultSet = statement.executeQuery();

		        if (resultSet.next()) {
		            fl = false;
		        } else {
		            System.out.println("No se ha encontrado resultado, vuelva a intentarlo");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		if (!fl) {
		    // Si se encontraron resultados, mostrarlos
		    do {
		        System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("nombre") + " - " + resultSet.getString("SerieFavorita"));
		    } while (resultSet.next());
		}

		// Cerramos la conexión
		connection.close();
	}
}
