<h1 align="center">Notes Service</h1>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()

</div>

---

<p align="center">
RESTful API that allows users to create, retrieve, update, and delete notes.
<br> Each note can consist of a title and a body
</p>

## Table of Contents

-   [Getting Started](#getting_started)
-   [Prerequisites](#prerequisites)
-   [Setup](#setup)
-   [Running the Application](#running_the_application)
-   [Using the API](#using_the_api)

## Getting Started <a name = "getting_started"></a>

This document provides a quick guide to setting up and using this Spring Boot API project.

## Prerequisites <a name = "prerequisites"></a>

-   Java Development Kit (JDK) 8 or later (https://www.oracle.com/java/technologies/downloads/)
-   Maven or Gradle build tool (This guide uses Maven) (https://maven.apache.org/download.cgi)
-   Integrated Development Environment (IDE) (Optional - IntelliJ IDEA, Eclipse, etc.)

## Setup <a name = "setup"></a>

Clone the project:

```
git clone https://github.com/ctpantoja-dev/notes-service.git

```

Navigate to the project directory:

```
cd <directory_to_notes_service>
```

Install dependencies:

```
mvn install
```

## Running the Application <a name = "running_the_application"></a>

Start the application:

```
mvn spring-boot:run
```

This will start the application on the default port (usually 8080).

## Using the API <a name = "using_the_api"></a>

-   The application exposes a RESTful API.
-   You can interact with the API using tools like Postman or curl.
-   Refer to the source code for specific API endpoints and their functionalities.
    <br>

### Retrieving a note

```
curl -X GET http://localhost:8080/notes/<note id>
```

### Retrieving all notes

```
curl -X GET http://localhost:8080/notes
```

### Creating a note

```
curl -X POST http://localhost:8080/notes -H "Content-Type: application/json" -d '{"title":"Test Title", "body": "Test Body"}'
```

### Updating a note

```
curl -X PUT http://localhost:8080/notes/<note id> -H "Content-Type: application/json" -d '{"title":"Updated Title", "body": "Updated Body"}'
```

### Deleting a note

```
curl -X DELETE http://localhost:8080/notes/<note id>
```
