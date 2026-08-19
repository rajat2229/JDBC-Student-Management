package com.jspider.jdbc_PreparedStatement_curd_operation.connection;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class StudentConnection {

	public static Connection getjdbcStudentConnection() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc-m19";// enter your database url 
		String user = "root";//enter your user name here
		String pass = "";//enter your password here
		return DriverManager.getConnection(url, user, pass);
	}
}
