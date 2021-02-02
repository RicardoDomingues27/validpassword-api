# validpassword-api

Web API that validates if a password is valid

Documentation available at http://localhost:8080/swagger-valid-password-api.html

```
Mandatory password:
Nine or more characters
At least 1 digit
At least 1 lowercase letter
At least 1 capital letter
At least 1 special character !@#$%^&*()-+
Do not have repeated characters within the set
```
----
Request Examples:

Password following the minimum requirements
```json
curl -X POST "http://localhost:8080/v1/password" 
      -H  "accept: application/json" 
      -H  "Content-Type: application/json" 
      -d "{\"text\":\"AbTp9!fok\"}"
```
Response:
```
true
```

 ----
 ```json
curl -X POST "http://localhost:8080/v1/password" 
      -H  "accept: application/json" 
      -H  "Content-Type: application/json" 
      -d "{\"text\":\"AbTp9 fok\"}"
```
Response:
```
false
```
----
 ```json
curl -X POST "http://localhost:8080/v1/password" 
      -H  "accept: application/json" 
      -H  "Content-Type: application/json" 
      -d "{}"
```
Response:
```
{
  "message": "Senha nao pode ser nula",
  "error": "NotNullPassword"
}
```
      
