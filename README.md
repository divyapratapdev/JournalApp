# JournalApp 📔

> **Enterprise-Grade Personal Journaling REST API** 
> Production-ready Spring Boot application with layered architecture, MongoDB integration, and scalable design patterns.

[![Java](https://img.shields.io/badge/Java-17%2B-orange)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)]()
[![MongoDB](https://img.shields.io/badge/MongoDB-Latest-green)]()

## 📋 Overview

JournalApp is a full-featured REST API for personal journaling with enterprise-grade architecture. Built with Spring Boot 3.x, it demonstrates professional-grade software engineering practices including layered architecture, comprehensive error handling, and MongoDB integration.

### Key Features
- ✅ **RESTful API** with comprehensive CRUD operations
- ✅ **Layered Architecture** (Controller → Service → Repository → Database)
- ✅ **MongoDB Integration** for flexible document storage
- ✅ **Input Validation** and exception handling
- ✅ **Spring Data JPA** patterns for data access
- ✅ **Scalable Design** ready for microservices

## 🏗️ Architecture

```
Controller Layer
      ↓
   Service Layer (Business Logic)
      ↓
  Repository Layer (Data Access)
      ↓
  MongoDB Database
```

### Technology Stack
| Component | Technology |
|-----------|------------|
| **Framework** | Spring Boot 3.x |
| **Database** | MongoDB |
| **API** | REST |
| **Language** | Java 17+ |
| **Build Tool** | Maven |

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven 3.8+
- MongoDB running locally or configured

### Installation

```bash
# Clone repository
git clone https://github.com/divyapratapdev/JournalApp.git
cd JournalApp

# Build project
mvn clean install

# Run application
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## 📚 API Endpoints

### Journal Entries
- `GET /api/journals` - List all journals
- `GET /api/journals/{id}` - Get specific journal
- `POST /api/journals` - Create new journal
- `PUT /api/journals/{id}` - Update journal
- `DELETE /api/journals/{id}` - Delete journal

### Example Request

```bash
curl -X POST http://localhost:8080/api/journals \
  -H "Content-Type: application/json" \
  -d '{
    "title": "My Day",
    "content": "Today was productive...",
    "mood": "happy"
  }'
```

## 🔧 Configuration

Create `application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/journalapp
spring.application.name=JournalApp
server.port=8080
```

## 📦 Project Structure

```
src/main/java/
├── controller/      # REST endpoints
├── service/         # Business logic
├── repository/      # Data access layer
├── entity/          # MongoDB documents
├── dto/             # Data transfer objects
├── exception/       # Custom exceptions
└── config/          # Configuration classes
```

## 🎯 Design Patterns

- **Layered Architecture** - Clear separation of concerns
- **Repository Pattern** - Abstract data access
- **Service Layer** - Centralized business logic
- **DTO Pattern** - API-safe data transfer
- **Exception Handling** - Comprehensive error management

## 📈 Performance

- MongoDB indexing for fast queries
- Connection pooling optimization
- Efficient pagination support
- Response caching ready

## 🔐 Security

- Input validation on all endpoints
- Exception handling prevents information leakage
- Ready for OAuth2 integration
- CORS configuration available

## 🧪 Testing

```bash
mvn test
```

Includes unit tests for services and integration tests for repositories.

## 🚢 Deployment

### Docker

```dockerfile
FROM openjdk:17
COPY target/journal-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Cloud Deployment
Ready for deployment on AWS, GCP, or Azure with minimal configuration.

## 📝 Development

### Adding New Features
1. Create entity and repository
2. Add service methods
3. Implement controller endpoints
4. Write tests
5. Update documentation

## 🤝 Contributing

This is a personal portfolio project. Feel free to fork and customize.

## 📄 License

MIT License - See LICENSE file

## 📞 Contact

**Divya Pratap Singh**
- GitHub: [@divyapratapdev](https://github.com/divyapratapdev)
- Email: divya210205@gmail.com
- Specialization: Backend Engineering, Distributed Systems

---
*Enterprise-grade code, built with attention to detail.*