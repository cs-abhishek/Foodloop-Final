package com.foodloop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Method to handle GET requests to display the login page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the login JSP page
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    // Method to handle POST requests for checking user credentials
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verify the credentials (you can check the credentials against the database using UserDAO)
        UserDAO userDAO = new UserDAO();
        boolean validUser = userDAO.checkCredentials(username, password);  // You need to implement this method in UserDAO

        // If credentials are valid, create a session for the user
        if (validUser) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);  // Store the username in the session

            // Redirect the user to the dashboard or home page after successful login
            response.sendRedirect("home.jsp");  // Redirect to a home/dashboard page (modify the path as needed)
        } else {
            // If credentials are invalid, set an error message and forward back to the login page
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
