# Sunbase
# Customer CRUD Application

## Project Overview

This project is a simple CRUD (Create, Read, Update, Delete) application for managing customers. It includes both backend and frontend components, with JWT authentication for secure access.

## Technologies Used

- **Backend**: Java, Spring Boot (or JSP Servlet)
- **Database**: MySQL
- **Frontend**: HTML, CSS, JavaScript (or any other preferred framework)

## Features

- Create a customer
- Update a customer
- Get a list of customers with pagination, sorting, and searching
- Get a single customer based on ID
- Delete a customer
- JWT Authentication


**Frontend Screens**

1.Login Screen: User login with JWT authentication.


2.Customer List Screen: Display list of customers with options to add, update, and delete.


3.Add New Customer: Form to add a new customer
### Example Customer Object

```json
{
  "first_name": "Sad",
  "last_name": "Naik",
  "street": "Ram Vilas Street",
  "address": "H no 15",
  "city": "Pune",
  "state": "Maharashtra",
  "email": "sam@gmail.com",
  "phone": "12789678"
}



**Phase 2 Extension**
Sync Button: Fetch customer list from a remote API and save/update them in the local database.


Method: POST
Body:
json
{
  "login_id" : "test@sunbasedata.com",
  "password" :"Test@678"
}
Response:
json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0QHN1bmJhc2VkYXRhLmNvbSIsImlhdCI6MTUxNjIzOTAyMn0.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
Get Customer List API:

Method: GET


