package com.ensimag.rie.mvcexo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToDb {

    private static final String ORACLE_JDBC_URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:ensioracle1";
    private static final String LOGIN = "bayeri";
    private static final String PASSWD = "bayeri";

    public static Connection createConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(ORACLE_JDBC_URL,LOGIN,PASSWD);

        return connection;
    }
}
