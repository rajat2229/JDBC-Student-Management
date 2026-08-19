package com.jspider.jdbc_PreparedStatement_curd_operation.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseStatement {

    public static void closeStatement(Statement statement) {
        if (statement != null) {

            try {
                statement.close();
//                System.err.println("Statement is closed!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection connection) {

        if (connection != null) {

            try {
                connection.close();
                System.err.println("Connection is closed!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static void closeConnection(ResultSet resultset) {
    	if (resultset != null) {

            try {
                resultset.close();
//                System.err.println("ResultSet is closed!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}