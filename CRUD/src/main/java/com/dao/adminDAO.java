package com.dao;
import java.sql.*;

import com.model.admin;
public class adminDAO {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/nour";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "";

    public int registerAdmin(admin admin) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO admin" +
                "  (id, name, email, password) VALUES " +
                " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);


             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, admin.getId());
            preparedStatement.setString(2, admin.getName());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getPassword());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    public boolean adminvalidate(admin admin) throws ClassNotFoundException {
        boolean status = false;
        String user_db =".";
        String pass_db = ".";
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM ADMIN where email = ? and password = ?")) {
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                user_db = rs.getString("email");
                pass_db = rs.getString("password");
            }
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        System.out.println(user_db.length() +"  "+pass_db.length());
        System.out.println(admin.getEmail().length()+"    "+admin.getPassword().length());
        System.out.println(user_db.equals(admin.getEmail()));
        System.out.println(pass_db.equals(admin.getPassword()));
        System.out.println(user_db.equals(admin.getEmail())&&pass_db.equals(admin.getPassword()));
      return user_db.equals(admin.getEmail())&&pass_db.equals(admin.getPassword());

    }


    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
