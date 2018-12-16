package com.ensimag.rie.mvcexo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("------------------------- Oracle JDBC Connection Testing --------------------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC not found!");
            ex.printStackTrace();
            return;
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.ensimag.fr:1521:ensioracle1","bayeri","bayeri");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection == null) {
            System.out.println("Failed connection.");
        } else {
            System.out.println("gooooood!!!");
        }
    }
}
