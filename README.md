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
   |:---- |:---- |:---- |:----|
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

******************************************************************************************************************
**DTS Task Manager – User Guide**
   The DTS Task Manager is a simple tool to create, edit, and manage tasks.
   It works entirely online, with your data stored in a secure cloud database.

**Accessing the Application**
   URL:
   https://dts-task-frontend.vercel.app

   You can use the app from any device with internet access.

**Main Interface Overview**
   When you open the app, you will see:
   1. Task Form (top of the page) – for creating or editing tasks.
   2. Task List (below) – shows all your tasks.
   3. Status Selector – quickly update the task’s status.

**How to Use**
   1. Creating a New Task
   Go to the form at the top of the page.

   2. Fill in:
   - Title – short name for the task (required).
   - Description – extra details (optional).
   - Due Date & Time – when the task should be completed (required).
   - Click "Create Task".

    If any required fields are missing, error messages will appear in red.

**Editing a Task**
   1. Find the task in the list.
   2. Click "Edit".
   3. The task information will appear in the form.
   4. Change what you need, then click "Update Task".
   5. If you change your mind, click "Cancel".

**Deleting a Task**
   1. Find the task in the list.
   2. Click the "Delete" button.
   3. The task will be removed permanently.

**Changing Task Status**
   1. Find the task in the list.
   2. Use the dropdown menu under Status.
   3. Choose one of:
      - Pending
      - In Progress
      - Done
   The update happens instantly.

**Validation Rules**
   The backend checks:
   - Title cannot be empty.
   - Due Date & Time must be in the future.
   - If invalid, an error message is returned and displayed below the input.

**Example Use Cases**
- Plan a meeting:
Title: "Team Meeting"
Description: "Discuss quarterly goals"
Due: 2025-08-20 14:00
Status: Pending

- Track bug fixes:
Title: "Fix Payment Gateway"
Description: "Resolve timeout error during checkout"
Due: 2025-08-15 18:00
Status: In Progress

- Organize personal tasks:
Title: "Buy Groceries"
Description: "Milk, Bread, Eggs"
Due: 2025-08-12 17:00
Status: Pending

**Tips**
- You can update status without editing the task.
- Dates and times adjust to your local timezone automatically.
- Refresh the page if you think tasks are not updating.