package com.jspider.jdbc_PreparedStatement_curd_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.jdbc_PreparedStatement_curd_operation.connection.CloseStatement;

public class InsertStudent {

	public static void insertStudent(Scanner scanner, Connection connection) {

		PreparedStatement statement = null;

		try {

			statement = connection.prepareStatement("INSERT INTO student "
					+ "(id, name, email, phone, dob, address, password) " + "VALUES (?, ?, ?, ?, ?, ?, ?)");

			System.out.print("Enter ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Email: ");
			String email = scanner.nextLine();

			System.out.print("Enter Phone: ");
			String phone = scanner.nextLine();

			System.out.print("Enter DOB (yyyy-mm-dd): ");
			String dob = scanner.nextLine();

			System.out.print("Enter Address: ");
			String address = scanner.nextLine();

			System.out.print("Enter Password: ");
			String password = scanner.nextLine();

			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, email);
			statement.setString(4, phone);
			statement.setString(5, dob);
			statement.setString(6, address);
			statement.setString(7, password);

			int result = statement.executeUpdate();

			if (result > 0) {
				System.err.println("Student inserted successfully.");
			}

			System.out.println("Number of rows affected: " + result);

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseStatement.closeStatement(statement);
		}
	}
}
