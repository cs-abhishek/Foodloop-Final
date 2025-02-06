package com.foodloop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of food donations and users to display
        // For example, you could call DAO methods here to get donations and users
        // You can send this data to a JSP page for display

        // Example: Retrieving and displaying food donations and users (Dummy data or actual data from database)
        // DonationDAO donationDAO = new DonationDAO();
        // List<Donation> donations = donationDAO.getAllDonations();

        // You can also handle errors here if needed
        request.setAttribute("message", "Displaying food donations and users.");
        request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process form submissions for actions like approving donations or managing users
        String action = request.getParameter("action");

        if ("approveDonation".equals(action)) {
            // Handle the logic to approve a food donation (example)
            String donationId = request.getParameter("donationId");
            // DonationDAO donationDAO = new DonationDAO();
            // donationDAO.approveDonation(donationId);

            request.setAttribute("message", "Donation approved successfully.");
        } else if ("manageUser".equals(action)) {
            // Handle user management actions like adding or removing users
            String userId = request.getParameter("userId");
            // UserDAO userDAO = new UserDAO();
            // userDAO.removeUser(userId);

            request.setAttribute("message", "User removed successfully.");
        }

        // After handling the POST action, redirect to the admin dashboard or show appropriate message
        request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
    }
}
