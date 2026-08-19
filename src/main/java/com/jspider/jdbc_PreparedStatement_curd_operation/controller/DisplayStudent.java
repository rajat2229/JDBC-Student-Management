package com.jspider.jdbc_PreparedStatement_curd_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.jdbc_PreparedStatement_curd_operation.connection.CloseStatement;

public class DisplayStudent {

	public static void displayStudent(Connection connection) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			statement = connection.prepareStatement("SELECT id, name, email, phone, dob, address " + "FROM student");

			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				System.out.println("[ ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name")
						+ ", Email: " + resultSet.getString("email") + ", Phone: " + resultSet.getString("phone")
						+ ", DOB: " + resultSet.getDate("dob") + ", Address: " + resultSet.getString("address") + " ]");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseStatement.closeConnection(resultSet);
			
		}
	}
}