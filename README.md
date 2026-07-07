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
- Redis (In-Memory Cache)
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
 
### LOANS APIs:
- POST /api/loans/apply
- POST /api/loans/{id}/approve
- POST /api/loans/{id}/reject
- GET /api/loans/myloans?page=0&size=5
- GET /loan/{id}/history

# 6- Authentication
- This API uses JWT (JSON Web Token) authentication.
- Users authenticate by logging in with their credentials and receive a JWT access token.
- Users register via /api/users/register (default role: USER)
- Loan officers are created via "/api/users/register-officer endpoint"
- Role-based authorization is enforced:
  - `USER` can submit and view their own loan/loans Details .
  - `LOAN_OFFICER` can review, approve, or reject loan.
  
### 6.1- To access protected endpoints 
- include your JWT (JSON Web Token) in each request.
- Example using Postman:
- Select Authorization
- Choose Bearer Token
- Enter :
- Token : the Token you just received

# 7- Design Highlights
- can't access endpoints unless authenticated using JWT 
- Clean separation using DTOs
- Centralized exception handling
- Audit logging using LoanHistory
- Pagination implemented using Spring Data Page

# 8- Future Plans
- Add unit and integration tests
- Add role-based admin dashboard
