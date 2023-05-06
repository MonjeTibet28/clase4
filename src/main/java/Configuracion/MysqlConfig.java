package Configuracion;

import java.sql.*;

public class MysqlConfig {

    String url = "localhost:3306";
    String user = "root";
    String password = "";
    String bd = "develop";

    public Connection getConnetion () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://"+this.url+"/"+bd+"?user="+user+"&password=" + password;
        return DriverManager.getConnection(url);
    }

    public ResultSet getResulset(CallableStatement callableStatement) throws SQLException {
        return callableStatement.executeQuery();
    }

}
