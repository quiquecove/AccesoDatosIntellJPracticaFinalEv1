package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dao1 implements daoInterfaz {
	
	protected static Connection connection;
	protected PreparedStatement createStatement; 
	protected ResultSet resultSet;
	
	public static void init() throws SQLException {
		
		 connection = DriverManager.getConnection("jdbc:hsqldb:pruebas");
		 System.out.println("ze conecta");
		
	}

	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearRegistro(AlumnoCFGS a) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consulta(AlumnoCFGS a) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarRegistro(AlumnoCFGS a) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarRegistro(AlumnoCFGS a)throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
