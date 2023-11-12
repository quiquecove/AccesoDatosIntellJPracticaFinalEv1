package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ListaPartidos2 {

    private static final String[] nombres = { "Pedro Sánchez", "Alberto Núñez Feijóo", "Santiago Abascal", "Albert Rivera" };
    private static final int[] edades = { 50, 60, 45, 45 };
    private static final String[] estudios = { "Licenciatura", "Licenciatura", "Licenciatura", "Doctorado" };

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:../lider_partidos");

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

        // Modificar la edad de Pedro Sánchez
        System.out.println("Introduce la nueva edad de Pedro Sánchez: ");
        int nePS = Integer.parseInt(in.nextLine());

        PreparedStatement updateEdadStatement = connection
                .prepareStatement("UPDATE LideresPartidos SET edad = ? WHERE nombre = ?");
        updateEdadStatement.setInt(1, nePS);
        updateEdadStatement.setString(2, "Pedro Sánchez");
        updateEdadStatement.executeUpdate();

        System.out.println("La edad de Pedro Sánchez ha sido modificada con éxito.");

        // Modificar el nombre de Pedro Sánchez
        System.out.println("Introduce el nuevo nombre de Pedro Sánchez: ");
        String nnPS = in.nextLine();

        PreparedStatement updateNombreStatement = connection
                .prepareStatement("UPDATE LideresPartidos SET nombre = ? WHERE nombre = ?");
        updateNombreStatement.setString(1, nnPS);
        updateNombreStatement.setString(2, "Pedro Sánchez");
        updateNombreStatement.executeUpdate();

        System.out.println("El nombre de Pedro Sánchez ha sido modificado con éxito.");

        // Modificar la edad de Alberto Núñez Feijóo
        PreparedStatement updateEdadStatement2 = connection
                .prepareStatement("UPDATE LideresPartidos SET edad = ? WHERE nombre = ?");
        updateEdadStatement2.setInt(1, 62);
        updateEdadStatement2.setString(2, "Alberto Núñez Feijóo");
        updateEdadStatement2.executeUpdate();

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
