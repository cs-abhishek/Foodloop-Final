package com.foodloop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delivery")
public class DeliveryServlet extends HttpServlet {

    // Method to handle GET requests for managing deliveries
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of scheduled deliveries (dummy data or actual data from the database)
        // For example, you could call a DAO method to get all the deliveries
        // DeliveryDAO deliveryDAO = new DeliveryDAO();
        // List<Delivery> deliveries = deliveryDAO.getAllDeliveries();

        // Set the deliveries data as a request attribute to be used in a JSP
        // request.setAttribute("deliveries", deliveries);

        // Forward the request to a JSP page to display the deliveries
        request.getRequestDispatcher("/viewDeliveries.jsp").forward(request, response);
    }

    // Method to handle POST requests for scheduling a new delivery (pickup or drop-off)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the necessary data from the request to schedule a delivery
        String deliveryType = request.getParameter("deliveryType"); // Pickup or Drop-off
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String address = request.getParameter("address");

        // Call a DAO method to save the new delivery (assuming you have a DeliveryDAO with an addDelivery method)
        // DeliveryDAO deliveryDAO = new DeliveryDAO();
        // boolean success = deliveryDAO.addDelivery(new Delivery(deliveryType, date, time, address));

        // For this example, let's assume the delivery is always scheduled successfully
        boolean success = true;

        // Set an appropriate message depending on the success of the delivery scheduling
        if (success) {
            request.setAttribute("message", "Delivery scheduled successfully!");
        } else {
            request.setAttribute("message", "Failed to schedule delivery.");
        }

        // Forward the request to a page that shows delivery details or status
        request.getRequestDispatcher("/viewDeliveries.jsp").forward(request, response);
    }
}
