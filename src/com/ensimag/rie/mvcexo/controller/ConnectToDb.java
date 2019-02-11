package com.ensimag.rie.mvcexo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Static helper class for getting connectino to database.
 */
public class ConnectToDb {

    private static final String ORACLE_JDBC_URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:ensioracle1";
    private static final String LOGIN = "bayeri";
    private static final String PASSWD = "bayeri";

    /**
     * Method to log to database and create connection. Works with ORACLE_JDBC_URL, LOGIN and PASSWD.
     * @return created connection
     * @throws SQLException if DB connection fails
     */
    public static Connection createConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(ORACLE_JDBC_URL,LOGIN,PASSWD);

        return connection;
    }
}
