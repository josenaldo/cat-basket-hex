# Cat Basket

Cat Basket is an application for cat adoption. It provides features for registering new cats and searching for cats available for adoption.

## Getting Started

These instructions will help you set up and run the Cat Basket application on your local machine.

### Prerequisites

Before you begin, you'll need the following:

- Java Development Kit (JDK) 17 or higher
- Maven (for building the project)
- MySQL Database

### Environment Configuration

1. Create a `.env` file in the root directory of your project.
2. Use the provided `.example.env` file as a template.
3. Update the database connection details in the `.env` file, including the url,  username and password if you wish to use custom configurations.

### Build and Run

To build and run the Cat Basket application, follow these steps:

1. Open a terminal and navigate to the project's root directory.

2. Build the project using Maven:

    ```bash
    mvn clean package
    ```

3. Run the application:

    ```bash
    java -jar target/cat-basket-1.0.0.jar
    ```
   
The application should now be accessible at `http://localhost:8080`.

## Features

Cat Basket currently provides the following features:

- Register a new cat for adoption.
- Search for cats available for adoption.
- Sort search results by various fields (e.g., name, gender, birth date).

## Usage

### Register a New Cat

To register a new cat for adoption, you can use the provided API endpoint:

> POST /cats

Provide the cat's information in the request body. See the API documentation for details on the required fields.

### Search for Cats

To search for cats available for adoption, you can use the following API endpoint:

> GET /cats

#### Sorting

You can specify the sorting order for the search results by providing a `sort` parameter in the request. Use the following format to specify sorting criteria:

> sort=field1,direction1|field2,direction2|...


- `field1`, `field2`, etc., represent the fields by which you want to sort the results.

- `direction1`, `direction2`, etc., represent the sort direction, which can be either "asc" (ascending) or "desc" (descending).

For example, to retrieve all cats sorted by "gender" in ascending order and then by "name" in ascending order, use the following URL:

> GET /cats?sort=gender,asc|name,asc


## Contributing

If you'd like to contribute to Cat Basket, please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
