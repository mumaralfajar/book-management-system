# Book Management System

This is a simple book management system built using Spring Boot, Lombok and PostgreSQL.

## Prerequisites

- Java 8 or higher
- Maven
- PostgreSQL

## Getting Started

1. Clone the repository
```
git clone https://github.com/yourusername/book-management-system.git
```

2. Navigate to the project directory
```
cd book-management-system
```

3. Update the `src/main/resources/application.properties` file with your PostgreSQL username, password and url.

4. Run the application
```
mvn spring-boot:run
```

The application will start and run on `http://localhost:8080`.

## API Endpoints

- `GET /books`: Fetch all books
- `GET /books/{id}`: Fetch a book by id
- `POST /books`: Add a new book
- `PUT /books/{id}`: Update a book
- `DELETE /books/{id}`: Delete a book

## Running Tests

To run the tests, use the following command:

```
mvn test
```

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Lombok](https://projectlombok.org/) - Java library that automatically plugs into your editor and build tools, spicing up your java.
- [PostgreSQL](https://www.postgresql.org/) - The database used

## Authors

- Your Name

## License

This project is licensed under the MIT License.