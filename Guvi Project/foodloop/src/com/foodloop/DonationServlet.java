package com.foodloop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/donation")
public class DonationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of available donations (dummy data or actual data from the database)
        // For example, you could call a DAO method to get all the donations
        // DonationDAO donationDAO = new DonationDAO();
        // List<Donation> donations = donationDAO.getAvailableDonations();

        // Set the donations data as a request attribute to be used in a JSP
        // request.setAttribute("donations", donations);

        // Forward the request to a JSP page to display the donations
        request.getRequestDispatcher("/viewDonations.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle a form submission to make a new donation
        String foodName = request.getParameter("foodName");
        String quantity = request.getParameter("quantity");
        String description = request.getParameter("description");

        // Call a DAO method to save the new donation (assuming you have a DonationDAO with an addDonation method)
        // DonationDAO donationDAO = new DonationDAO();
        // boolean success = donationDAO.addDonation(new Donation(foodName, quantity, description));

        // For this example, let's assume the donation is always successful
        boolean success = true;

        if (success) {
            // Set a success message
            request.setAttribute("message", "Donation added successfully!");
        } else {
            // Set a failure message
            request.setAttribute("message", "Failed to add donation.");
        }

        // Redirect the user to a page that shows donations (could be a success page or a list of donations)
        request.getRequestDispatcher("/viewDonations.jsp").forward(request, response);
    }
}
