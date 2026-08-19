package com.jspider.jdbc_PreparedStatement_curd_operation.controller;

import java.sql.*;
import java.util.*;

import com.jspider.jdbc_PreparedStatement_curd_operation.connection.CloseStatement;
import com.jspider.jdbc_PreparedStatement_curd_operation.connection.StudentConnection;

public class StudentController {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Connection connection = null;

		try {

			connection = StudentConnection.getjdbcStudentConnection();

			while (true) {
				System.out.println("\n===== Student Management System =====");

				System.out.println("1. Create Student");
				System.out.println("2. Display Students");
				System.out.println("3. Update Students");
				System.out.println("4. Delete Students");
				System.out.println("5. Exit");

				System.out.print("Enter your choice: ");

				int choice = scanner.nextInt();

				switch (choice) {

				case 1:

					InsertStudent.insertStudent(scanner, connection);

					break;

				case 2:

					DisplayStudent.displayStudent(connection);

					break;

				case 3:
					UpdateStudent.updateStudent(scanner, connection);

					break;
				case 4:
					DeleteStudent.deleteStudent(scanner, connection);

					break;

				case 5:
					System.err.println("Application is closing...");

					return;

				default:

					System.out.println("Invalid choice!");
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseStatement.closeConnection(connection);
			scanner.close();
			System.out.println("Scanner is closed!");
		}
	}
}