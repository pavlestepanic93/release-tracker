# Release tracker
## Overview <br/>
* This application is a Java task solution to show the level of knowledge in the programming language <br /><br />
## Backend (Spring Boot) <br />
* CRUD (REST API) + search filter operations are exposed<br />
* Architecture is 3 layer architecture:<br>
   * Controller<br/>
   * Service (interface and implementation) <br />
   * Repository (interface) that extends JpaRepository<br /> <br />
  
## Database (PostgreSQL) <br />
* There is only one table that seems to be the most optimized.<br />
* Release statuses are represented (validated) through the enum<br />

## Tests (JUnit and Mockito)
* API endpoints are covered by the tests that can be executed throught the IDE, by clicking the play buttom from the class file - `ReleaseControllerTest`

## Setup
* Before starting, the database needs to be created (a new one) and needs to be called rtapp<br />
* After that `application.properties` file in the project needs to be edited in terms of adding your username password from the PostgreSQL in to the next two rows (after "=" mark), and application should be ready for using<br />
```
spring.datasource.username=
spring.datasource.password=
```
## API Documentation
* In order to use the Swagger UI (after starting the application), go to URL: http://localhost:8080/swagger-ui.html#/<br />
