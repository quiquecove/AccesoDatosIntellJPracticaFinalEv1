package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ejManu {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection conexion = DriverManager.getConnection("jdbc:derby:Prueba1;create=true");
		String q1 = "CREATE TABLE SERIESFAVORITAS (ID INT PRIMARY KEY, NOMBRE VARCHAR(15), SERIEFAVORITA VARCHAR(25))";
		PreparedStatement sentencia = conexion.prepareStatement(q1);
		sentencia.execute();
		String q2 = "INSERT INTO SERIESFAVORITAS VALUES(1, 'ANA', 'AGENTE NOCTURNO')";
		sentencia = conexion.prepareStatement(q2);
		sentencia.execute();
		q2 = "INSERT INTO SERIESFAVORITAS VALUES(2, 'BERNARDO', 'BREAKING BAD')";
		sentencia = conexion.prepareStatement(q2);
		sentencia.execute();
		String q3 = "SELECT * FROM SERIESFAVORITAS";
		sentencia = conexion.prepareStatement(q3);
		ResultSet result = sentencia.executeQuery();

		while (result.next()) {
			System.out.print(result.getInt("ID") + "\t");
			System.out.print(result.getString("NOMBRE") + "\t\t");
			System.out.println(result.getString("SERIEFAVORITA"));
		}
		conexion.close();
	}
}
