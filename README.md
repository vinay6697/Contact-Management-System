# Contact Management System

## Overview

A Java-based Contact Management System developed using JDBC and PostgreSQL.

The application allows users to manage contacts through a menu-driven console application.

---

## Technologies Used

- Java
- JDBC
- PostgreSQL
- Maven
- Eclipse IDE
- Git & GitHub

---

## Features

- Add Contact
- Update Contact
- Delete Contact
- Find Contact By ID
- Find Contact By Name
- Find Contact By Email
- Find Contact By Mobile Number
- View All Contacts
- Count Total Contacts
- Export Contacts To File

---

## Project Structure

```text
src/main/java

entity
dao
service
util
main
```

## Database Table

```sql
CREATE TABLE contact_details
(
    contact_id SERIAL PRIMARY KEY,
    contact_name VARCHAR(100),
    email VARCHAR(100),
    mobile_number BIGINT,
    address VARCHAR(255),
    created_date TIMESTAMP
);
```

## Concepts Covered

- JDBC Connectivity
- CRUD Operations
- PreparedStatement
- ResultSet
- Exception Handling
- File Handling
- Layered Architecture
- PostgreSQL Integration

## How To Run

1. Clone the repository.
2. Create PostgreSQL database.
3. Execute table creation script.
4. Update database credentials in DatabaseConnection.java.
5. Run ContactManagementDriver.java.

## Future Enhancements

- Contact Categories
- Favorite Contacts
- Pagination
- Login System
- Import Contacts From File

## Author

Vinay
