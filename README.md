# DTS Task Backend (Java + Spring Boot)

This repository contains the backend API for the **DTS Task Manager** application.  
It is built with **Java Spring Boot**, uses **PostgreSQL** for data storage, and is deployed on **Railway**.  
The backend handles all task-related operations, including **creation, retrieval, updating, deletion, and status changes**, as well as **validation**.

---

## 🚀 Tech Stack
- Java 17+
- Spring Boot 3
- PostgreSQL (Railway)
- Hibernate / JPA
- Jakarta Bean Validation
- CORS enabled for frontend hosted on Vercel

## 🚀 How to Run

1. **Clone the repository:**
   git clone https://github.com/christianecheverryp/dts-task-backend-java.git

2. **Build and start the backend**
   mvn spring-boot:run

   By default, the backend runs at http://localhost:8080

3. **Main API Endpoints**
   |Method	|Endpoint	  |Description	    |Body Example
   |GET	    |/tasks	      |List all tasks	| —
   |GET	    |/tasks/{id}  |Get task by ID   | —
   |POST    |/tasks       |Create new task  |{ "title": "Prepare Report", "description": "Monthly HR report", "dueDateTime": "2025-09-01T09:00:00", "status": "PENDING" }
   |PUT     |/tasks/{id}  |Update task      |same as POST
   |PATCH   |/tasks/{id}  |/status          |Update only task status |{ "status": "DONE" }
   |DELETE  |/tasks/{id}  |Delete a task	| —

4. **Validation Rules**
- title: Required, 1–100 characters
- description: Optional, max 255 characters
- status: Required, must be PENDING, IN_PROGRESS, or DONE
- dueDateTime: Required, must be today or a future date

   If validation fails, API returns HTTP 400 with a JSON object:
{
"title": "Title cannot be blank",
"dueDateTime": "Due date must be today or in the future"
}

5. **CORS Configuration**
    CORS is configured to allow requests from:
    https://dts-task-frontend.vercel.app
    This allows the React frontend to communicate with the backend without CORS issues.

6. **Example Requests**
   {
   "title": "Team Meeting",
   "description": "Discuss Q3 roadmap",
   "dueDateTime": "2025-08-20T14:00:00",
   "status": "PENDING"
   }

   Update Status:
   '{"status":"DONE"}'

5. **Testing**
    You can test all the endpoints using Swagger UI or Postman

6. **Documentation**
   Swagger UI available at:
   http://localhost:8080/swagger-ui.html

7. **Deployment**
   This project is deployed on Railway.
   When changes are pushed to the main branch, Railway automatically builds and deploys the application.

   Production URL:
   https://dts-task-backend-java-production.up.railway.app