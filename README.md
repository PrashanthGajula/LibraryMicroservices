# LibraryMicroservices

## SQL queries
Database Schema: library
```
Table: book
CREATE TABLE `library`.`book` (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(255) NOT NULL,
  `book_category` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE INDEX `book_name_UNIQUE` (`book_name` ASC) VISIBLE);
  ```
  
  ```
  Table: user
  CREATE TABLE `library`.`user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  ```
  
## Running multiple instances of a service in different ports.

Default way to run a service/java main method. It makes use of the default port or the port mentioned in the application.properties file
- java -jar movie-info-service-1.0.0.SNAPSHOT.jar

Run a service using a different port number:
- java -Dserver.port=8084 -jar movie-info-service-1.0.0.SNAPSHOT.jar

Running multiple instances of a service in different ports:
- Instance 1 : java -Dserver.port=8086 -jar movie-info-service-1.0.0.SNAPSHOT.jar
- Instance 2 : java -Dserver.port=8088 -jar movie-info-service-1.0.0.SNAPSHOT.jar
- Instance 3 : java -Dserver.port=8090 -jar movie-info-service-1.0.0.SNAPSHOT.jar

## Notes
1. Discovery Service URL: http://localhost:8761
2. Custom Queries in Spring Boot: https://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
3. Microservices 1: https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas
4. Microservices 2: https://www.youtube.com/watch?v=o8RO38KbWvA&list=PLqq-6Pq4lTTbXZY_elyGv7IkKrfkSrX5e
