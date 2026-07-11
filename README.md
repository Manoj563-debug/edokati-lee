# Employee Management System

Enterprise-level Full Stack Employee Management System built using **Spring Boot**, **React.js**, and **MySQL**. This application provides a centralized platform to manage employees, departments, projects, and performance reviews through RESTful APIs with a modern, responsive user interface.

---

## Project Overview

Managing employee information, department records, project assignments, and performance reviews manually becomes increasingly difficult as an organization grows. This project was developed to provide a centralized, scalable, and maintainable solution for handling day-to-day employee management operations.

The application follows a layered architecture using Spring Boot for the backend and React.js for the frontend. It enables administrators to efficiently perform CRUD operations, assign employees to projects, maintain department information, and track employee performance.

---

## Key Features

### Employee Management

- Create new employees
- Update employee information
- Delete employees
- View employee details
- Search employees using REST APIs

### Department Management

- Create departments
- Update department information
- Delete departments
- Manage department budgets
- Assign employees to departments

### Project Management

- Create projects
- Update project details
- Assign employees to multiple projects
- Track project status

### Performance Review Management

- Record employee performance reviews
- Maintain ratings and feedback
- Track review history

### Dashboard

- Total Employees
- Total Departments
- Total Projects
- Average Salary
- Employees by Department Chart
- Employees by Designation Chart
- Recently Joined Employees

---

## Technology Stack

### Backend

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- Maven

### Frontend

- React.js
- Vite
- Bootstrap 5
- Axios
- React Router DOM

### Database

- MySQL

### Development Tools

- Eclipse IDE
- Visual Studio Code
- Git
- GitHub
- Postman

---

## System Architecture

The application follows a layered architecture to ensure maintainability, scalability, and separation of concerns.

```
React.js Frontend
        │
        ▼
 REST APIs (Spring Boot)
        │
        ▼
 Service Layer
        │
        ▼
 Repository Layer (Spring Data JPA)
        │
        ▼
     MySQL Database
```

---

## Project Structure

```
Employee-Management-System
│
├── employee-management-system-backend
│   ├── src/main/java
│   ├── src/main/resources
│   ├── pom.xml
│   └── mvnw
│
├── employee-management-system-frontend
│   ├── src
│   ├── public
│   ├── package.json
│   └── vite.config.js
│
├── docs
│   └── images
│
└── README.md
```

---

## Project Modules

### Employee Module

- Create Employee
- Update Employee
- Delete Employee
- View Employee Details
- Search Employee

---

### Department Module

- Create Department
- Update Department
- Delete Department
- Department Budget Management

---

### Project Module

- Create Project
- Assign Employees
- Update Project
- Delete Project
- Track Project Status

---

### Performance Review Module

- Create Reviews
- Update Reviews
- Delete Reviews
- Employee Rating Management

---

## Application Screenshots

### Dashboard

![Dashboard](docs/images/dashboard.png)

---

### Employee Management

![Employees](docs/images/employees.png)

---

### Add Employee

![Add Employee](docs/images/add-employee.png)

---

### Department Management

![Departments](docs/images/departments.png)

---

### Add Department

![Add Department](docs/images/add-department.png)

---

### Project Management

![Projects](docs/images/projects.png)

---

### Add Project

![Add Project](docs/images/add-project.png)

---

### Performance Review Management

![Performance Reviews](docs/images/reviews.png)

---

### Add Performance Review

![Add Review](docs/images/add-review.png)

## Installation Guide

Follow the steps below to run the project on your local machine.

### Prerequisites

Make sure the following software is installed before running the application:

- Java 21 (JDK)
- Node.js (LTS Version)
- MySQL Server 8.x
- Apache Maven
- Git
- Eclipse IDE or IntelliJ IDEA (Backend)
- Visual Studio Code (Frontend)

---

## Clone the Repository

```bash
git clone https://github.com/niranjanhr27/Employee-Management-System.git
```

Move into the project directory.

```bash
cd Employee-Management-System
```

---

## Backend Setup

Navigate to the backend project.

```bash
cd employee-management-system-backend
```

### Step 1: Create MySQL Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE employee_db;
```

---

### Step 2: Configure Database

Open:

```
src/main/resources/application.properties
```

Update your MySQL configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

### Step 3: Run the Backend

```bash
mvn spring-boot:run
```

The backend server starts at:

```
http://localhost:8080
```

---

## Frontend Setup

Open another terminal.

Navigate to the frontend project.

```bash
cd employee-management-system-frontend
```

Install dependencies.

```bash
npm install
```

Start the React application.

```bash
npm run dev
```

The frontend will start at:

```
http://localhost:5173
```

---

## Verify the Application

Backend API

```
http://localhost:8080/employees
```

Frontend

```
http://localhost:5173
```

If both URLs open successfully, the project has been configured correctly.

## REST API Overview

The backend exposes RESTful APIs for managing employees, departments, projects, and performance reviews.

### Employee APIs

- Create Employee
- Get All Employees
- Get Employee By ID
- Update Employee
- Delete Employee
- Get Employee By Name
- Get Employee By Designation
- Get Employee By Name And Salary
- Get Employees By Salary Greater Than
- Get Employees By Salary Between
- Find Employees By Department Name
- Get Projects By Employee ID

---

### Department APIs

- Create Department
- Get All Departments
- Get Department By ID
- Update Department
- Delete Department

---

### Project APIs

- Create Project
- Get All Projects
- Get Project By ID
- Update Project
- Delete Project
- Find Projects By Status
- Get Employees Of Project
- Get Projects By Employee ID
- Assign Employee To Project

---

### Performance Review APIs

- Create Review
- Get All Reviews
- Get Review By ID
- Update Review
- Delete Review
- Find Reviews By Rating Greater Than
- Find Reviews By Review Date Between

## Highlights

- Layered Architecture
- DTO Pattern
- Entity Relationships
- Spring Data JPA
- Hibernate ORM
- Exception Handling
- Validation
- RESTful API Design
- Responsive User Interface
- Dashboard with Charts
- Modular Code Structure

---

## Developer

**Niranjan H R**

Java Full Stack Developer (Fresher)

### Technical Skills

- Java
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- React.js
- JavaScript
- Bootstrap 5
- MySQL
- REST APIs
- Git & GitHub

GitHub:
https://github.com/niranjanhr27

## Acknowledgement

This project was developed as part of my Java Full Stack internship training. It provided hands-on experience in building a full-stack web application using Spring Boot, React.js, MySQL, and RESTful APIs.

While the project was assigned during training, I worked on understanding the architecture, implementing features, integrating the frontend and backend, debugging issues, testing the application, improving the project documentation, and organizing the GitHub repository to follow professional development practices.
