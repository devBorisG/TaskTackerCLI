# Task Tracker CLI

### This project idea was taken form https://roadmap.sh/projects/task-tracker  

## Table of Contents
- [Overview](#overview)
- [Project Structure](#project-structure)
    - [Key Directories and Files](#key-directories-and-files)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Building the Project](#building-the-project)
    - [Running the Application](#running-the-application)
    - [Running the Tests](#running-the-tests)
- [Usage](#usage)
    - [Commands](#commands)
    - [Examples](#examples)
- [Contributing](#contributing)

## Overview
Task Tracker CLI is a command-line interface application designed to manage tasks efficiently. It allows users to create, update, delete, and retrieve tasks with various statuses. The application is built using Java and Kotlin, leveraging Gradle for build automation.

## Project Structure
The project is organized into several layers following the principles of clean architecture:

- **Application Layer**: Contains use cases that encapsulate the business logic.
- **Domain Layer**: Defines the core entities and repository interfaces.
- **Infrastructure Layer**: Implements the repository interfaces and handles external interactions (e.g., JSON file storage).

### Key Directories and Files
- `src/main/java/boris/enterprice/application/task`: Contains use case implementations.
- `src/main/java/boris/enterprice/domain/model`: Defines the domain entities.
- `src/main/java/boris/enterprice/domain/repository`: Contains repository interfaces.
- `src/main/java/boris/enterprice/infrastructure/adapters/repository/json`: Implements the repository interfaces using JSON file storage.
- `src/test/java/boris/enterprice`: Contains unit tests for the application.

## Getting Started

### Prerequisites
- Java 11 or higher
- Gradle 7.0 or higher

### Building the Project
To build the project, run the following command:

```sh
  gradle shadowJar
```

### Running the Application
To run the application, execute the following command:

```sh
  ./run.bat
```

### Running the Tests
To run the tests, execute the following command:

```sh
  gradle test
```

## Usage

### Commands
The application supports the following commands:

- `task-cli add <description>`: Adds a new task with the specified description, description must be enclosed in double quotes.
- `task-cli update <id> <description>`: Updates the description of the task with the specified ID.
- `task-cli delete <id>`: Deletes the task with the specified ID.
- `task-cli list-all`: Lists all tasks.
- `task-cli list <status>`: Lists tasks with the specified status.
- `task-cli mark-done <id>`: Marks the task with the specified ID as done.
- `task-cli mark-in-progress <id>`: Marks the task with the specified ID as in progress. 
- `exit`: Exits the application.
- `help`: Displays the list of commands.

### Examples
- Add a new task:
  ```sh
  task-cli add "Implement feature X"
  ```
- Update a task:
  ```sh
    task-cli update 1 "Implement feature Y"
    ```
- Delete a task:
  ```sh
  task-cli delete 1
  ```
- List all tasks:
  ```sh
    task-cli list-all
    ```
- List tasks with a specific status:
- ```sh
    task-cli list in-progress
    ```
- Mark a task as done:
- ```sh
    task-cli mark-done 1
    ```
- Mark a task as in progress:
- ```sh
    task-cli mark-in-progress 1
    ```
- Display the list of commands:
- ```sh
    help
    ```
- Exit the application:
- ```sh
    exit
    ```
  
## Contributing
Contributions are welcome! For major changes, please open an issue first to discuss what you would like to change.
  
