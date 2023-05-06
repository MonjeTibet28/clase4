import Configuracion.MysqlConfig;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


    callExample();
    }

    public static void callExample() throws SQLException, ClassNotFoundException {

        MysqlConfig config = new MysqlConfig();
        String sqlToCallSP="{call eliminar_ciudad(?,?)}";
        Connection con = config.getConnetion();
        CallableStatement clbStament = con.prepareCall(sqlToCallSP);
        clbStament.setString(1,"Rusia" );
        clbStament.registerOutParameter(2, Types.INTEGER);

        config.getResulset(clbStament);

        int valorRetornado = clbStament.getInt("filas");
        System.out.println(" filas afectadas: " + valorRetornado);
    }

}
