# AuthCore

AuthCore is a reusable, plug-and-play authentication microservice built with **Spring Boot 3.5+**, **JWT**, and **Refresh Tokens**. Designed for modern microservice and SaaS-based applications, it offers secure user authentication, token management, and extensibility.

---

## 🚀 Features

- ✅ User Registration & Login
- 🔐 JWT Access & Refresh Token Support
- 🛡️ Spring Security Integration
- 📚 Swagger (OpenAPI 3.0) Documentation
- 🧪 TDD-first Development with JUnit 5 & Mockito
- 💾 MySQL + JPA Persistence
- ⚙️ Easily Integratable into any Microservice Architecture
- 🧱 Modular Design for Reusability
- ☁️ Open Source Friendly

---

## 🏗️ Tech Stack

| Layer            | Technology                        |
|------------------|------------------------------------|
| Language         | Java 21                           |
| Framework        | Spring Boot 3.5.3                 |
| Auth Protocol    | JWT + Refresh Tokens              |
| Database         | MySQL                             |
| API Docs         | Swagger (springdoc-openapi)       |
| Testing          | JUnit 5, Mockito                  |
| Build Tool       | Maven                             |

---

## 📦 Project Structure

```bash
authcore/
├── config/           # Security, Swagger, etc.
├── controller/       # REST controllers
├── dto/              # Data Transfer Objects
├── entity/           # JPA Entities
├── repository/       # Database access
├── security/         # JWT filters, providers, config
├── service/          # Core business logic
└── util/             # Utility classes
```
## 🔧 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/shekhar396/authcore.git
cd authcore
```
## Set up MySQL
Create a database named authcore.

Update your application.yml:

```bash
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/authcore
    username: root
    password: yourpassword
```
### 3. Build the Project
```bash
./mvnw clean install
```

### 4. Run the Application
   ```bash
   ./mvnw spring-boot:run
  ```
The API will be available at:
```bash
   📍 http://localhost:8080
```

### 5. Access Swagger Docs
📖 Swagger UI:
```bash
   http://localhost:8080/swagger-ui.html
```
or
```bash
   http://localhost:8080/swagger-ui/index.html
```

### 🧪 Running Tests
```basht
./mvnw test
```
### 📘 API Endpoints (Sample)
| Method | Endpoint                | Description           |
| ------ | ----------------------- | --------------------- |
| POST   | `/api/v1/auth/register` | Register a new user   |
| POST   | `/api/v1/auth/login`    | Login with JWT        |
| POST   | `/api/v1/auth/refresh`  | Refresh access token  |
| GET    | `/api/v1/auth/profile`  | Authenticated profile |


👨‍💻 Contributing
We welcome contributions from everyone!

Quick Start
Fork this repo

Create your feature branch: git checkout -b feature/YourFeature

Commit your changes: git commit -m 'Add some feature'

Push to the branch: git push origin feature/YourFeature

Open a pull request

📂 Issues & Roadmap
Check the Issues Tab for:

Bugs

Feature Requests

Good First Issues

Upcoming roadmap will be added in ROADMAP.md.

📄 License
This project is licensed under the MIT License — see the LICENSE file for details.

✨ Author
Built with 💚 by Shekhar and community.

💬 Feedback
Suggestions, bugs, or feature requests?
Please open an issue or start a discussion!

