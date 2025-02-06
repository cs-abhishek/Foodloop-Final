package com.foodloop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Method to add a new user
    public boolean addUser(String name, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int result = preparedStatement.executeUpdate();
            return result > 0;  // Return true if the user was added successfully
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        } finally {
            closeResources(connection, preparedStatement, null);
        }
        return false;  // Failed to add user
    }

    // Method to update an existing user
    public boolean updateUser(int userId, String name, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, userId);

            int result = preparedStatement.executeUpdate();
            return result > 0;  // Return true if the user was updated successfully
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        } finally {
            closeResources(connection, preparedStatement, null);
        }
        return false;  // Failed to update user
    }

    // Method to delete a user
    public boolean deleteUser(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            int result = preparedStatement.executeUpdate();
            return result > 0;  // Return true if the user was deleted successfully
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        } finally {
            closeResources(connection, preparedStatement, null);
        }
        return false;  // Failed to delete user
    }

    // Method to fetch user information (Optional)
    public User getUser(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(userId, name, email, password);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
        return null;  // User not found
    }

    // Method to check user credentials (for login)
    public boolean checkCredentials(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            return resultSet.next();  // If the result set has a row, credentials are correct
        } catch (SQLException e) {
            System.out.println("Error checking credentials: " + e.getMessage());
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
        return false;  // Incorrect credentials
    }

    // Helper method to close database resources
    private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
