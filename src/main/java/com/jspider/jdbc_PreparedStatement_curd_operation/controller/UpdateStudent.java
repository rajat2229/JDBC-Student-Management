package com.jspider.jdbc_PreparedStatement_curd_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.jdbc_PreparedStatement_curd_operation.connection.CloseStatement;

public class UpdateStudent {

	public static void updateStudent(Scanner scanner, Connection connection) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			// 1. Ask for ID
			System.out.print("Enter Student ID to update: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			// 2. Check whether student exists
			statement = connection.prepareStatement("SELECT id FROM student WHERE id = ?");

			statement.setInt(1, id);

			resultSet = statement.executeQuery();

			if (!resultSet.next()) {

				System.err.println("Student ID " + id + " not found.");
				return;
			}

			// Close the SELECT resources before doing UPDATE
			resultSet.close();
			resultSet = null;

			statement.close();
			statement = null;

			// 3. Student exists → show update options
			System.out.println("\n===== What do you want to update? =====");
			System.out.println("1. Name");
			System.out.println("2. Email");
			System.out.println("3. Phone");
			System.out.println("4. DOB");
			System.out.println("5. Address");
			System.out.println("6. Cancel");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			String sql = null;

			switch (choice) {

			case 1:

				System.out.print("Enter New Name: ");
				String name = scanner.nextLine();

				sql = "UPDATE student SET name = ? WHERE id = ?";

				statement = connection.prepareStatement(sql);

				statement.setString(1, name);
				statement.setInt(2, id);

				break;

			case 2:

				System.out.print("Enter New Email: ");
				String email = scanner.nextLine();

				sql = "UPDATE student SET email = ? WHERE id = ?";

				statement = connection.prepareStatement(sql);

				statement.setString(1, email);
				statement.setInt(2, id);

				break;

			case 3:

				System.out.print("Enter New Phone: ");
				String phone = scanner.nextLine();

				sql = "UPDATE student SET phone = ? WHERE id = ?";

				statement = connection.prepareStatement(sql);

				statement.setString(1, phone);
				statement.setInt(2, id);

				break;

			case 4:

				System.out.print("Enter New DOB (yyyy-mm-dd): ");
				String dob = scanner.nextLine();

				sql = "UPDATE student SET dob = ? WHERE id = ?";

				statement = connection.prepareStatement(sql);

				statement.setString(1, dob);
				statement.setInt(2, id);

				break;

			case 5:

				System.out.print("Enter New Address: ");
				String address = scanner.nextLine();

				sql = "UPDATE student SET address = ? WHERE id = ?";

				statement = connection.prepareStatement(sql);

				statement.setString(1, address);
				statement.setInt(2, id);

				break;

			case 6:

				System.out.println("Update cancelled.");
				return;

			default:

				System.out.println("Invalid choice.");
				return;
			}

			// 4. Execute UPDATE
			int result = statement.executeUpdate();

			if (result > 0) {
				System.err.println("Student updated successfully.");
			}

			System.out.println("Number of rows affected: " + result);

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseStatement.closeConnection(resultSet);
			CloseStatement.closeStatement(statement);
		}
	}
}