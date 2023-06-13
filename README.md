# Atipera Recruitment  Task
This project is my implementation of the Atipera recruitment task 

This API allows you to retrieve information about GitHub repositories based on the provided username.
In response, you will receive data such as: Owner Login, Repository Name and name for each branch with last commit sha
Only repositories that are not forked will be returned in response.

## Usage:

### List user repositories with branches and last commit sha (JSON)

**Endpoint:** `http://localhost:8080/{username}`

**Method:** GET

**Headers:**
- Accept: application/json

**Request:**
- Path Parameters:
    - `username`: The GitHub username for which you want to retrieve the repositories with the requirements not fork.

**Response:**
The API will respond with a JSON object containing the following information for each repository:

- **Owner Login:** The login of the repository owner.
- **Repositories:** The name of the repository without fork.
- **Branches:** with name and last commit sha.

**Example response:**
```json
{
  "developLogin": "Bartek2463",
  "repositories": [
    {
      "repositoryName": "Recruitment-Positive",
      "branches": []
    },
    {
      "repositoryName": "Positive-Repo",
      "branches": [
        {
          "name": "develop",
          "commit": {
            "sha": "290c88aa65b883c14586f9a7f478443fc4b21550"
          }
        }
      ]
    },
```
### User Not Found (404)
If the requested GitHub user does not exist, the API will respond with a 404 status code and the following JSON object:

```json
{
    "status": 404,
    "message": "User not found"
}
```
### Unsupported Media Type (406)
If the request header "Accept" is set to "application/xml", the API will respond with a 406 status code and the following JSON object:

```json
{
    "status": 406,
    "message": "Invalid Accept header. Only 'application/json' is allowed."
}
```
## Getting Started
**To get started with the API, follow these steps:**

1. Clone the repository.
2. Install the required dependencies.
3. Run the application locally.
4. Send requests to the appropriate endpoints as described in the "Usage" section.

## Dependencies
**The API utilizes the following dependencies:**

+ Spring Boot: A framework for building Java applications.
+ Spring Web: Used for creating RESTful APIs.
+ Spring Cloud OpenFeign: Used for making HTTP requests to the GitHub API.
+ Lombok: Simplifies Java code by generating boilerplate code.
