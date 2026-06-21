# 🏨 Hotel Management System

A Java Swing and MySQL based Hotel Management System designed to manage hotel rooms efficiently. This project provides room management features such as adding, updating, deleting, and viewing rooms with a user-friendly desktop interface.

## 🚀 Features

### Room Management

* Add New Room
* Update Existing Room
* Delete Room
* View All Rooms
* Auto-generated Room ID
* Room Status Management (Available / Occupied)

### User Interface

* Java Swing GUI
* JTable for Room Records
* Form Validation
* Interactive Buttons
* Clean and Simple Layout

### Database

* MySQL Database
* JDBC Connectivity
* CRUD Operations
* Real-time Data Loading

---

## 🛠 Technologies Used

* Java
* Java Swing
* JDBC
* MySQL
* VS Code
* Git & GitHub

---

## 📂 Project Structure

```text
HotelManagementSystem
│
├── src
│   ├── db
│   │   └── DBConnection.java
│   │
│   ├── dao
│   │   └── RoomDAO.java
│   │
│   ├── model
│   │   └── Room.java
│   │
│   ├── ui
│   │   └── ManageRoomsFrame.java
│   │
│   └── TestUI.java
│
├── lib
│   └── mysql-connector-j.jar
│
└── README.md
```

---

## 🗄 Database Setup

Create Database:

```sql
CREATE DATABASE hotel_management;
USE hotel_management;
```

Create Rooms Table:

```sql
CREATE TABLE rooms(
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_no VARCHAR(20) UNIQUE,
    room_type VARCHAR(50),
    price DECIMAL(10,2),
    status VARCHAR(20)
);
```

---

## ⚙ Configuration

Update database credentials in:

```java
DBConnection.java
```

```java
private static final String URL =
"jdbc:mysql://localhost:3306/hotel_management";

private static final String USER = "root";

private static final String PASSWORD = "your_password";
```

---

## ▶ Running the Project

Compile:

```bash
javac -cp ".;lib/*" src\db\DBConnection.java src\model\Room.java src\dao\RoomDAO.java src\ui\ManageRoomsFrame.java src\TestUI.java
```

Run:

```bash
java -cp ".;lib/*;src" TestUI
```

---

## 📸 Current Modules

* ✅ Database Connectivity
* ✅ Room Management
* ✅ Add Room
* ✅ Update Room
* ✅ Delete Room
* ✅ View Rooms
* ✅ JTable Integration

---

## 🔮 Future Enhancements

* Customer Management
* Room Booking
* Check-In / Check-Out
* Billing System
* Reports Dashboard
* Login & Authentication
* Spring Boot REST APIs
* PDF Invoice Generation

---

## 👨‍💻 Author

**Aadarsh Ranjan**

Built as a Java + MySQL learning project to understand desktop application development, database integration, and CRUD operations.

<img width="1232" height="811" alt="Screenshot 2026-06-21 123143" src="https://github.com/user-attachments/assets/af52fe5e-abd1-4809-9f34-3062043243f0" />

