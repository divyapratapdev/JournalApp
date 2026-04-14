# JournalApp 📔

A backend API for personal journaling. 

I initially built this to practice mapping complex document structures, which made MongoDB the obvious choice over a relational DB. It evolved into a microservices-ready structure using Spring Boot 3.

## Architecture & Data Decisions

**Why MongoDB?**
Journal entries are inherently unstructured. Some entries have images, some have tags, some have mood indicators, and formatting can change drastically. Trying to force this into normalized Postgres tables meant constant schema migrations. MongoDB (`spring-boot-starter-data-mongodb`) handles the schema-less nature of journal documents effortlessly.

**Layered Design**
I kept the standard MVC layered architecture: `Controller` -> `Service` -> `Repository`. It's arguably overkill for a simple CRUD journal app, but it makes the codebase testable and sets a standard if this were to scale out.

## Stack
- Java 17
- Spring Boot 3.x
- Spring Data MongoDB
- Maven

## Setup & Run

Make sure you have MongoDB running locally on `localhost:27017`.

```bash
mvn clean install
mvn spring-boot:run
```

## Future Performance Improvements (Notes to self)

- **Pagination:** Right now, fetching all journals is a single `.findAll()` call. If a user has 1000 entries, this will choke. Need to implement Spring Data `Pageable` on the `/api/journals` GET endpoint.
- **Caching:** Journal entries rarely change after they are written. We should layer a Redis cache in front of the MongoDB fetch requests for read-heavy operations.
- **Security:** Add OAuth2 or JWT filters to ensure users only fetch their own documents. Right now the API assumes a single-tenant environment.