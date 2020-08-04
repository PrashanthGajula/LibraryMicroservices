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

## References
1. Custom Queries in Spring Boot: https://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
2. Microservices 1: https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas
3. Microservices 2: https://www.youtube.com/watch?v=o8RO38KbWvA&list=PLqq-6Pq4lTTbXZY_elyGv7IkKrfkSrX5e
