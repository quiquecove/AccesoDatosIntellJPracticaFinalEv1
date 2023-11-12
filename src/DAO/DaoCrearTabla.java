package DAO;

import java.sql.SQLException;

public class DaoCrearTabla extends dao1 {

	public DaoCrearTabla() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTable() throws SQLException {
		super.createTable();
		createStatement = connection.prepareStatement("DROP TABLE TABLAALUMNOS");
		createStatement.execute();
		
		createStatement = connection.prepareStatement(
				"CREATE TABLE TABLAALUMNOS(NOMBRE VARCHAR(15) PRIMARY KEY, EDAD TINYINT, NOGRUPO TINYINT, ALTURAPROXENMETROS FLOAT, JUEGAENCONSOLA BOOLEAN, HORASENLOL BIGINT, JUEGOFAVORITO VARCHAR(25))");
		createStatement.execute();
	}

}
