# First-Java-CRUD — Notes API

A simple Notes REST API built with Spring Boot, backed by SQLite, documented with Swagger/OpenAPI.

## Tech stack

- Java 17, Spring Boot 4.1.1 (Spring MVC)
- Spring Data JPA + Hibernate
- SQLite (`org.xerial:sqlite-jdbc`) via `hibernate-community-dialects`
- springdoc-openapi (Swagger UI)
- Bean Validation (`spring-boot-starter-validation`)

## RRunning the app

```bash
./mvnw spring-boot:run
```

Or build and run the jar:

```bash
./mvnw clean package
java -jar target/First-Java-CRUD-0.0.1-SNAPSHOT.jar
```

The app starts on `http://localhost:8080` and creates a `notes.db` SQLite file in the working directory on first run.

## API documentation

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON spec: http://localhost:8080/v3/api-docs

## Endpoints

Base path: `/api/notes`

| Method | Path              | Description          |
|--------|-------------------|-----------------------|
| GET    | `/api/notes`      | List all notes        |
| GET    | `/api/notes/{id}` | Get a note by id       |
| POST   | `/api/notes`      | Create a note          |
| PUT    | `/api/notes/{id}` | Update a note          |
| DELETE | `/api/notes/{id}` | Delete a note          |

### Request body (POST/PUT)

```json
{
  "title": "Groceries",
  "content": "Milk, eggs, bread"
}
```

`title` is required (non-blank); `content` is optional.

### Response body

```json
{
  "id": 1,
  "title": "Groceries",
  "content": "Milk, eggs, bread",
  "createdAt": "2026-10-19T18:35:53.819269Z",
  "updatedAt": "2026-10-19T18:35:53.819269Z"
}
```

## Error handling

- `400 Bad Request` — validation failure (e.g. blank title)
- `404 Not Found` — note id does not exist

Example error response:

```json
{
  "timestamp": "2026-10-19T18:35:54.362379Z",
  "status": 404,
  "error": "Not Found",
  "message": "Note not found with id: 1"
}
```

## Configuration

Key settings in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:sqlite:notes.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
```

## Project structure

```
src/main/java/rida/_79726/firstjavacrud/
├── FirstJavaCrudApplication.java
├── common/
│   └── GlobalExceptionHandler.java
└── note/
    ├── Note.java
    ├── NoteController.java
    ├── NoteNotFoundException.java
    ├── NoteRepository.java
    ├── NoteService.java
    └── dto/
        ├── NoteRequest.java
        └── NoteResponse.java
```
