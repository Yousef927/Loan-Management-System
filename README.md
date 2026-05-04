# 1- Project Overview
- Loan Management System API built with Spring Boot	

# 2- Features 
- User registration & authentication (Spring Security)
- Role-based access (USER, ADMIN , LOAN_OFFICER)
- Apply for loans
- Approve / reject loans
- Loan history tracking (audit system)
- Pagination & filtering
- Global exception handling
- Dockerized application

# 3- Tech Stack 
- Java / Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Docker / Docker Compose

# 4- How To Run
- install MAVEN from https://maven.apache.org/download.cgi
- add to enviroment variables
- run in terminal "mvn clean package -DskipTests" to generate .jar 
- run "docker compose up --build"

# 5- API Endpoints

### USER APIs:
- POST /api/users/register
- POST /api/users/register-officer
 
### USER APIs:
- POST /api/loans/apply
- POST /api/loans/{id}/approve
- POST /api/loans/{id}/reject
- GET /api/loans/myloans?page=0&size=5
- GET /loan/{id}/history

# 6- Authentication
- This API uses HTTP Basic Authentication
- Users register via /api/users/register (default role: USER)
- Loan officers are created via /api/users/register-officer endpoint
- Loan officers can approve/reject loans
  
### 6.1- To access protected endpoints 
- include your credentials (email and password) in each request.
- Example using Postman:
- Select Authorization
- Choose Basic Auth
- Enter :
- Username: your email
- Password: your password (encoded using Bcrypt)

# 7- Design Highlights
- can't access endpoints unless authenticated
- Clean separation using DTOs
- Centralized exception handling
- Audit logging using LoanHistory
- Pagination implemented using Spring Data Page

# 8- Future Plans
- Replace Basic Auth with JWT authentication
- Add unit and integration tests
- Add role-based admin dashboard
