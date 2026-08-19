package com.jspider.jdbc_PreparedStatement_curd_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.jdbc_PreparedStatement_curd_operation.connection.CloseStatement;

public class DeleteStudent {

    public static void deleteStudent(
            Scanner scanner,
            Connection connection) {

        PreparedStatement statement = null;

        try {

            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            statement = connection.prepareStatement(
                    "DELETE FROM student WHERE id = ?"
            );

            statement.setInt(1, id);

            int result = statement.executeUpdate();

            if (result > 0) {
                System.err.println("Student deleted successfully.");
            } else {
                System.out.println("Student ID not found.");
            }

            System.out.println(
                    "Number of rows affected: " + result
            );

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {
        	CloseStatement.closeStatement(statement);
        }
    }
}