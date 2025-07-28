# Student Manager

A Spring Boot web application for managing student records with a beautiful Bootstrap UI.

## Features

- ✅ **CRUD Operations**: Create, Read, Update, Delete students
- ✅ **Form Validation**: Client and server-side validation
- ✅ **Modern UI**: Bootstrap 5 responsive design
- ✅ **Email Validation**: Strict email format validation
- ✅ **REST API**: JSON endpoint for student data

## Tech Stack

- **Backend**: Spring Boot 3.2.5
- **Frontend**: Thymeleaf + Bootstrap 5
- **Validation**: Jakarta Validation
- **Build Tool**: Maven

## Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Running the Application

1. **Clone the repository**
   ```bash
   git clone https://github.com/kajalsatija1997/spring-boot-student-mvc.git
   cd student-manager
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Open browser: `http://localhost:8080`
   - API endpoint: `http://localhost:8080/api/students`

## Project Structure

```
src/main/java/com/kajal/studentmvc/
├── controller/StudentController.java
├── model/Student.java
├── service/
│   ├── StudentService.java
│   └── StudentServiceImpl.java
└── StudentMvcApplication.java

src/main/resources/templates/
├── list.html
├── add.html
├── edit.html
└── view.html
```

## API Endpoints

- `GET /students` - List all students
- `GET /students/add` - Show add form
- `POST /students/add` - Add new student
- `GET /students/edit/{id}` - Show edit form
- `POST /students/edit` - Update student
- `GET /students/delete/{id}` - Delete student
- `GET /api/students` - JSON API endpoint

## Validation Rules

- **Name**: Required, 2-50 characters
- **Age**: Required, 1-120 years
- **Email**: Required, valid format, max 100 characters 
