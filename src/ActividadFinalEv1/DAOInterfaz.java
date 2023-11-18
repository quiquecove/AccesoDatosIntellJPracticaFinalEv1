package ActividadFinalEv1;

import java.sql.SQLException;

public interface DAOInterfaz {

    public void createTable()throws SQLException;

    void crearRegistro(PaisSerializable a) throws SQLException;

    public void consulta(PaisSerializable a)throws SQLException;
    public void modificarRegistro(PaisSerializable a) throws SQLException;
    public void borrarRegistro(PaisSerializable a)throws SQLException;


}
