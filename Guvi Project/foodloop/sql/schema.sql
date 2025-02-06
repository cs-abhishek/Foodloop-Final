
CREATE DATABASE IF NOT EXISTS foodloop;

USE foodloop;

CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address TEXT NOT NULL,
    role ENUM('user', 'admin', 'delivery') NOT NULL
);

CREATE TABLE IF NOT EXISTS donations (
    donation_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    food_type VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    status ENUM('pending', 'accepted', 'delivered') DEFAULT 'pending',
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS requests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    donation_id INT NOT NULL,
    admin_id INT NOT NULL,
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending',
    FOREIGN KEY (donation_id) REFERENCES donations(donation_id),
    FOREIGN KEY (admin_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS deliveries (
    delivery_id INT AUTO_INCREMENT PRIMARY KEY,
    request_id INT NOT NULL,
    delivery_person_id INT NOT NULL,
    pickup_location TEXT NOT NULL,
    drop_location TEXT NOT NULL,
    delivery_status ENUM('pending', 'in-transit', 'completed') DEFAULT 'pending',
    FOREIGN KEY (request_id) REFERENCES requests(request_id),
    FOREIGN KEY (delivery_person_id) REFERENCES users(user_id)
);
