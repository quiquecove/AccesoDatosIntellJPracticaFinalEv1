package ActividadFinalEv1;
import java.sql.*;

public class DAO1 implements DAOInterfaz{



        protected static Connection connection;
        protected PreparedStatement createStatement;
        protected ResultSet resultSet;

        public static void init() throws SQLException {

            connection = DriverManager.getConnection("jdbc:hsqldb:PAISES");
            System.out.println("ze conecta");

        }

        @Override
        public void createTable() throws SQLException {
            // TODO Auto-generated method stub

        }

    @Override
    public void crearRegistro(PaisSerializable a) throws SQLException {

    }

    @Override
    public void consulta(PaisSerializable a) throws SQLException {

    }

    @Override
    public void modificarRegistro(PaisSerializable a) throws SQLException {

    }

    @Override
    public void borrarRegistro(PaisSerializable a) throws SQLException {

    }





}
