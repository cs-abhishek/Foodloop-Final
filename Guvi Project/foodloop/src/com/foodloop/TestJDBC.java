import com.foodloop.UserDAO;
package com.foodloop;



public class TestJDBC {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Adding a new user
        boolean addSuccess = userDAO.addUser("Jane Doe", "janedoe@example.com", "password123");
        if (addSuccess) {
            System.out.println("User added successfully!");
        } else {
            Systm.out.println("Failed to add user.");
        }

        // Updating a user with ID 1
        boolean updateSuccess = userDAO.updateUser(1, "John Doe Updated", "johndoe_updated@example.com", "newpassword123");
        if (updateSuccess) {
            System.out.println("User updated successfully!");
        } else {
            System.out.println("Failed to update user.");
        }

        // Deleting a user with ID 1
        boolean deleteSuccess = userDAO.deleteUser(1);
        if (deleteSuccess) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("Failed to delete user.");
        }
    }
}
