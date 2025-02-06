package com.foodloop;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserServlet extends HttpServlet {

    // Handling POST request for user registration
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user information from request parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check if all required fields are provided
        if (name == null || email == null || password == null || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Please fill in all fields.</h2>");
            return;
        }

        // Use UserDAO to add user to the database
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.addUser(name, email, password);

        // Set response type and create output stream
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if user was added successfully
        if (success) {
            out.println("<h2>User added successfully!</h2>");
            out.println("<a href='login.html'>Go to Login</a>");
        } else {
            out.println("<h2>Failed to add user. Please try again later.</h2>");
        }
    }

    // Handling GET request to view or manage user details
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming the user is logged in and we have user details in session
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");

        if (userEmail == null) {
            response.sendRedirect("login.html");
            return;
        }

        // Fetch user details using UserDAO (e.g., retrieving user data from the database)
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmail(userEmail);

        // Display the user details if found
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (user != null) {
            out.println("<h2>User Details</h2>");
            out.println("<p>Name: " + user.getName() + "</p>");
            out.println("<p>Email: " + user.getEmail() + "</p>");
            out.println("<a href='editProfile.html'>Edit Profile</a>");
        } else {
            out.println("<h2>User not found.</h2>");
        }
    }
}
