package com.dao;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

import com.model.etudient ;



public class etudientDAO {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/nour";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "";


    public void insertUser(etudient user) throws ClassNotFoundException {

        // try-with-resource statement will auto close the connection.
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.etudients(\n" +
                     "\tetudient_id, nom, prenom, datenaiss, sexe, numbac, dateinsc)\n" +
                     "\tVALUES (?, ?, ?, ?, ?, ?, ?);")) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getNom());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getDateNaiss());
            preparedStatement.setString(5, user.getSexe());
            preparedStatement.setInt(6, user.getNumBac());
            preparedStatement.setString(7, user.getDateInsc());


            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);

        }
    }


    public List<etudient> selectAllUsers() throws ClassNotFoundException {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<etudient> users = new ArrayList<>();
        Class.forName("org.postgresql.Driver");

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etudients;");) {

            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            etudient u;
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Integer id = rs.getInt("etudient_id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String datenaiss = rs.getString("datenaiss");
                String sexe = rs.getString("sexe");
                Integer numbac = rs.getInt("numbac");
               String dateinsc = rs.getString("dateinsc");
               u = new etudient(id, nom, prenom, datenaiss , sexe , numbac , dateinsc);
               u.setId(id);
               u.setNom(nom);
               u.setPrenom(prenom);
               u.setDateNaiss(datenaiss);
               u.setSexe(sexe);
               u.setNumBac(numbac);
               u.setDateInsc(dateinsc);
                users.add(u);
            }

        } catch (SQLException e) {
            printSQLException(e);

        }

        return users;
    }

    public boolean deleteUser(int id) throws  ClassNotFoundException {
        boolean rowDeleted = false;
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM public.etudients WHERE etudient_id = ?;");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {

            printSQLException(e);
        }
        return rowDeleted;
    }
    public boolean updateUser(etudient user) throws  ClassNotFoundException {
        boolean rowUpdated = false;
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement("UPDATE public.etudients SET  nom=?, prenom=?, datenaiss=?, sexe=?, numbac=?, dateinsc=? WHERE etudient_id= ?;");) {



            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3,  user.getDateNaiss());
            statement.setString(4, user.getSexe());
            statement.setInt(5, user.getNumBac());
            statement.setString(6, user.getDateInsc());
            statement.setInt(7,user.getId());






            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
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
