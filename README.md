# Spring Boot User Management REST API

Built for **Module 05: Java Web & REST API Development** in the Codomax Digital Solutions Java Development Internship.

## Endpoints (`/api/users`)
- `POST /api/users` — Create user (validated JSON body)
- `GET /api/users` — List all users
- `GET /api/users/{id}` — Fetch user by ID (returns `404` if missing)
- `PUT /api/users/{id}` — Update user details
- `DELETE /api/users/{id}` — Delete user (`204 No Content`)

## Run
```bash
mvn spring-boot:run
