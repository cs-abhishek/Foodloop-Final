package com.foodoop;

public class TestJDBC {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.addUser("John Doe", "johndoe@example.com", "password123");
        if (success) {
            System.out.println("User added successfully!");
        } else {
            System.out.println("Failed to add user.");
        }
    }
}
