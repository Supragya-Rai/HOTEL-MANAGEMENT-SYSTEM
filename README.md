# Hotel Management System

## Overview

A console-based Hotel Management System developed using Java, JDBC, and MySQL. This application allows hotel staff to manage reservations through a simple menu-driven interface. The project demonstrates database connectivity, CRUD operations, SQL query execution, and basic database management using JDBC.

---

## Features

### Reservation Management

* Create a new reservation
* View all reservations
* Update existing reservations
* Delete reservations
* Search reservation details by Reservation ID

### Database Operations

* MySQL database integration using JDBC
* Insert, Read, Update, and Delete (CRUD) functionality
* Automatic reservation date tracking
* Persistent data storage

### Additional Functionality

* Menu-driven console interface
* Input validation
* Database connectivity handling
* Load testing experiments using multithreading

---

## Tech Stack

* Java
* JDBC (Java Database Connectivity)
* MySQL
* IntelliJ IDEA

---

## Database Schema

### Database

```sql
CREATE DATABASE hotel_data;
```

### Reservations Table

```sql
CREATE TABLE reservations (
    reservation_Id INT AUTO_INCREMENT PRIMARY KEY,
    room_no INT NOT NULL,
    cust_Name VARCHAR(100) NOT NULL,
    mob_No VARCHAR(15) NOT NULL,
    aadhaar_No VARCHAR(20) NOT NULL,
    reservation_Date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## Project Structure

```text
HotelManagementSystem/
│
├── hotelManagement.java
├── database.sql
├── README.md
└── mysql-connector-j.jar
```

---

## Installation and Setup

### 1. Clone the Repository

```bash
[git clone <repository-url>
cd HotelManagementSystem](https://github.com/Supragya-Rai/HOTEL-MANAGEMENT-SYSTEM.git)
```

### 2. Create the Database

Open MySQL and execute:

```sql
CREATE DATABASE hotel_data;

USE hotel_data;

CREATE TABLE reservations (
    reservation_Id INT AUTO_INCREMENT PRIMARY KEY,
    room_no INT NOT NULL,
    cust_Name VARCHAR(100) NOT NULL,
    mob_No VARCHAR(15) NOT NULL,
    aadhaar_No VARCHAR(20) NOT NULL,
    reservation_Date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 3. Configure Database Credentials

Update the following values in the source code:

```java
public static final String url =
        "jdbc:mysql://localhost:3306/hotel_data";

public static final String username = "root";
public static final String password = "Supragya2006";
```

### 4. Add MySQL JDBC Driver

Add MySQL Connector/J to your project dependencies.

### 5. Run the Application

Execute:

```bash
java hotelManagement
```

---

## Menu Options

```text
1. New Reservation
2. View Reservations
3. Update Reservations
4. Delete Reservations
5. Get Details
0. Exit
```

---

## Sample Output

```text
Welcome to Hotel Management System!!!

1. New Reservation
2. View Reservations
3. Update Reservations
4. Delete Reservations
5. Get Details
0. Exit

Enter Your Choice:
```

---

## Learning Outcomes

This project helped in understanding:

* JDBC Architecture
* MySQL Database Integration
* SQL Queries
* CRUD Operations
* Exception Handling
* Java Multithreading
* Database Load Testing
* Connection Management

---

## Future Improvements

* PreparedStatement implementation
* User authentication system
* Room availability checking
* Check-in and Check-out management
* Payment module
* Spring Boot REST API
* Web-based frontend
* Connection pooling using HikariCP
* Role-based access control
* Docker deployment

---

## Author

Developed by Supragya Rai as a Java JDBC project to learn database connectivity and backend development concepts.
