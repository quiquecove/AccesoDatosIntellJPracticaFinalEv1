package ActividadFinalEv1;


import java.sql.SQLException;

public class DAO_Operaciones extends DAO1 {
    public void createTable() throws SQLException {
        super.createTable();
        createStatement = connection.prepareStatement("DROP TABLE PAISES");
        createStatement.execute();

        createStatement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS PAISES(REGION VARCHAR(35), NOMBRE_PAIS VARCHAR(15) PRIMARY KEY, PRESIDENTE VARCHAR(40), PIB INTEGER,GINI DOUBLE)");
        createStatement.execute();
    }

    public void crearRegistro(PaisSerializable a) throws SQLException {
        // TODO Auto-generated method stub
//		super.crearRegistro(int id,String nombre,byte edad,byte noGrupo, float altura, boolean juegaConsola, long horasEnLoL,String juegoFavorito);
//		if (existe(a)) {
        createStatement = connection.prepareStatement(
                "INSERT INTO PAISES (REGION,NOMBRE_PAIS, PRESIDENTE, PIB,GINI) VALUES (?, ?, ?, ?, ?)");
        createStatement.setString(1, a.getRegion());
        createStatement.setString(2, a.getNombre_pais());
        createStatement.setString(3, a.getPresidente());
        createStatement.setString(4, a.getPib());
        createStatement.setString(5, a.getGini());
        createStatement.execute();
        System.out.println("registro añadido");
//		} else {
//			System.out.println("error, ya existe");
//		}
    }

    public void consultarTabla() throws SQLException {
        createStatement = connection.prepareStatement("SELECT * FROM PAISES");
        resultSet = createStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print("Region: " + resultSet.getString("REGION") + " - ");
            System.out.print("Pais: " + resultSet.getString("NOMBRE_PAIS") + " - ");
            System.out.print("Presidente: " + resultSet.getString("PRESIDENTE") + " - ");
            System.out.print("PIB: " + resultSet.getInt("PIB") + " - ");
            System.out.print("GINI: " + resultSet.getInt("GINI"));
            System.out.println();
        }
    }
    public void consultarPais(String nombre) throws SQLException {
        createStatement = connection.prepareStatement("SELECT * FROM PAISES WHERE NOMBRE_PAIS=?");
        createStatement.setString(1,nombre);
        resultSet = createStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print("Region: " + resultSet.getString("REGION") + " - ");
            System.out.print("Pais: " + resultSet.getString("NOMBRE_PAIS") + " - ");
            System.out.print("Presidente: " + resultSet.getString("PRESIDENTE") + " - ");
            System.out.print("PIB: " + resultSet.getInt("PIB") + " - ");
            System.out.print("GINI: " + resultSet.getInt("GINI"));
            System.out.println();
            System.out.println("________------_________");
        }
    }

    public void modifPIB() throws SQLException {
        createStatement = connection.prepareStatement("UPDATE PAISES SET PIB = ?");
        createStatement.setInt(1, 10000000);
        createStatement.executeUpdate();
    }

    public void modiGINIshm(String nombre) throws SQLException {
        createStatement = connection.prepareStatement("SELECT GINI FROM PAISES WHERE NOMBRE_PAIS=?");
        createStatement.setString(1, String.valueOf(nombre));
        resultSet = createStatement.executeQuery();
        if (resultSet.next()) {
            double giniActual = resultSet.getDouble("GINI");

            // Calcular el nuevo valor del coeficiente de Gini reduciéndolo en un tercio
            double nuevoGini = giniActual * (2.0 / 3.0);

            // Actualizar el valor en la base de datos
            createStatement = connection.prepareStatement("UPDATE PAISES SET GINI=? WHERE NOMBRE_PAIS=?");
            createStatement.setDouble(1, nuevoGini);
            createStatement.setString(2, nombre);
            createStatement.executeUpdate();
        }else{
            System.out.println("Error");
        }
    }
}
