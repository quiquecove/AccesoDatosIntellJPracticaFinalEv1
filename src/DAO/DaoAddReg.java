package DAO;

import java.sql.SQLException;

public class DaoAddReg extends dao1 {

	@Override
	public void crearRegistro(AlumnoCFGS a) throws SQLException {
		// TODO Auto-generated method stub
//		super.crearRegistro(int id,String nombre,byte edad,byte noGrupo, float altura, boolean juegaConsola, long horasEnLoL,String juegoFavorito);
//		if (existe(a)) {
			createStatement = connection.prepareStatement(
					"INSERT INTO TABLAALUMNOS (NOMBRE, EDAD, NOGRUPO, ALTURAPROXENMETROS, JUEGAENCONSOLA, HORASENLOL, JUEGOFAVORITO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			createStatement.setString(1, a.getNombre());
			createStatement.setByte(2, a.getEdad());
			createStatement.setByte(3, a.getNoGrupo());
			createStatement.setFloat(4, a.getAlturaAproxEnMetros());
			createStatement.setBoolean(5, a.isJuegaEnConsola());
			createStatement.setLong(6, a.getHorasEnElLOL());
			createStatement.setString(7, a.getJuegoFavorito());
			createStatement.execute();
			System.out.println("registro añadido");
//		} else {
//			System.out.println("error, ya existe");
//		}
	}

//	public boolean existe(AlumnoCFGS a) throws SQLException {
//		
//		createStatement = connection.prepareStatement("SELECT * FROM TABLAALUMNOS WHERE NOMBRE=?,AND EDAD=?,AND NOGRUPO=?,AND "
//				+ "alturaAproxEnMetros=?,AND juegaEnConsola=?,AND horasEnElLOL=?,AND juegoFavorito=?");
//		createStatement.setString(1, a.getNombre());
//		createStatement.setByte(2, a.getEdad());
//		createStatement.setByte(3, a.getNoGrupo());
//		createStatement.setFloat(4, a.getAlturaAproxEnMetros());
//		createStatement.setBoolean(5, a.isJuegaEnConsola());
//		createStatement.setLong(6, a.getHorasEnElLOL());
//		createStatement.setString(7, a.getJuegoFavorito());
//		resultSet = createStatement.executeQuery();
//		
//		if (!resultSet.next()) {
//			return true;
//
//		}else {
//		return false;
//		}
//	}

}
