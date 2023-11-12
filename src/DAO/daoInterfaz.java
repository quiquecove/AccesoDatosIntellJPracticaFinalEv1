package DAO;

import java.sql.SQLException;

public interface daoInterfaz {
	
	public void createTable()throws SQLException;
	public void crearRegistro(AlumnoCFGS a)throws SQLException;
	public void consulta(AlumnoCFGS a)throws SQLException;
	public void modificarRegistro(AlumnoCFGS a) throws SQLException;
	public void borrarRegistro(AlumnoCFGS a)throws SQLException;
}
