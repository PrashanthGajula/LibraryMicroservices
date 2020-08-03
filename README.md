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
