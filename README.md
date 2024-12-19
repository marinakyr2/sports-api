The Sports API is a Java-based backend application designed to provide sports-related data through a RESTful API. It allows users to retrieve information about sports, teams, events, and statistics in a structured and efficient manner. The API is implemented using the Spring Boot framework, ensuring a modular and scalable architecture for managing sports data.

## Key Features

- *Retrieve Sports Data*: Access information about various sports, teams, and players.  
- *Real-Time Statistics*: Retrieve up-to-date scores and performance statistics.  
- *Multi-Sport Support*: Includes support for multiple sports and leagues.  
- *RESTful Endpoints*: Provides a standardized interface for easy integration with frontend or external applications.  
- *Database Integration*: Manages and retrieves data through a relational database using JPA (Java Persistence API).  
- *Error Handling*: Implements structured exception handling for robust API responses.  

## Technologies Used

- *Java 17*: The programming language used to build the backend logic and API controllers.  
- *Spring Boot*: Provides an opinionated framework for RESTful API development, dependency injection, and microservice architecture.  
- *Maven*: Dependency management and project build system.  
- *Spring Data JPA*: Simplifies database interactions and supports entity management.  
- *H2 Database*: Used as an in-memory database for development and testing purposes.  
- *Docker*: Used for containerizing the application to streamline deployment.  

## Prerequisites

To set up and run the project, ensure you have the following installed on your system:  
- Java Development Kit (JDK) version 11 or higher.  
- Apache Maven for building the application.  
- Docker (optional, for running the application in a containerized environment).  

## Project Structure

The repository is organized into the following directories:  

- *src/main/java*: Contains the core application code.  
  - *controllers*: REST controllers to define API endpoints and handle HTTP requests.  
  - *services*: Business logic layer responsible for processing data and coordinating between the controllers and repositories.  
  - *repositories*: Interface layer for database interactions using Spring Data JPA.  
  - *models*: POJOs (Plain Old Java Objects) that define the entities mapped to database tables.  
  - *config*: Configuration files for setting up application properties and database connections.  

- *src/main/resources*: Contains application configurations and static resources.  
  - *application.properties*: Configuration file for database and server settings.  
  - *schema.sql*: SQL script to initialize the database schema.  
  - *data.sql*: SQL script to populate the database with initial data.  

- *test*: Contains unit and integration tests for various application components.  

## Installation Instructions

1. *Clone the Repository*:  
   Clone the repository to your local machine using:  
   ```bash
   git clone https://github.com/marinakyr2/sports-api.git
   cd sports-api

   Build the Project:
Use Maven to compile the source code and resolve dependencies:

bash

mvn clean install
## Run the Application:
Launch the application using Maven:

bash
mvn spring-boot:run
The API will be accessible at http://localhost:8080.

## Database Access:
The application uses an H2 in-memory database. To access the H2 console for testing or debugging, navigate to:
http://localhost:8080/h2-console
Use the JDBC URL, username, and password specified in the application.properties file.

## Running with Docker
To simplify deployment, you can build and run the application inside a Docker container:

## Build the Docker Image:

bash
docker build -t sports-api .
## Run the Container:

bash
docker run -p 8080:8080 sports-api
## API Endpoints
The following endpoints are available in the Sports API:

GET /api/sports: Retrieves a list of all supported sports.
GET /api/teams/{sport}: Fetches teams associated with a specific sport.
GET /api/stats/{teamId}: Provides detailed statistics for a given team.
Each endpoint returns data in JSON format and follows REST principles for consistent resource management.

## Java-Specific Details
Dependency Injection: Spring Boot’s @Autowired annotation is used extensively to manage dependencies across the application layers.
Entity Mapping: The @Entity and @Table annotations in the model layer define how Java objects are mapped to database tables.
Service Layer: Contains reusable business logic that ensures separation of concerns between controllers and repositories.
Custom Exception Handling: The @ControllerAdvice annotation is used to centralize and standardize error responses.
Unit Testing: JUnit and Spring’s testing framework are used to test controllers, services, and repositories.
Contribution Guidelines
Contributions are welcome! Follow these steps to contribute:

Fork the repository and create your branch:

bash

git checkout -b feature-name
Commit your changes and push them to your branch:

bash\
git commit -m "Description of changes"
git push origin feature-name
Open a pull request to merge changes into the main branch.

## License
This project is All Rights Reserved by Marina Kyr. No part of this repository, including code, documentation, or any other content, may be copied, modified, distributed, or used in any manner without explicit permission from the owner.

## Contact
For questions or support, open an issue in the repository or email Marina Kyr at marina.k.1998@gmail.com.
