# DTS Task Manager - Backend (Java + Spring Boot)

This is the backend for a simple task management system for caseworkers, built with Java and Spring Boot.

## 🚀 How to Run

1. **Clone the repository:**
   git clone https://github.com/christianecheverryp/dts-task-backend-java.git

2. **Build and start the backend**
   mvn spring-boot:run

   By default, the backend runs at http://localhost:8080

3. **Main API Endpoints**
   | Method | Endpoint | Description |
   | ------ | -------------------- | --------------------------- |
   | POST | `/tasks`             | Create a new task |
   | GET | `/tasks`             | Get all tasks |
   | GET | `/tasks/{id}`        | Get a task by ID |
   | PATCH | `/tasks/{id}/status` | Update the status of a task |
   | DELETE | `/tasks/{id}`        | Delete a task |

   Example - Create a task
   {
   "title": "Prepare report",
   "description": "Monthly summary for HR",
   "status": "PENDING",
   "dueDateTime": "2024-08-10T17:00:00"
   }

   Example - Update Status
   {
   "status": "DONE"
   }

4. **Database**
   Uses H2 in-memory database for development (all data is cleared on restart).

5. **Testing**
    You can test all the endpoints using Swagger UI or Postman

6. **Documentation**
   Swagger UI available at:
   http://localhost:8080/swagger-ui.html