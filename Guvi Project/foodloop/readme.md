FoodLoop Project

Made By- Team Dev Raven, of Section 23. B.tech CSE 2023-27.
Team Members are- Abhishek Kumar (23SCSE1010692) - Group Leader, Akanksha, Bablu Kumar and Pragati Nigam

Overview|

FoodLoop is a food waste management system designed to help connect food donors with NGOs, charities, and delivery personnel to efficiently distribute excess food to people in need. The project aims to leverage modern web technologies and databases to create a robust and scalable solution.

Project Setup Instructions

1. JDK & IDK Setup
   Ensure you have JDK 1.8 or later installed. You can download it from Oracle's JDK Download Page.
   Make sure you have an Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or Visual Studio Code installed. You can follow these guides to set up:
   Visual Studio Code Java Setup
   IntelliJ IDEA Setup
   Eclipse Setup
2. Project Structure
   The project is organized into multiple modules as per standard Java web development practices. Here is the directory structure:

scss
Copy code
foodloop-web/
│
├── src/
│ ├── com.foodloop.dao/
│ │ └── UserDAO.java
│ └── com.foodloop.model/
│ └── User.java
├── lib/
│ └── (External libraries for JDBC and other utilities)
├── webapp/
│ ├── WEB-INF/
│ │ └── web.xml
│ └── index.jsp
├── pom.xml
└── target/
└── foodloop-web.war
Database Design
The FoodLoop application connects to a MySQL database to store user data and other relevant information. The database schema has been designed with tables that can be easily extended to support future functionality.

Database Schema:
User Table:
id (INT, AUTO_INCREMENT): Primary key
name (VARCHAR(100)): Name of the user
email (VARCHAR(100)): User's email address
password (VARCHAR(100)): User's password (encrypted)
MySQL Table Creation
The SQL command to create the user table is as follows:

sql
Copy code
CREATE TABLE user (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
email VARCHAR(100),
password VARCHAR(100)
);
JDBC Database Connectivity
The application connects to the database using JDBC. The UserDAO class manages the database operations such as adding users.

JDBC Implementation:
The DBConnection class manages the connection to the MySQL database using JDBC.
The UserDAO class handles CRUD operations like adding a user to the database.
The TestJDBC class is used to test the JDBC functionality by adding a new user.
DAO Classes
UserDAO Class:
The UserDAO class provides methods to interact with the database. Here, we are using the addUser() method to insert a user into the database.

How to Run the Project
Set up MySQL Database:

Ensure your MySQL database is running and you have created a database (e.g., foodloop_db).
Run the provided SQL script to create the necessary tables.
Configure JDBC Connection:

Make sure to update the JDBC URL, username, and password in the DBConnection.java file to match your database configuration.
Run the Project:

In the IDE, run TestJDBC.java to test the database connectivity and user insertion functionality.
You should see the message "User added successfully!" in the console if everything is set up correctly.
Additional Information
This project is developed using Java, JDBC, and MySQL. The system is structured to allow easy integration with future modules like food donation tracking, user management, and delivery logistics.

Features:
User management with database connectivity.
Ability to test the connection and add users to the system.
Basic structure ready for future extensions.
Final Remarks
This project is just a starting point for the full system. The database design, along with the DAO pattern for database operations, forms the foundation.

For any assistance regarding the project contact on 9304971733 or ak2952001@Gmail.com to Abhishek Kumar.
Thank You for reading, Have a nice day!
