package DAO;

import java.sql.SQLException;

public class DaoBorrar extends dao1 {

	@Override
	public void borrarRegistro(AlumnoCFGS a) throws SQLException {
		// TODO Auto-generated method stub
		
		createStatement = connection.prepareStatement("DELETE FROM TABLAALUMNOS WHERE NOMBRE=?");
		createStatement.setString(1, a.getNombre());
		createStatement.execute();
	
	}

	
}
