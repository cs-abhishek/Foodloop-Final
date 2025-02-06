package com.foodloop;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verify-otp")
public class OTPVerificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enteredOTP = request.getParameter("otp");
        HttpSession session = request.getSession();

        String storedOTP = (String) session.getAttribute("otp");

        if (enteredOTP.equals(storedOTP)) {
            // OTP verified, save user to database
            String userType = (String) session.getAttribute("userType");
            String fullName = (String) session.getAttribute("fullName");
            String email = (String) session.getAttribute("email");
            String phone = (String) session.getAttribute("phone");
            String password = (String) session.getAttribute("password");

            // Save to database (example using UserDAO)
            UserDAO userDAO = new UserDAO();
            userDAO.saveUser(userType, fullName, email, phone, password);

            // Display credentials
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Registration Successful!</h2>");
            out.println("<p>Your credentials:</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<p>Password: " + password + "</p>");
            out.println("<p><a href='login.html'>Login here</a></p>");
        } else {
            // OTP verification failed
            response.sendRedirect("verify-otp.html?error=1");
        }
    }
}