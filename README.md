# Online Course Demo App

## Assumption
1. There are 2 kind of account. The first one is Admin. The second one is User.
2. Account with role Admin have capability to create course & search course
3. Account with role User have capability to search course

## How to Run Locally
1. Clone this project
2. Adjust the config value on `application.properties` especially for a database & redis properties
3. Run DML of Master Data
4. Go to root directory of this project and type `mvn clean install -DskipTests`
5. Run the application using command `mvn spring-boot:run`

## API Endpoint
1. API Register User (POST /api/auth/)
   Curl Example:
   `
   curl --location --request POST 'localhost:8080/api/auth/signup' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "username": "aleem.btech",
   "email": "aleem.btech@gmail.com",
   "password": "Test123",
   "role": [
   "admin", "user"
   ]
   }'
   `
2. API Signin (POST /api/auth/)
   Curl Example:
   `
   curl --location --request POST 'localhost:8080/api/auth/signin' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "username": "aleem.btech",
   "password": "Test123"
   }'
   `
3. API Create course (POST /api/courses)
   Curl example:
   `
   curl --location --request POST 'localhost:8080/api/courses' \
   --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYW5kYXpreSIsImlhdCI6MTYzMjAzODYyMCwiZXhwIjoxNjMyMTI1MDIwfQ.XlJ3qsu0YeKbtW1jNVHuBvsRtvz12KUvmvDrbrWRZgPqNL6U5PsB5pCVPzObIPiZ10xzJ2L8y_hx78EWKSt9EA' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "title": "Full Stack Development",
   "image": "",
   "hourCount": 5,
   "price": 1399000,
   "description": "Learn Full Stack",
   "content": "Analyze and understand both frontend and backend technologies",
   "categoryId": 1
   }'
   `
4. API Search course (GET /api/course?keyword=$keyword)
   Curl Example:
   `
   curl --location --request GET 'localhost:8080/api/courses?keyword=kubernetes' \
   --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYW5kYXpreSIsImlhdCI6MTYzMjAzODYyMCwiZXhwIjoxNjMyMTI1MDIwfQ.XlJ3qsu0YeKbtW1jNVHuBvsRtvz12KUvmvDrbrWRZgPqNL6U5PsB5pCVPzObIPiZ10xzJ2L8y_hx78EWKSt9EA'
   `

## DML Master Data
`
INSERT INTO categories (icon, name)
VALUES ('https://myEdTech.com/courses/IT/icon/software.png', 'IT & Software'),
('https://myEdTech.com/courses/IT/icon', 'Finance & Accounting');
`

`
INSERT INTO roles (name)
VALUES ('ROLE_USER'),('ROLE_ADMIN')
`