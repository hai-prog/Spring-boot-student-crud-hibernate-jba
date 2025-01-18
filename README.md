# Spring Boot Student CRUD with Hibernate

## Overview
This project is a **Student Management System** built using **Spring Boot**, **Hibernate**, and **MySQL**. It demonstrates **CRUD (Create, Read, Update, Delete)** operations for managing student records. The project also includes **exception handling** to ensure robust error management.

## Features
- **CRUD Operations**: Create, retrieve, update, and delete student records.
- **Database Integration**: Uses **Hibernate** for ORM (Object-Relational Mapping) and **MySQL** for data storage.
- **Exception Handling**: Custom exception handling for invalid requests or database errors.
- **RESTful API**: Exposes endpoints for interacting with the student management system.

## Technologies Used
- **Java**
- **Spring Boot**
- **Hibernate**
- **MySQL**
- **REST APIs**
- **Maven** (for dependency management)

## How to Run the Project
Follow these steps to set up and run the project locally:

### Prerequisites
- **Java JDK 11 or higher**
- **MySQL Server** (or any relational database)
- **Maven** (for building the project)
- **Postman** (or any API testing tool)

### Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/hai-prog/spring-boot-student-crud-hibernate-jba.git

   ## Set Up the Database

2. **Create a MySQL database** named `student_db`.
3. **Update the `application.properties` file** with your database credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

 4. **Build the project using Maven:**
    ```bash
    mvn clean install
    ```

5. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

6. **Access the API:**
  
The application will run on http://localhost:8080. Use the following endpoints to interact with the API:

HTTP Method	Endpoint	Description
POST	/api/students	Add a new student
GET	/api/students	Retrieve all students
GET	/api/students/{id}	Retrieve a student by ID
PUT	/api/students/{id}	Update a student by ID
DELETE	/api/students/{id}	Delete a student by ID
Test the API

7. **Use Postman or any API testing tool to test the endpoints.**

