# 🏨 Hotel Management System

A console-based **Hotel Management System** developed in **Java** using **JDBC** and **MySQL**. This project allows users to manage hotel room reservations through a menu-driven interface and demonstrates CRUD operations with a relational database.

## 🚀 Features

* ➕ Create a new reservation
* 📋 View all reservations
* ✏️ Update an existing reservation
* ❌ Delete a reservation
* 🔍 Get reservation details by ID
* 💾 Data stored in a MySQL database
* 🔒 Uses **PreparedStatement** to prevent SQL Injection attacks

## 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* IntelliJ IDEA
* MySQL Connector/J

## 📂 Project Structure

```
HotelManagementSystem/
│── src/
│   └── hotelManagement.java
│── README.md
```

## 🗄️ Database

Database Name:

```
hotel_data
```

Table:

```
reservations
```

Example columns:

* reservation_Id
* cust_Name
* room_no
* mob_No
* aadhaar_No
* reservation_Date

## ⚙️ How to Run

1. Clone the repository.
2. Create the MySQL database and the `reservations` table.
3. Update the database credentials in the source code.

```java
String url = "jdbc:mysql://localhost:3306/hotel_data";
String username = "your_username";
String password = "your_password";
```

4. Add the MySQL JDBC Driver to the project.
5. Run `hotelManagement.java`.

## 📌 Menu

```
1. New Reservation
2. View Reservations
3. Update Reservation
4. Delete Reservation
5. Get Reservation Details
0. Exit
```

## 🔒 Security Improvement

This project originally used the JDBC `Statement` interface. It has now been upgraded to use **PreparedStatement** for all database operations.

Benefits of using `PreparedStatement`:

* Protects against SQL Injection attacks
* Executes parameterized queries safely
* Improves code readability
* Can improve performance when executing similar queries repeatedly

## 📚 JDBC Concepts Demonstrated

* JDBC Driver Loading
* Database Connection
* PreparedStatement
* ResultSet
* CRUD Operations
* Exception Handling
* Menu-driven Console Application

## 🎯 Future Improvements

* Room availability checking
* Input validation for mobile number and Aadhaar
* Search reservations by customer name
* Login/Admin authentication
* Billing and invoice generation
* Layered architecture using DAO
* Spring Boot REST API version

## 👨‍💻 Author

**Supragya Rai**

If you found this project helpful, feel free to ⭐ the repository.
