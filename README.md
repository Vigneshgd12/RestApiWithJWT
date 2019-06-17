# RestApiWithJWT
This project is a tutorial to understand JWT for Rest APIs and RestTemplate for accessing foreign APIs

The following are the APIs involved

GET "api/v1/employees" - for fetching all the employees

GET "api/v1/employee/{id}" - for fetching employee by Id

POST "api/v1/employee" - for adding new employee

PUT "api/v1/employee" - for updating the details of the employee 

DELETE "api/v1/employee/{id}" - for deleting the employee by id



All the APIs can be accesssed only after getting authenticated

This app has only one user whose credentials are 

username = user
password = password

You have to call the authenticate method inorder to get the token 

For ex.
Run the URL   http://localhost:8080/api/authenticate?username=user&password=password

to get the below token

Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzZWN1cmUtYXBpIiwiYXVkIjoic2VjdXJlLWFwcCIsInN1YiI6InVzZXIiLCJleHAiOjE1NjA3NDc4NDcsInJvbCI6WyJST0xFX1VTRVIiXX0.4SdIT_68PlWVT8InyOCBGD6yBGZwTQkk2bcgsBgqdJ9Io6qzZnGWOSTBy_awOm1JrkxiPQOe0eL3UR7IHUG4lg


Now you can use this token to access other APIs

The token has the details of username password the user's role and token expiry time
